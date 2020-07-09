package com.njuse.jvmfinal.instructions.constants;

import com.njuse.jvmfinal.instructions.base.NoOperandsInstruction;
import com.njuse.jvmfinal.memory.heap.NullObject;
import com.njuse.jvmfinal.runtime.MyFrame;

public class ACONST_NULL extends NoOperandsInstruction {
    @Override
    public void execute(MyFrame frame) {
        NullObject nullObject = new NullObject();
        frame.getOperandStack().pushRef(nullObject);
    }
}
