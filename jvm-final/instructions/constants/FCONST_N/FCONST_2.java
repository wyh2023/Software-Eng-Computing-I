package com.njuse.jvmfinal.instructions.constants.FCONST_N;

import com.njuse.jvmfinal.instructions.base.NoOperandsInstruction;
import com.njuse.jvmfinal.runtime.MyFrame;

public class FCONST_2 extends NoOperandsInstruction {
    @Override
    public void execute(MyFrame frame) {
        frame.getOperandStack().pushFloat(2.0f);
    }
}
