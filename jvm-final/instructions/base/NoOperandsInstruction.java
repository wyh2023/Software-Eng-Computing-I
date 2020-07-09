package com.njuse.jvmfinal.instructions.base;

import java.nio.ByteBuffer;

public abstract class NoOperandsInstruction extends Instruction {
    public NoOperandsInstruction(){}

    @Override
    public void fetchOperands(ByteReader reader) { }

    public String toString(){
        return this.getClass().getSimpleName();
    }
}
