package com.njuse.jvmfinal.classloader.classfileparser.attribute.smta;

import com.njuse.jvmfinal.classloader.classfileparser.BuildUtil;

public class ChopFrame extends StackMapFrame {
    private int offsetDelta;

    public ChopFrame(int frameType, BuildUtil buildUtil) {
        super(frameType);
        offsetDelta = buildUtil.getU2();
    }

    @Override
    public int getOffsetDelta() {
        return offsetDelta;
    }
}
