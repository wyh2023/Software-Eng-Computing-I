package com.njuse.jvmfinal.classloader.classfileparser.constantpool.info;

import com.njuse.jvmfinal.classloader.classfileparser.constantpool.ConstantPool;

public class MethodTypeInfo extends ConstantPoolInfo {
    private int descriptorIndex;

    public MethodTypeInfo(ConstantPool constantPool, int descriptorIndex) {
        super(constantPool);
        this.descriptorIndex = descriptorIndex;
        super.tag = ConstantPoolInfo.METHOD_TYPE;
    }
}
