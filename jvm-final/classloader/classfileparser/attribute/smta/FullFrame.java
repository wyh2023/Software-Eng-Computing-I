package com.njuse.jvmfinal.classloader.classfileparser.attribute.smta;

import com.njuse.jvmfinal.classloader.classfileparser.BuildUtil;

public class FullFrame extends StackMapFrame {
    private int offsetDelta;
    private int numberOfLocals;
    private VerificationTypeInfo[] locals;
    private int numberOfStackItems;
    private VerificationTypeInfo[] stack;

    public FullFrame(int frameType, BuildUtil buildUtil) {
        super(frameType);
        offsetDelta = buildUtil.getU2();
        numberOfLocals = buildUtil.getU2();
        locals = new VerificationTypeInfo[numberOfLocals];
        for (int i = 0; i < locals.length; i++) {
            locals[i] = VerificationTypeInfo.read(buildUtil);
        }
        numberOfStackItems = buildUtil.getU2();
        stack = new VerificationTypeInfo[numberOfStackItems];
        for (int i = 0; i < stack.length; i++) {
            stack[i] = VerificationTypeInfo.read(buildUtil);
        }
    }

    @Override
    public int getOffsetDelta() {
        return offsetDelta;
    }
}
