package com.njuse.jvmfinal.instructions.base;

import com.njuse.jvmfinal.runtime.MyFrame;

import java.nio.ByteBuffer;

public abstract class Instruction {
    public Instruction(){}

    public abstract void fetchOperands(ByteReader reader);

    public abstract void execute(MyFrame frame);

    public void jump(MyFrame frame, int offset){
        int PC = frame.getThread().getPC();
        int nextPC = PC + offset;
        frame.setNextPC(nextPC);
    }
}
