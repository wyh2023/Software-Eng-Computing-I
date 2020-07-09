package com.njuse.jvmfinal.instructions.constants.DCONST_N;

import com.njuse.jvmfinal.instructions.base.NoOperandsInstruction;
import com.njuse.jvmfinal.runtime.MyFrame;

public class DCONST_0 extends NoOperandsInstruction {
    @Override
    public void execute(MyFrame frame) {
        frame.getOperandStack().pushDouble(0.0);
    }
}
