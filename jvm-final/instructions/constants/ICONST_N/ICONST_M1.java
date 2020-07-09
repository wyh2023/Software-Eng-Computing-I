package com.njuse.jvmfinal.instructions.constants.ICONST_N;

import com.njuse.jvmfinal.instructions.base.NoOperandsInstruction;
import com.njuse.jvmfinal.runtime.MyFrame;

public class ICONST_M1 extends NoOperandsInstruction {
    @Override
    public void execute(MyFrame frame) {
        frame.getOperandStack().pushInt(-1);
    }
}
