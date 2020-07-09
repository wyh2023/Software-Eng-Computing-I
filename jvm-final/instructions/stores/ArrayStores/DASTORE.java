package com.njuse.jvmfinal.instructions.stores.ArrayStores;

import com.njuse.jvmfinal.instructions.base.NoOperandsInstruction;
import com.njuse.jvmfinal.memory.heap.ArrayObject;
import com.njuse.jvmfinal.memory.heap.MyObject;
import com.njuse.jvmfinal.runtime.MyFrame;
import com.njuse.jvmfinal.runtime.OperandStack;

public class DASTORE extends NoOperandsInstruction {
    @Override
    public void execute(MyFrame frame) {
        OperandStack stack = frame.getOperandStack();
        double val = stack.popDouble();
        int index = stack.popInt();
        MyObject arrRef = stack.popRef();
        double[] doubles = ((ArrayObject) arrRef).getDoubles();
        doubles[index] = val;
    }
}
