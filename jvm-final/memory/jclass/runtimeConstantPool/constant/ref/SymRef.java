package com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.ref;

import com.njuse.jvmfinal.memory.jclass.JClass;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.RuntimeConstantPool;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.Constant;
import lombok.Getter;
import lombok.Setter;
import org.omg.CORBA.PUBLIC_MEMBER;

@Getter
@Setter
public abstract class SymRef implements Constant {
    public RuntimeConstantPool runtimeConstantPool;
    public String className;    //format : java/lang/Object
    public JClass clazz;

    public JClass resolveClass() throws ClassNotFoundException {
        if(this.clazz == null){
            this.resolveClassRef();
        }
        return this.clazz;
    }

    public void resolveClassRef() throws ClassNotFoundException {
        JClass D = this.runtimeConstantPool.getClazz();
        JClass C = D.getClassLoader().loadClass(this.className);
        if (!C.isAccessibleTo(D)) throw new IllegalAccessError();
        this.clazz = C;
    }
}
