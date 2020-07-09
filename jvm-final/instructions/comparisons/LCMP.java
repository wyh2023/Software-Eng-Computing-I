package com.njuse.jvmfinal.instructions.comparisons;

import com.njuse.jvmfinal.instructions.base.NoOperandsInstruction;
import com.njuse.jvmfinal.runtime.MyFrame;
import com.njuse.jvmfinal.runtime.OperandStack;

public class LCMP extends NoOperandsInstruction {
    @Override
    public void execute(MyFrame frame) {
        OperandStack stack = frame.getOperandStack();
        long val2 = stack.popLong();
        long val1 = stack.popLong();
        if(val1 > val2){
            stack.pushInt(1);
        } else if (val1 == val2) {
            stack.pushInt(0);
        } else {
            stack.pushInt(-1);
        }
    }
}
