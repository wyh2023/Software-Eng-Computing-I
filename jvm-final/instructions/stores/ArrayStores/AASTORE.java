package com.njuse.jvmfinal.instructions.stores.ArrayStores;

import com.njuse.jvmfinal.instructions.base.NoOperandsInstruction;
import com.njuse.jvmfinal.memory.heap.ArrayObject;
import com.njuse.jvmfinal.memory.heap.MyObject;
import com.njuse.jvmfinal.runtime.MyFrame;
import com.njuse.jvmfinal.runtime.OperandStack;

public class AASTORE extends NoOperandsInstruction {
    @Override
    public void execute(MyFrame frame) {
        OperandStack stack = frame.getOperandStack();
        MyObject val = stack.popRef();
        int index = stack.popInt();
        MyObject arrRef = stack.popRef();
        MyObject[] arrs = ((ArrayObject) arrRef).getRefs();
        arrs[index] = val;
    }
}
