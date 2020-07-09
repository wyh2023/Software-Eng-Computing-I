package com.njuse.jvmfinal.instructions.stack;

import com.njuse.jvmfinal.instructions.base.NoOperandsInstruction;
import com.njuse.jvmfinal.runtime.MyFrame;
import com.njuse.jvmfinal.runtime.OperandStack;
import com.njuse.jvmfinal.runtime.Slot;

public class DUP extends NoOperandsInstruction {
    @Override
    public void execute(MyFrame frame) {
        OperandStack stack = frame.getOperandStack();
        Slot slot = stack.popSlot();
        stack.pushSlot(slot.clone());
        stack.pushSlot(slot.clone());
    }
}
