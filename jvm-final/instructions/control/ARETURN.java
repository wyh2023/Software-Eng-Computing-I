package com.njuse.jvmfinal.instructions.control;

import com.njuse.jvmfinal.instructions.base.NoOperandsInstruction;
import com.njuse.jvmfinal.memory.heap.MyObject;
import com.njuse.jvmfinal.runtime.MyFrame;
import com.njuse.jvmfinal.runtime.MyThread;

public class ARETURN extends NoOperandsInstruction {
    @Override
    public void execute(MyFrame frame) {
        MyThread thread = frame.getThread();
        MyFrame currFrame = thread.popFrame();
        MyFrame invoker = thread.getTopFrame();
        MyObject retRef = currFrame.getOperandStack().popRef();
        invoker.getOperandStack().pushRef(retRef);
    }
}
