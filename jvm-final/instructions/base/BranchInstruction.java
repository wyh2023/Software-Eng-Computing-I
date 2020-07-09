package com.njuse.jvmfinal.instructions.base;

import com.njuse.jvmfinal.runtime.MyFrame;
import lombok.Getter;
import lombok.Setter;

import java.nio.ByteBuffer;

@Setter
@Getter
public abstract class BranchInstruction extends Instruction{
    public int offset;

    public BranchInstruction() {}

    @Override
    public void fetchOperands(ByteReader reader) {
        this.offset = reader.read16();
    }

    public String toString(){
        return this.getClass().getSimpleName() + "offset: " + this.offset;
    }

}
