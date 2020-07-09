package com.njuse.jvmfinal.classloader.classfileparser.attribute.smta;

import com.njuse.jvmfinal.classloader.classfileparser.BuildUtil;

public class SameLocals1StackItemFrame extends StackMapFrame {
    private VerificationTypeInfo[] stack = new VerificationTypeInfo[1];

    public SameLocals1StackItemFrame(int frameType, BuildUtil buildUtil) {
        super(frameType);
        stack[0] = VerificationTypeInfo.read(buildUtil);
    }

    @Override
    public int getOffsetDelta() {
        return super.frameType - 64;
    }
}
