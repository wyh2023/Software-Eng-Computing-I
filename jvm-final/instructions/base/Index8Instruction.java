package com.njuse.jvmfinal.instructions.base;

import com.njuse.jvmfinal.runtime.MyFrame;
import lombok.Getter;
import lombok.Setter;

import java.nio.ByteBuffer;

public abstract class Index8Instruction extends Instruction{
    public int index;

    public Index8Instruction() {}

    @Override
    public void fetchOperands(ByteReader reader) {
        this.index = reader.readU8();
    }

    public String toString(){
        return this.getClass().getSimpleName() + "index: " + this.index;
    }

}
