package com.njuse.jvmfinal.classloader.classfileparser.attribute.smta;

import com.njuse.jvmfinal.classloader.classfileparser.BuildUtil;
import com.njuse.jvmfinal.classloader.classfileparser.attribute.AttributeInfo;

public class StackMapTableAttribute extends AttributeInfo {
    private int numberOfEntries;
    private StackMapFrame[] entries;

    public StackMapTableAttribute(BuildUtil buildUtil, int index, int length) {
        super(index, length);
        numberOfEntries = buildUtil.getU2();
        entries = new StackMapFrame[numberOfEntries];
        for (int i = 0; i < entries.length; i++) {
            entries[i] = StackMapFrame.read(buildUtil);
        }

    }
}
