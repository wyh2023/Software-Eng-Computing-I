package com.njuse.jvmfinal.instructions.stores;

import com.njuse.jvmfinal.runtime.MyFrame;

public class DSTORE_N extends STORE_N {
    public DSTORE_N(int index){
        checkIndex(index);
        this.index = index;
    }

    @Override
    public void execute(MyFrame frame) {
        double val = frame.getOperandStack().popDouble();
        frame.getLocalVars().setDouble(this.index, val);
    }
}
