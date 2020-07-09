package com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.ref;

import com.njuse.jvmfinal.classloader.classfileparser.constantpool.info.MethodrefInfo;
import com.njuse.jvmfinal.memory.jclass.JClass;
import com.njuse.jvmfinal.memory.jclass.Method;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.RuntimeConstantPool;
import lombok.Getter;
import lombok.Setter;

import java.awt.font.TextHitInfo;

@Getter
@Setter
public class MethodRef extends MemberRef {
    private Method method;

    public MethodRef(RuntimeConstantPool runtimeConstantPool, MethodrefInfo methodrefInfo) {
        super(runtimeConstantPool, methodrefInfo);
    }

    public Method resolveMethod() throws ClassNotFoundException {
        if(this.method == null){
            resolveMethodRef();
        }
        return this.method;
    }

    public Method resolveMethodRef(JClass clazz) {
        Method m = lookUpMethodInClass(clazz, name, descriptor);
        if(m == null){
            m = lookUpMethodInInterface(clazz, name, descriptor);
        }
        this.method = m;
        return this.method;
    }

    public void resolveMethodRef() throws ClassNotFoundException {
        JClass D = this.runtimeConstantPool.getClazz();
        JClass C = this.resolveClass();
        if(C.isInterface()){
            throw new IncompatibleClassChangeError();
        }

        Method method = lookUpMethod(C, this.name, this.descriptor);
        if(method == null) throw new NoSuchMethodError();
        if(!method.isAccessibleTo(D)) throw new IllegalAccessError();
        this.method = method;
    }

    public Method lookUpMethod(JClass jClass, String name, String descriptor){
        Method method = lookUpMethodInClasses(jClass, name, descriptor);
        if(method == null)
            method = lookUpMethodInInterfaces(jClass.getInterfaces(), name, descriptor);
        return method;
    }

    public Method lookUpMethodInClasses(JClass jClass, String name, String descriptor){
        for(JClass i = jClass; i!=null; i=i.getSuperClass()){
            for(Method m : i.getMethods()){
                if(m.name.equals(name) && m.descriptor.equals(descriptor)){
                    return m;
                }
            }
        }
        return null;
    }

    private Method lookUpMethodInClass(JClass clazz, String name, String descriptor) {
        for(JClass c = clazz; c != null; c = c.getSuperClass()){
            for(Method m : c.getMethods()){
                if(m.getName().equals(name) && m.getDescriptor().equals(descriptor)){
                    return m;
                }
            }
        }
        return null;
    }

    private Method lookUpMethodInInterface(JClass clazz, String name, String descriptor) {
        for(JClass in : clazz.getInterfaces()){
            lookUpMethodInClass(in, name, descriptor);
        }
        return this.method;
    }

}
