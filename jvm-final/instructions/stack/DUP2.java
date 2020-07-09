package com.njuse.jvmfinal.instructions.stack;

import com.njuse.jvmfinal.instructions.base.NoOperandsInstruction;
import com.njuse.jvmfinal.runtime.MyFrame;
import com.njuse.jvmfinal.runtime.OperandStack;
import com.njuse.jvmfinal.runtime.Slot;

public class DUP2 extends NoOperandsInstruction {
    @Override
    public void execute(MyFrame frame) {
        OperandStack stack = frame.getOperandStack();
        Slot slot1 = stack.popSlot();
        Slot slot2 = stack.popSlot();
        stack.pushSlot(slot2.clone());
        stack.pushSlot(slot1.clone());
        stack.pushSlot(slot2.clone());
        stack.pushSlot(slot1.clone());
    }
}
