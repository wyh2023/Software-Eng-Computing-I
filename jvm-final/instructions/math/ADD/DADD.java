package com.njuse.jvmfinal.instructions.math.ADD;

import com.njuse.jvmfinal.instructions.base.NoOperandsInstruction;
import com.njuse.jvmfinal.runtime.MyFrame;
import com.njuse.jvmfinal.runtime.OperandStack;

public class DADD extends NoOperandsInstruction {
    @Override
    public void execute(MyFrame frame) {
        OperandStack stack = frame.getOperandStack();
        double val2 = stack.popDouble();
        double val1 = stack.popDouble();
        double res = val1 + val2;
        stack.pushDouble(res);
    }
}
