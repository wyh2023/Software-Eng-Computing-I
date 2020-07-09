package com.njuse.jvmfinal.instructions.conversions;

import com.njuse.jvmfinal.instructions.base.NoOperandsInstruction;
import com.njuse.jvmfinal.runtime.MyFrame;
import com.njuse.jvmfinal.runtime.OperandStack;

public class I2C extends NoOperandsInstruction {
    @Override
    public void execute(MyFrame frame) {
        OperandStack stack = frame.getOperandStack();
        int val = stack.popInt();
        stack.pushInt(val & 0xFFFF);
    }
}
