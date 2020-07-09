package com.njuse.jvmfinal.classloader.classfileparser.attribute;

import com.njuse.jvmfinal.classloader.classfileparser.BuildUtil;

public class ExceptionsAttribute extends AttributeInfo {
    private int numberOfExceptions;
    private int[] exceptionIndexTable;

    public ExceptionsAttribute(BuildUtil buildUtil, int index, int length) {
        super(index, length);
        numberOfExceptions = buildUtil.getU2();
        this.exceptionIndexTable = new int[numberOfExceptions];
        for (int i = 0; i < this.exceptionIndexTable.length; i++) {
            exceptionIndexTable[i] = buildUtil.getU2();
        }
    }
}
