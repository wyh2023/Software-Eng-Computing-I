package com.njuse.jvmfinal.instructions.control;

import com.njuse.jvmfinal.instructions.base.BranchInstruction;
import com.njuse.jvmfinal.runtime.MyFrame;

public class GOTO extends BranchInstruction {
    @Override
    public void execute(MyFrame frame) {
        jump(frame, this.offset);
    }
}
