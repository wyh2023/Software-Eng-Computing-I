package com.njuse.jvmfinal.instructions.loads;

import com.njuse.jvmfinal.runtime.MyFrame;

public class DLOAD_N extends LOAD_N {
    public DLOAD_N(int index){
        checkIndex(index);
        this.index = index;
    }

    @Override
    public void execute(MyFrame frame) {
        double val = frame.getLocalVars().getDouble(this.index);
        frame.getOperandStack().pushDouble(val);
    }
}
