package com.njuse.jvmfinal.instructions.loads;

import com.njuse.jvmfinal.instructions.base.Index8Instruction;
import com.njuse.jvmfinal.runtime.MyFrame;

public class FLOAD extends Index8Instruction {
    @Override
    public void execute(MyFrame frame) {
        float val = frame.getLocalVars().getFloat(this.index);
        frame.getOperandStack().pushFloat(val);
    }
}
