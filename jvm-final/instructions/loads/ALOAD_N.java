package com.njuse.jvmfinal.instructions.loads;

import com.njuse.jvmfinal.runtime.MyFrame;
import com.njuse.jvmfinal.memory.heap.MyObject;

public class ALOAD_N extends LOAD_N {
    public ALOAD_N(int index){
        checkIndex(index);
        this.index = index;
    }

    @Override
    public void execute(MyFrame frame) {
        MyObject ref = frame.getLocalVars().getRef(this.index);
        frame.getOperandStack().pushRef(ref);
    }
}
