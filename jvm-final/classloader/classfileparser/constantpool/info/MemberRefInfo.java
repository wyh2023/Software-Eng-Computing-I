package com.njuse.jvmfinal.classloader.classfileparser.constantpool.info;

import com.njuse.jvmfinal.classloader.classfileparser.constantpool.ConstantPool;
import org.apache.commons.lang3.tuple.Pair;

public abstract class MemberRefInfo extends ConstantPoolInfo {

    public MemberRefInfo(ConstantPool myCP) {
        super(myCP);
    }


    public abstract String getClassName();

    protected String getClassName(int idx) {
        return ((ClassInfo) myCP.get(idx)).getClassName();
    }


    public abstract Pair<String, String> getNameAndDescriptor();
}
