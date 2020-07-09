package com.njuse.jvmfinal.instructions.stores;

import com.njuse.jvmfinal.runtime.MyFrame;

public class LSTORE_N extends STORE_N {
    public LSTORE_N(int index){
        checkIndex(index);
        this.index = index;
    }

    @Override
    public void execute(MyFrame frame) {
        long val = frame.getOperandStack().popLong();
        frame.getLocalVars().setLong(this.index, val);
    }
}
