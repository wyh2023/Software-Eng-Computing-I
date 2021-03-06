package com.njuse.jvmfinal.instructions.references;

import com.njuse.jvmfinal.instructions.base.NoOperandsInstruction;
import com.njuse.jvmfinal.memory.heap.ArrayObject;
import com.njuse.jvmfinal.memory.heap.MyObject;
import com.njuse.jvmfinal.runtime.MyFrame;
import com.njuse.jvmfinal.runtime.OperandStack;

public class ARRAY_LENGTH extends NoOperandsInstruction {
    @Override
    public void execute(MyFrame frame) {
        OperandStack stack = frame.getOperandStack();
        MyObject arrRef = stack.popRef();
        int len = ((ArrayObject) arrRef).length();
        stack.pushInt(len);
    }
}
