package com.njuse.jvmfinal.instructions.stores;

import com.njuse.jvmfinal.runtime.MyFrame;
import com.njuse.jvmfinal.memory.heap.MyObject;

public class ASTORE_N extends STORE_N{
    public ASTORE_N(int index){
        checkIndex(index);
        this.index = index;
    }

    @Override
    public void execute(MyFrame frame) {
        MyObject ref = frame.getOperandStack().popRef();
        frame.getLocalVars().setRef(this.index, ref);
    }
}
