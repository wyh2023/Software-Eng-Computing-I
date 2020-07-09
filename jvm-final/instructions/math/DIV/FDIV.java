package com.njuse.jvmfinal.instructions.math.DIV;

import com.njuse.jvmfinal.instructions.base.NoOperandsInstruction;
import com.njuse.jvmfinal.runtime.MyFrame;
import com.njuse.jvmfinal.runtime.OperandStack;

public class FDIV extends NoOperandsInstruction {
    @Override
    public void execute(MyFrame frame) {
        OperandStack stack = frame.getOperandStack();
        float val2 = stack.popFloat();
        float val1 = stack.popFloat();
        if(val2 == 0){
            throw new ArithmeticException();
        } else {
            float res = val1 / val2;
            stack.pushFloat(res);
        }
    }
}
