package com.njuse.jvmfinal.instructions.base;

import lombok.Getter;
import lombok.Setter;

import java.nio.ByteBuffer;

@Setter
@Getter
public abstract class Index16Instruction extends Instruction{
    private int index;

    @Override
    public void fetchOperands(ByteReader reader) {
        this.index = reader.readU16();
    }

    public String toString(){
        return this.getClass().getSimpleName() + "index: " + this.index;
    }
}
