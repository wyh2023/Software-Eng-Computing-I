package com.njuse.jvmfinal.instructions.comparisons.IFACMP;

import com.njuse.jvmfinal.instructions.base.BranchInstruction;
import com.njuse.jvmfinal.runtime.MyFrame;
import com.njuse.jvmfinal.runtime.OperandStack;
import com.njuse.jvmfinal.memory.heap.MyObject;

public class IF_ACMPEQ extends BranchInstruction {
    @Override
    public void execute(MyFrame frame) {
        OperandStack stack = frame.getOperandStack();
        MyObject ref2 = stack.popRef();
        MyObject ref1 = stack.popRef();
        if( ref1 == ref2 ){
            jump(frame, this.offset);
        }
    }
}
