package com.njuse.jvmfinal.instructions.constants.LCONST_N;

import com.njuse.jvmfinal.instructions.base.NoOperandsInstruction;
import com.njuse.jvmfinal.runtime.MyFrame;

public class LCONST_1 extends NoOperandsInstruction {
    @Override
    public void execute(MyFrame frame) {
        frame.getOperandStack().pushLong(1L);
    }
}
