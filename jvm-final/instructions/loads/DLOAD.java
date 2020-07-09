package com.njuse.jvmfinal.instructions.loads;

import com.njuse.jvmfinal.instructions.base.Index8Instruction;
import com.njuse.jvmfinal.runtime.MyFrame;

public class DLOAD extends Index8Instruction {
    @Override
    public void execute(MyFrame frame) {
        double val = frame.getLocalVars().getDouble(this.index);
        frame.getOperandStack().pushDouble(val);
    }
}
