package com.njuse.jvmfinal.instructions.control;

import com.njuse.jvmfinal.instructions.base.NoOperandsInstruction;
import com.njuse.jvmfinal.runtime.MyFrame;
import com.njuse.jvmfinal.runtime.MyThread;

public class FRETURN extends NoOperandsInstruction {
    @Override
    public void execute(MyFrame frame) {
        MyThread thread = frame.getThread();
        MyFrame currFrame = thread.popFrame();
        MyFrame invoker = thread.getTopFrame();
        float retVal = currFrame.getOperandStack().popFloat();
        invoker.getOperandStack().pushFloat(retVal);
    }
}
