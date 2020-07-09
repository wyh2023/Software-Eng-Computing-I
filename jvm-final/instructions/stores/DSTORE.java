package com.njuse.jvmfinal.instructions.stores;

import com.njuse.jvmfinal.instructions.base.Index8Instruction;
import com.njuse.jvmfinal.runtime.MyFrame;

public class DSTORE extends Index8Instruction {
    @Override
    public void execute(MyFrame frame) {
        double val = frame.getOperandStack().popDouble();
        frame.getLocalVars().setDouble(this.index, val);
    }
}
