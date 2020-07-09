package com.njuse.jvmfinal.instructions.math.DIV;

import com.njuse.jvmfinal.instructions.base.NoOperandsInstruction;
import com.njuse.jvmfinal.runtime.MyFrame;
import com.njuse.jvmfinal.runtime.OperandStack;

public class IDIV extends NoOperandsInstruction {
    @Override
    public void execute(MyFrame frame) {
        OperandStack stack = frame.getOperandStack();
        int val2 = stack.popInt();
        int val1 = stack.popInt();
        if(val2 == 0){
            throw new ArithmeticException();
        } else {
            int res = val1 / val2;
            stack.pushInt(res);
        }
    }
}
