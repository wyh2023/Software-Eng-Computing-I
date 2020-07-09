package com.njuse.jvmfinal.instructions.extended;

import com.njuse.jvmfinal.instructions.base.BranchInstruction;
import com.njuse.jvmfinal.runtime.MyFrame;
import com.njuse.jvmfinal.memory.heap.MyObject;

public class IFNONNULL extends BranchInstruction {
    @Override
    public void execute(MyFrame frame) {
        MyObject ref = frame.getOperandStack().popRef();
        if ( !ref.isNull() ){
            jump(frame, this.offset);
        }
    }
}
