package com.njuse.jvmfinal.classloader.classfileparser.attribute.smta;

import com.njuse.jvmfinal.classloader.classfileparser.BuildUtil;

public class StackMapFrame {
    protected final int frameType;

    static StackMapFrame read(BuildUtil buildUtil) {
        int frameType = buildUtil.getU1();
        if (frameType <= 63) {
            return new SameFrame(frameType);
        } else if (frameType <= 127) {
            return new SameLocals1StackItemFrame(frameType, buildUtil);
        } else if (frameType <= 246) {
            throw new UnsupportedOperationException("unknown frame_type " + frameType);
        } else if (frameType == 247) {
            return new SameLocals1StackItemFramExtended(frameType, buildUtil);
        } else if (frameType <= 250) {
            return new ChopFrame(frameType, buildUtil);
        } else if (frameType == 251) {
            return new SameFramExtended(frameType, buildUtil);
        } else {
            return (frameType <= 254 ? new AppendFrame(frameType, buildUtil)
                    : new FullFrame(frameType, buildUtil));
        }
    }

    public StackMapFrame(int frameType) {
        this.frameType = frameType;
    }


    public int getOffsetDelta() {
        return frameType;
    }
}
