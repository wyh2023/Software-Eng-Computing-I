package com.njuse.jvmfinal.instructions.constants;

import com.njuse.jvmfinal.instructions.base.ByteReader;
import com.njuse.jvmfinal.instructions.base.Instruction;
import com.njuse.jvmfinal.runtime.MyFrame;

import java.nio.ByteBuffer;

public class SIPUSH extends Instruction {
    private int val;

    public SIPUSH() {}

    @Override
    public void fetchOperands(ByteReader reader) {
        this.val = reader.read16();
    }

    @Override
    public void execute(MyFrame frame) {
        frame.getOperandStack().pushInt(val);
    }
}
