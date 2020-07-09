package com.njuse.jvmfinal.classloader.classfileparser.attribute.smta;

import com.njuse.jvmfinal.classloader.classfileparser.BuildUtil;

public class VerificationTypeInfo {
    public static final int ITEM_Top = 0;
    public static final int ITEM_Integer = 1;
    public static final int ITEM_Float = 2;
    public static final int ITEM_Long = 4;
    public static final int ITEM_Double = 3;
    public static final int ITEM_Null = 5;
    public static final int ITEM_UninitializedThis = 6;
    public static final int ITEM_Object = 7;
    public static final int ITEM_Uninitialized = 8;

    private final int tag;

    public VerificationTypeInfo(int tag) {
        this.tag = tag;
    }

    static VerificationTypeInfo read(BuildUtil buildUtil) {
        byte tag = (byte) buildUtil.getU1();
        switch (tag) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new VerificationTypeInfo(tag);
            case 7:
                return new ObjectVariableInfo(buildUtil);
            case 8:
                return new UninitializedVariableInfo(buildUtil);
            default:
                throw new UnsupportedOperationException("unrecognized verification_type_info tag " + tag);
        }
    }
}
