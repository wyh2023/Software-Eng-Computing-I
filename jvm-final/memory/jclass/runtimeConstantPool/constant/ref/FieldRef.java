package com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.ref;

import com.njuse.jvmfinal.classloader.classfileparser.constantpool.info.FieldrefInfo;
import com.njuse.jvmfinal.memory.jclass.Field;
import com.njuse.jvmfinal.memory.jclass.JClass;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.RuntimeConstantPool;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldRef extends MemberRef {
    private Field field;

    public FieldRef(RuntimeConstantPool runtimeConstantPool, FieldrefInfo fieldrefInfo) {
        super(runtimeConstantPool, fieldrefInfo);
    }

    public Field resolveField() throws ClassNotFoundException {
        if(this.field == null){
            this.resolveFieldRef();
        }
        return this.field;
    }

    public void resolveFieldRef() throws ClassNotFoundException {
        JClass D = this.getRuntimeConstantPool().getClazz();
        JClass C = this.resolveClass();
        Field field = lookupField(C, this.getName(), this.getDescriptor());
        if (field == null) throw new NoSuchFieldError();
        if (!field.isAccessibleTo(D)) throw new IllegalAccessError();
        this.field = field;
    }

    public Field lookupField(JClass jClass, String name, String descriptor){
        for(Field field : jClass.getFields()){
            if(field.getName().equals(name) && field.getDescriptor().equals(descriptor)){
                return field;
            }
        }
        if(jClass.getInterfaces() != null){
            for(JClass interfaces : jClass.getInterfaces()){
                Field field = lookupField(interfaces, name, descriptor);
                if(field != null) return field;
            }
        }
        if(jClass.getSuperClass() != null){
            return lookupField(jClass.getSuperClass(), name, descriptor);
        }
        return null;
    }
}
