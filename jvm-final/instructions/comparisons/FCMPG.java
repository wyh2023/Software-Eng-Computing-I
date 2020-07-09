package com.njuse.jvmfinal.instructions.comparisons;

import com.njuse.jvmfinal.instructions.base.NoOperandsInstruction;
import com.njuse.jvmfinal.runtime.MyFrame;
import com.njuse.jvmfinal.runtime.OperandStack;

public class FCMPG extends NoOperandsInstruction {
    @Override
    public void execute(MyFrame frame) {
        OperandStack stack = frame.getOperandStack();
        float val2 = stack.popFloat();
        float val1 = stack.popFloat();
        if(val1 > val2){
            stack.pushInt(1);
        } else if(val1 == val2){
            stack.pushInt(0);
        } else if(val1 < val2){
            stack.pushInt(-1);
        } else {
            stack.pushInt(1);
        }
    }
}
