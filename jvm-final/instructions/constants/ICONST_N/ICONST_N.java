package com.njuse.jvmfinal.instructions.constants.ICONST_N;

import com.njuse.jvmfinal.instructions.base.NoOperandsInstruction;
import com.njuse.jvmfinal.runtime.MyFrame;

public class ICONST_N extends NoOperandsInstruction {
    public int val;
    private static int[] valid = new int[]{0, 1, 2, 3, 4, 5};

    public static void checkIndex(int i){
        assert i >= valid[0] && i <= valid[valid.length - 1];
    }

    public ICONST_N(int val){
        checkIndex(val);
        this.val = val;
    }

    @Override
    public void execute(MyFrame frame) {
        frame.getOperandStack().pushInt(this.val);
    }
}
