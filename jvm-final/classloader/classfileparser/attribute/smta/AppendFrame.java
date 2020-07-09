package com.njuse.jvmfinal.classloader.classfileparser.attribute.smta;

import com.njuse.jvmfinal.classloader.classfileparser.BuildUtil;

public class AppendFrame extends StackMapFrame {
    private int offsetDelta;
    private VerificationTypeInfo[] locals;

    public AppendFrame(int frameType, BuildUtil buildUtil) {
        super(frameType);
        offsetDelta = buildUtil.getU2();
        locals = new VerificationTypeInfo[frameType - 251];
        for (int i = 0; i < locals.length; i++) {
            locals[i] = VerificationTypeInfo.read(buildUtil);
        }
    }

    @Override
    public int getOffsetDelta() {
        return offsetDelta;
    }
}
