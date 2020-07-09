package com.njuse.jvmfinal.instructions.math.AND;

import com.njuse.jvmfinal.instructions.base.NoOperandsInstruction;
import com.njuse.jvmfinal.runtime.MyFrame;
import com.njuse.jvmfinal.runtime.OperandStack;

public class LAND extends NoOperandsInstruction {
    @Override
    public void execute(MyFrame frame) {
        OperandStack stack = frame.getOperandStack();
        long val2 = stack.popLong();
        long val1 = stack.popLong();
        long res = val1 & val2;
        stack.pushLong(res);
    }
}
