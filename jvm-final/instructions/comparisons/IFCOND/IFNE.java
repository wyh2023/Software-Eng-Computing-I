package com.njuse.jvmfinal.instructions.comparisons.IFCOND;

import com.njuse.jvmfinal.instructions.base.BranchInstruction;
import com.njuse.jvmfinal.runtime.MyFrame;

public class IFNE extends BranchInstruction {
    @Override
    public void execute(MyFrame frame) {
        int val = frame.getOperandStack().popInt();
        if( val != 0 ){
            jump(frame, this.offset);
        }
    }
}
