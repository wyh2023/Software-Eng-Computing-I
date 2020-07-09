package com.njuse.jvmfinal.instructions.stores;

import com.njuse.jvmfinal.instructions.base.Index8Instruction;
import com.njuse.jvmfinal.runtime.MyFrame;

public class ISTORE extends Index8Instruction {
    @Override
    public void execute(MyFrame frame) {
        int val = frame.getOperandStack().popInt();
        frame.getLocalVars().setInt(this.index, val);
    }
}
