package com.njuse.jvmfinal.classloader.classfileparser.attribute.smta;

import com.njuse.jvmfinal.classloader.classfileparser.BuildUtil;

public class SameLocals1StackItemFramExtended extends StackMapFrame {
    private int offsetDelta;
    private VerificationTypeInfo[] stack = new VerificationTypeInfo[1];

    public SameLocals1StackItemFramExtended(int frameType, BuildUtil buildUtil) {
        super(frameType);
        offsetDelta = buildUtil.getU2();
        stack[0] = VerificationTypeInfo.read(buildUtil);
    }

    @Override
    public int getOffsetDelta() {
        return offsetDelta;
    }
}
