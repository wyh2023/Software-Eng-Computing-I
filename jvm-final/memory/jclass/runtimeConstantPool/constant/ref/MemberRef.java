package com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.ref;

import com.njuse.jvmfinal.classloader.classfileparser.constantpool.info.MemberRefInfo;
import com.njuse.jvmfinal.memory.jclass.JClass;
import com.njuse.jvmfinal.memory.jclass.Method;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.RuntimeConstantPool;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.tuple.Pair;

@Getter
@Setter
public abstract class MemberRef extends SymRef {
    protected String name;
    protected String descriptor;

    public MemberRef(RuntimeConstantPool runtimeConstantPool, MemberRefInfo info) {
        this.runtimeConstantPool = runtimeConstantPool;
        this.className = info.getClassName();
        Pair<String, String> nameAndType = info.getNameAndDescriptor();
        this.name = nameAndType.getKey();
        this.descriptor = nameAndType.getValue();
    }

    public Method lookUpMethodInInterfaces(JClass[] interfaces, String name, String descriptor){
        //if(interfaces == null)return null;
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

}
