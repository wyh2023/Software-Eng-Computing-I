package com.njuse.jvmfinal.memory.jclass;

import com.njuse.jvmfinal.classloader.ClassLoader;
import com.njuse.jvmfinal.classloader.classfileparser.ClassFile;
import com.njuse.jvmfinal.classloader.classfileparser.FieldInfo;
import com.njuse.jvmfinal.classloader.classfileparser.MethodInfo;
import com.njuse.jvmfinal.classloader.classfileparser.constantpool.ConstantPool;
import com.njuse.jvmfinal.memory.heap.ArrayObject;
import com.njuse.jvmfinal.memory.heap.MyObject;
import com.njuse.jvmfinal.memory.heap.NonArrayObject;
import com.njuse.jvmfinal.memory.heap.Vars;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.RuntimeConstantPool;
import com.njuse.jvmfinal.runtime.MyFrame;
import com.njuse.jvmfinal.runtime.MyThread;
import com.njuse.jvmfinal.runtime.Slot;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.util.HashMap;

@Getter
@Setter
public class JClass {
    private short accessFlags;
    private String name;
    private String superClassName;
    private String[] interfaceNames;
    private RuntimeConstantPool runtimeConstantPool;
    private Field[] fields;
    private Method[] methods;
    private ClassLoader classLoader;
    private JClass superClass;
    private JClass[] interfaces;
    private int instanceSlotCount;
    private int staticSlotCount;
    private Vars staticVars;
//    private Vars staticVars; // 请自行设计数据结构
//    private InitState initState; // 请自行设计初始化状态
    private boolean initStarted;
    private static final HashMap<String, String> Descriptor_Map = new HashMap<String, String>(){
        {
            put("void", "V");
            put("boolean", "Z");
            put("byte", "B");
            put("short", "S");
            put("int", "I");
            put("long", "J");
            put("char", "C");
            put("float", "F");
            put("double", "D");
        }
    };

    public JClass(ClassFile classFile) {
        this.accessFlags = classFile.getAccessFlags();
        this.name = classFile.getClassName();
        if (!this.name.equals("java/lang/Object")) {
            // index of super class of java/lang/Object is 0
            this.superClassName = classFile.getSuperClassName();
        } else {
            this.superClassName = "";
        }
        this.interfaceNames = classFile.getInterfaceNames();
        this.fields = parseFields(classFile.getFields());
        this.methods = parseMethods(classFile.getMethods());
        this.runtimeConstantPool = parseRuntimeConstantPool(classFile.getConstantPool());
    }

    public JClass() {
    }

    private Field[] parseFields(FieldInfo[] info) {
        int len = info.length;
        fields = new Field[len];
        for (int i = 0; i < len; i++) {
            fields[i] = new Field(info[i], this);
        }
        return fields;
    }

    private Method[] parseMethods(MethodInfo[] info) {
        int len = info.length;
        methods = new Method[len];
        for (int i = 0; i < len; i++) {
            methods[i] = new Method(info[i], this);
        }
        return methods;
    }

    private RuntimeConstantPool parseRuntimeConstantPool(ConstantPool cp) {
        return new RuntimeConstantPool(cp, this);
    }

    public boolean isPublic(){
        return (this.getAccessFlags() & AccessFlags.ACC_PUBLIC) != 0;
    }

    public boolean isPrivate() {
        return (this.getAccessFlags() & AccessFlags.ACC_PRIVATE) != 0;
    }

    public boolean isProtected() {
        return (this.getAccessFlags() & AccessFlags.ACC_PROTECTED) != 0;
    }

    public boolean isSTATIC() {
        return (this.getAccessFlags() & AccessFlags.ACC_STATIC) != 0;
    }

    public boolean isFINAL() {
        return (this.getAccessFlags() & AccessFlags.ACC_FINAL) != 0;
    }

    public boolean isAbstract() {
        return (this.getAccessFlags() & AccessFlags.ACC_ABSTRACT) != 0;
    }

    public boolean isAccessibleTo(JClass caller) {
        return this.isPublic() || this.getPackageName().equals(caller.getPackageName());
    }

    public boolean isAccSuper() {
        return 0 != (this.accessFlags & 32);
    }

    public boolean isInterface() {
        return 0 != (this.accessFlags & 512);
    }

    public boolean isChildOf(JClass targetClass){
        for(JClass jClass = this.getSuperClass(); jClass != null; jClass = jClass.getSuperClass()){
            if(jClass == targetClass){
                return true;
            }
        }
        return false;
    }

    public boolean isArray(){
        return this.name.charAt(0) == '[';
    }

    public String getPackageName(){
        int index = name.lastIndexOf('/');
        if (index >= 0) return name.substring(0, index);
        else return "";
    }

