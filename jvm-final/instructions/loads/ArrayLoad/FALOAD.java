package com.njuse.jvmfinal.instructions.loads.ArrayLoad;

import com.njuse.jvmfinal.instructions.base.Index16Instruction;
import com.njuse.jvmfinal.memory.heap.ArrayObject;
import com.njuse.jvmfinal.memory.heap.MyObject;
import com.njuse.jvmfinal.runtime.MyFrame;
import com.njuse.jvmfinal.runtime.OperandStack;

public class FALOAD extends Index16Instruction {
    @Override
    public void execute(MyFrame frame) {
        OperandStack stack = frame.getOperandStack();
        int index = stack.popInt();
        MyObject arrRef = stack.popRef();
        float[] arrs = ((ArrayObject) arrRef).getFloats();
        stack.pushFloat(arrs[index]);
    }
}
