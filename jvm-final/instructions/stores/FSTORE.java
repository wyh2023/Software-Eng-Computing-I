package com.njuse.jvmfinal.instructions.stores;

import com.njuse.jvmfinal.instructions.base.Index8Instruction;
import com.njuse.jvmfinal.runtime.MyFrame;

public class FSTORE extends Index8Instruction {
    @Override
    public void execute(MyFrame frame) {
        float val = frame.getOperandStack().popFloat();
        frame.getLocalVars().setFloat(this.index, val);
    }
}
