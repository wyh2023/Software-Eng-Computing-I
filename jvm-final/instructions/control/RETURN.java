package com.njuse.jvmfinal.instructions.control;

import com.njuse.jvmfinal.instructions.base.NoOperandsInstruction;
import com.njuse.jvmfinal.runtime.MyFrame;

public class RETURN extends NoOperandsInstruction {
    @Override
    public void execute(MyFrame frame) {
        frame.getThread().popFrame();
    }
}
