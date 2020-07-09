package com.njuse.jvmfinal.instructions.loads.ArrayLoad;

import com.njuse.jvmfinal.instructions.base.NoOperandsInstruction;
import com.njuse.jvmfinal.memory.heap.ArrayObject;
import com.njuse.jvmfinal.memory.heap.MyObject;
import com.njuse.jvmfinal.runtime.MyFrame;
import com.njuse.jvmfinal.runtime.OperandStack;

public class DALOAD extends NoOperandsInstruction {
    @Override
    public void execute(MyFrame frame) {
        OperandStack stack = frame.getOperandStack();
        int index = stack.popInt();
        MyObject arrRef = stack.popRef();
        double[] arrs = ((ArrayObject) arrRef).getDoubles();
        stack.pushDouble(arrs[index]);
    }
}
