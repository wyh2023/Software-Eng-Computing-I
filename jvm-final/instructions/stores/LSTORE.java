package com.njuse.jvmfinal.instructions.stores;

import com.njuse.jvmfinal.instructions.base.Index8Instruction;
import com.njuse.jvmfinal.runtime.MyFrame;

public class LSTORE extends Index8Instruction {
    @Override
    public void execute(MyFrame frame) {
        long val = frame.getOperandStack().popLong();
        frame.getLocalVars().setLong(this.index, val);
    }
}
