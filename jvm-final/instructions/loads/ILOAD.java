package com.njuse.jvmfinal.instructions.loads;

import com.njuse.jvmfinal.instructions.base.Index8Instruction;
import com.njuse.jvmfinal.runtime.MyFrame;

public class ILOAD extends Index8Instruction {
    @Override
    public void execute(MyFrame frame) {
        int val = frame.getLocalVars().getInt(this.index);
        frame.getOperandStack().pushInt(val);
    }
}
