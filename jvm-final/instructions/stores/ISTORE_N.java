package com.njuse.jvmfinal.instructions.stores;

import com.njuse.jvmfinal.runtime.MyFrame;

public class ISTORE_N extends STORE_N{
    public ISTORE_N(int index){
        checkIndex(index);
        this.index = index;
    }

    @Override
    public void execute(MyFrame frame) {
        int val = frame.getOperandStack().popInt();
        frame.getLocalVars().setInt(this.index, val);
    }
}
