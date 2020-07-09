package com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.ref;

import com.njuse.jvmfinal.classloader.classfileparser.constantpool.info.ClassInfo;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.RuntimeConstantPool;

public class ClassRef extends SymRef {
    public ClassRef(RuntimeConstantPool runtimeConstantPool, ClassInfo classInfo) {
        this.runtimeConstantPool = runtimeConstantPool;
        this.className = classInfo.getClassName();
    }

}
