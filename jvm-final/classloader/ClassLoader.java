package com.njuse.jvmfinal.classloader;

import com.njuse.jvmfinal.classloader.classfileparser.ClassFile;
import com.njuse.jvmfinal.classloader.classreader.Entry;
import com.njuse.jvmfinal.memory.heap.NullObject;
import com.njuse.jvmfinal.memory.heap.Vars;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.wrapper.DoubleWrapper;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.wrapper.FloatWrapper;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.wrapper.IntWrapper;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.wrapper.LongWrapper;
import com.njuse.jvmfinal.runtime.Slot;
import com.njuse.jvmfinal.memory.jclass.Field;
import com.njuse.jvmfinal.memory.jclass.JClass;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.RuntimeConstantPool;

import java.io.IOException;
import java.util.HashMap;

public class ClassLoader {
    public Classpath cp;
    public HashMap<String, JClass> classHashMap;

    public ClassLoader(Classpath classpath){
        this.cp = classpath;
        this.classHashMap = new HashMap<>();
    }

    public JClass loadClass(String className) throws ClassNotFoundException {
        if(this.classHashMap.containsKey(className)){
            return this.classHashMap.get(className);
        }
        if(className.charAt(0) == '['){
            return this.loadArrayClass(className);
        }
        return this.loadNonArrayClass(className);
    }

    public JClass loadArrayClass(String className) {
        JClass jClass = new JClass();
        jClass.setAccessFlags((short)1);
        jClass.setName(className);
        jClass.setClassLoader(this);
        try {
            jClass.startInit();
            jClass.setSuperClass(this.loadClass("java/lang/Object"));
            //jClass.setInterfaces(new JClass[]{});
            JClass[] interfaces = new JClass[]{this.loadClass("java/lang/Cloneable"),
                    this.loadClass("java/io/Serializable")};
            jClass.setInterfaces(interfaces);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        this.classHashMap.put(className, jClass);
        return jClass;
    }

    public JClass loadNonArrayClass(String className) throws ClassNotFoundException{
        try {
            byte[] data = this.cp.readClass(className).getLeft();
            Entry entry = this.cp.readClass(className).getRight();
            JClass ret = this.defineClass(data);
            link(ret);
            //System.out.printf("Load Class: %s, entry: %s\n", className, entry.toString());
            return ret;
        } catch (IOException e){
            throw new ClassNotFoundException();
        }
    }

    public JClass defineClass(byte[] data) throws ClassNotFoundException {
        JClass jClass = parseClass(data);
        jClass.setClassLoader(this);
        resolveSuperClass(jClass);
        resolveInterfaces(jClass);
        this.classHashMap.put(jClass.getName(), jClass);
        return jClass;
    }

    public void link(JClass jClass){
        verify(jClass);
        prepare(jClass);
    }

    public JClass parseClass(byte[] data){
        ClassFile classFile = new ClassFile(data);
        return new JClass(classFile);
    }

    public void resolveSuperClass(JClass jClass) throws ClassNotFoundException {
        if(!jClass.getName().equals("java/lang/Object")){
            jClass.setSuperClass(jClass.getClassLoader().loadClass(jClass.getSuperClassName()));
        }
    }

    public void resolveInterfaces(JClass jClass) throws ClassNotFoundException {
        int len = jClass.getInterfaceNames().length;
        if(len > 0){
            JClass[] interfaces = new JClass[len];
            jClass.setInterfaces(interfaces);
            for(int i=0; i<len; i++){
                jClass.getInterfaces()[i] = jClass.getClassLoader().loadClass(jClass.getInterfaceNames()[i]);
            }
        }
    }

    public void verify(JClass jClass){}

    public void prepare(JClass jClass){
        calInstanceFieldSlotIDs(jClass);
        calStaticFieldSlotIDs(jClass);
        allocAndInitStaticVars(jClass);
    }

    public void calInstanceFieldSlotIDs(JClass jClass){
        int slotID = 0;
        if(jClass.getSuperClass() != null){
            slotID = jClass.getSuperClass().getInstanceSlotCount();
        }
        for(Field field : jClass.getFields()){
            if(!field.isSTATIC()){
                field.setSlotID(slotID);
                slotID++;
                if(field.isLongOrDouble()){
                    slotID++;
                }
            }
        }
        jClass.setInstanceSlotCount(slotID);
    }

    public void calStaticFieldSlotIDs(JClass jClass){
        int slotID = 0;
        for(Field field : jClass.getFields()){
            if(field.isSTATIC()){
                field.setSlotID(slotID);
                slotID++;
                if(field.isLongOrDouble()){
                    slotID++;
                }
            }
        }
        jClass.setStaticSlotCount(slotID);
    }

    public void allocAndInitStaticVars(JClass jClass){
        Vars staticVars = new Vars(jClass.getStaticSlotCount());
        jClass.setStaticVars(staticVars);
        for(Field field : jClass.getFields()){
            if(field.isSTATIC() && field.isFINAL()){
                initStaticFinalVar(jClass, field);
            }
        }
    }

    public void initStaticFinalVar(JClass jClass, Field field){
        Vars vars = jClass.getStaticVars();
        RuntimeConstantPool RTCP = jClass.getRuntimeConstantPool();
        int CP_index = field.getConstValueIndex();
        int slotID = field.getSlotID();

        if (field.getConstValueIndex() != 0) {
            switch (field.descriptor) {
                case "Z":
                case "B":
                case "C":
                case "S":
                case "I":
                    int IntVal = ((IntWrapper) RTCP.getConstant(CP_index)).getValue();
                    vars.setInt(slotID, IntVal);
                    break;
                case "D":
                    double DoubleVal = ((DoubleWrapper) RTCP.getConstant(CP_index)).getValue();
                    vars.setDouble(slotID, DoubleVal);
                    break;
                case "J":
                    long LongVal = ((LongWrapper) RTCP.getConstant(CP_index)).getValue();
                    vars.setLong(slotID, LongVal);
                    break;
                case "F":
                    float FloatVal = ((FloatWrapper) RTCP.getConstant(CP_index)).getValue();
                    vars.setFloat(slotID, FloatVal);
                    break;
                case "Ljava/lang/String":
                    throw new RuntimeException("Please Fix the ClassLoader : initStaticFinalVar");
            }
        } else {
            initDefaultValue(jClass, field, CP_index);
        }
    }

    private void initDefaultValue(JClass clazz, Field field, int index) {
        Vars vars = clazz.getStaticVars();
        switch (field.descriptor) {
            case "Z":
            case "B":
            case "C":
            case "S":
            case "I":
                vars.setInt(index, 0);
                break;
            case "D":
                vars.setDouble(index, 0.0d);
                break;
            case "J":
                vars.setLong(index, 0L);
                break;
            case "F":
                vars.setFloat(index, 0.0f);
                break;
            default:
                vars.setRef(index, new NullObject());
        }
    }
}
