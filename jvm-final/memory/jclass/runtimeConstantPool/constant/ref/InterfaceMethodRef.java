package com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.ref;

import com.njuse.jvmfinal.classloader.classfileparser.constantpool.info.InterfaceMethodrefInfo;
import com.njuse.jvmfinal.memory.jclass.JClass;
import com.njuse.jvmfinal.memory.jclass.Method;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.RuntimeConstantPool;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InterfaceMethodRef extends MemberRef {
    private Method method;

    public InterfaceMethodRef(RuntimeConstantPool runtimeConstantPool, InterfaceMethodrefInfo interfaceMethodrefInfo) {
        super(runtimeConstantPool, interfaceMethodrefInfo);
        //method
    }

    public Method resolveInterfaceMethod() throws ClassNotFoundException {
        if(this.method == null){
            this.resolveInterfaceMethodRef();
        }
        return this.method;
    }

    public Method resolveInterfaceMethodRef(JClass clazz) {
        Method method = lookUpInterfaceMethod(clazz, this.name, this.descriptor);
        return method;
    }

    public void resolveInterfaceMethodRef() throws ClassNotFoundException {
        JClass D = this.runtimeConstantPool.getClazz();
        JClass C = this.resolveClass();
        if(!C.isInterface()){
            throw new IncompatibleClassChangeError();
        }

        Method method = lookUpInterfaceMethod(C, this.name, this.descriptor);
        if(method == null) throw new NoSuchMethodError();
        if(!method.isAccessibleTo(D)) throw new IllegalAccessError();
        this.method = method;
    }

    public Method lookUpInterfaceMethod(JClass itface, String name, String descriptor){
        for(Method m : itface.getMethods()){
            if(m.name.equals(name) && m.descriptor.equals(descriptor)){
                return m;
            }
        }
        return lookUpMethodInInterfaces(itface.getInterfaces(), name, descriptor);
    }

    /*
    public Method lookUpMethodInInterfaces(JClass[] interfaces, String name, String descriptor){
        for(JClass i : interfaces){
            for(Method m : i.getMethods()){
                if(m.name.equals(name) && m.descriptor.equals(descriptor)){
                    return m;
                }
            }
            Method method = lookUpMethodInInterfaces(i.getInterfaces(), name, descriptor);
            if(method != null) return method;
        }
        return null;
    }
     */

}
