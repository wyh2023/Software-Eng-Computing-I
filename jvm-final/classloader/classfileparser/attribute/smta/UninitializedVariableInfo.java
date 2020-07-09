package com.njuse.jvmfinal.classloader.classfileparser.attribute.smta;

import com.njuse.jvmfinal.classloader.classfileparser.BuildUtil;

public class UninitializedVariableInfo extends VerificationTypeInfo {
    private int offset;

    public UninitializedVariableInfo(BuildUtil buildUtil) {
        super(VerificationTypeInfo.ITEM_Uninitialized);
        this.offset = buildUtil.getU2();
    }
}
