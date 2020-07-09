package com.njuse.jvmfinal.instructions.loads;

import com.njuse.jvmfinal.runtime.MyFrame;

public class ILOAD_N extends LOAD_N{
    public ILOAD_N(int index){
        checkIndex(index);
        this.index = index;
    }

    @Override
    public void execute(MyFrame frame) {
        int val = frame.getLocalVars().getInt(this.index);
        frame.getOperandStack().pushInt(val);
    }
}
