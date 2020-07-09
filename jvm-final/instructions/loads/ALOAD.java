package com.njuse.jvmfinal.instructions.loads;

import com.njuse.jvmfinal.instructions.base.Index8Instruction;
import com.njuse.jvmfinal.runtime.MyFrame;
import com.njuse.jvmfinal.memory.heap.MyObject;

public class ALOAD extends Index8Instruction {
    @Override
    public void execute(MyFrame frame) {
        MyObject ref = frame.getLocalVars().getRef(this.index);
        frame.getOperandStack().pushRef(ref);
    }
}