    public MyObject newObject(){
        return new NonArrayObject(this);
    }

    public MyObject newArrayObject(int len){
        if(!this.isArray()) throw new RuntimeException("Not array class: " + this.name);
        switch (this.name){
            case "[Z":
            case "[B":
            case "[C":
            case "[S":
            case "[I":
                return new ArrayObject(this, new int[len]);
            case "[J":
                return new ArrayObject(this, new long[len]);
            case "[F":
                return new ArrayObject(this, new float[len]);
            case "[D":
                return new ArrayObject(this, new double[len]);
            default:
                return new ArrayObject(this, new MyObject[len]);
        }
    }

    public JClass ArrayRefClass() throws ClassNotFoundException {
        //String
        String arrayName = getArrayClassName(this.getName());
        return this.getClassLoader().loadClass(arrayName);
    }

    public String getArrayClassName(String className){
        return "[" + toDescriptor(className);
    }

    public boolean isAssignableFrom(JClass src) throws ClassNotFoundException {
        JClass tgt = this;
        if (tgt == src){
            return true;
        }
        if(!src.isArray()){
            if(!src.isInterface()){
                if(!tgt.isInterface()){
                    return src.isChildOf(tgt);
                } else {
                    return src.isImplenments(tgt);
                }
            } else {
                if(!tgt.isInterface()) {
                    return tgt.getName().equals("java/lang/Object");
                } else {
                    return tgt.isSubInterfaceOf(src);
                }
            }
        } else {
            if(!tgt.isArray()){
                if(!tgt.isInterface()){
                    return tgt.getName().equals("java/lang/Object");
                } else {
                    return tgt.getName().equals("java/lang/Cloneable") || tgt.getName().equals("java/io/Serializable");
                }
            } else {
                JClass comSrc = src.componentClass();
                JClass comtgt = tgt.componentClass();
                return comSrc == comtgt || comtgt.isAssignableFrom(comSrc);
            }
        }
    }

    public boolean isImplenments(JClass target){
        for(JClass i = this; i != null; i = i.getSuperClass()){
            if(i.getInterfaces() == null) continue;
            for(JClass x : i.getInterfaces()){
                if( x == target || x.isSubInterfaceOf(target)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSubInterfaceOf(JClass target){
        for(JClass x : this.getInterfaces()){
            if( x == target || x.isSubInterfaceOf(target)){
                return true;
            }
        }
        return false;
    }

    public String toDescriptor(String className){
        if (className.charAt(0) == '['){
            return className;
        }
        if(Descriptor_Map.containsKey(className)){
            return Descriptor_Map.get(className);
        }
        return "L" + className + ";";
    }

    public Method getMainMethod(){
        return this.getStaticMethod("main", "([Ljava/lang/String;)V");
    }

    public Method getStaticMethod(String name, String descriptor){
        for(Method method : this.getMethods()){
            if(method.isSTATIC()){
                if(method.name.equals(name) && method.descriptor.equals(descriptor)){
                    return method;
                }
            }
        }
        return null;
    }

    public boolean getInitStarted(){
        return this.initStarted;
    }

    public void startInit(){
        this.initStarted = true;
    }

    public void initClass(MyThread thread, JClass clazz) {
        clazz.startInit();
        scheduleClinit(thread, clazz);
        initSuperClass(thread, clazz);
    }

    public void scheduleClinit(MyThread thread, JClass jClass){
        Method clinit = jClass.getClinit();
        if(clinit != null){
            MyFrame myFrame = thread.newFrame(clinit);
            thread.pushFrame(myFrame);
        }
    }

    public void initSuperClass(MyThread thread, JClass clazz){
        if( clazz.getSuperClass() != null && !clazz.getSuperClass().getInitStarted() ) {
            initClass(thread, clazz.getSuperClass());
        }
    }

    public Method getClinit(){
        return this.getStaticMethod("<clinit>", "()V");
    }

    public JClass componentClass() throws ClassNotFoundException {
        String componentClassName = getComponentClassName(this.name);
        return this.getClassLoader().loadClass(componentClassName);
    }

    public String getComponentClassName(String className){
        if(className.charAt(0) == '['){
            String componentDescriptor = className.substring(1);
            return descriptor2Name(componentDescriptor);
        }
        throw new RuntimeException("Not array: " + className);
    }

    public String descriptor2Name(String descriptor){
        if (descriptor.charAt(0) == '['){
            return descriptor;
        }
        if (descriptor.charAt(0) == 'L'){
            return descriptor.substring(1, descriptor.length()-1);
        }
        if (Descriptor_Map.containsKey(descriptor)){
            return this.name;
        }
        throw new RuntimeException("Invalid descriptor: " + descriptor);
    }
}
