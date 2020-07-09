package com.njuse.jvmfinal.classloader.classfileparser.constantpool.info;

import com.njuse.jvmfinal.classloader.classfileparser.constantpool.ConstantPool;
import org.apache.commons.lang3.tuple.Pair;

public class MethodrefInfo extends MemberRefInfo {
    private int classIndex;
    private int nameAndTypeIndex;

    public MethodrefInfo(ConstantPool constantPool, int classIndex, int nameAndTypeIndex) {
        super(constantPool);
        this.classIndex = classIndex;
        this.nameAndTypeIndex = nameAndTypeIndex;
        super.tag = ConstantPoolInfo.METHOD_REF;
    }


    public String getClassName() {
        return getClassName(classIndex);
    }


    public Pair<String, String> getNameAndDescriptor() {
        return ((NameAndTypeInfo) myCP.get(nameAndTypeIndex)).getNameAndDescriptor();
    }
}
