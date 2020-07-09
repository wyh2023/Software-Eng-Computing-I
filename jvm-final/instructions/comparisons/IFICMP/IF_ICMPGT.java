package com.njuse.jvmfinal.instructions.comparisons.IFICMP;

import com.njuse.jvmfinal.instructions.base.BranchInstruction;
import com.njuse.jvmfinal.runtime.MyFrame;
import com.njuse.jvmfinal.runtime.OperandStack;

public class IF_ICMPGT extends BranchInstruction {
    @Override
    public void execute(MyFrame frame) {
        OperandStack stack = frame.getOperandStack();
        int val2 = stack.popInt();
        int val1 = stack.popInt();
        if( val1 > val2 ){
            jump(frame, this.offset);
        }
    }
}
