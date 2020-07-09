package com.njuse.jvmfinal.instructions.loads;

import com.njuse.jvmfinal.runtime.MyFrame;

public class FLOAD_N extends LOAD_N {
    public FLOAD_N(int index){
        checkIndex(index);
        this.index = index;
    }

    @Override
    public void execute(MyFrame frame) {
        float val = frame.getLocalVars().getFloat(this.index);
        frame.getOperandStack().pushFloat(val);
    }
}
