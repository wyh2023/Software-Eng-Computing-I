package com.njuse.jvmfinal.instructions.stores;

import com.njuse.jvmfinal.runtime.MyFrame;

public class FSTORE_N extends STORE_N {
    public FSTORE_N(int index){
        checkIndex(index);
        this.index = index;
    }

    @Override
    public void execute(MyFrame frame) {
        float val = frame.getOperandStack().popFloat();
        frame.getLocalVars().setFloat(this.index, val);
    }
}
