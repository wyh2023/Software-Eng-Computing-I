package com.njuse.jvmfinal.instructions.constants;

import com.njuse.jvmfinal.instructions.base.ByteReader;
import com.njuse.jvmfinal.instructions.base.Instruction;
import com.njuse.jvmfinal.runtime.MyFrame;

import java.nio.ByteBuffer;

public class BIPUSH extends Instruction {
    private int val;

    public BIPUSH(){}

    @Override
    public void execute(MyFrame frame) {
        frame.getOperandStack().pushInt(this.val);
    }

    @Override
    public void fetchOperands(ByteReader reader) {
        this.val = reader.read8();
    }
}
