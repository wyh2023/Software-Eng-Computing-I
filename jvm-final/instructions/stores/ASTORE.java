package com.njuse.jvmfinal.instructions.stores;

import com.njuse.jvmfinal.instructions.base.Index8Instruction;
import com.njuse.jvmfinal.runtime.MyFrame;
import com.njuse.jvmfinal.memory.heap.MyObject;

public class ASTORE extends Index8Instruction {
    @Override
    public void execute(MyFrame frame) {
        MyObject ref = frame.getOperandStack().popRef();
        frame.getLocalVars().setRef(this.index, ref);
    }
}
