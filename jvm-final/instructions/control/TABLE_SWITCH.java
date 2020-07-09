package com.njuse.jvmfinal.instructions.control;

import com.njuse.jvmfinal.instructions.base.ByteReader;
import com.njuse.jvmfinal.instructions.base.Instruction;
import com.njuse.jvmfinal.runtime.MyFrame;

public class TABLE_SWITCH extends Instruction {
    public int defaultOffset;
    public int low;
    public int high;
    public int[] jmpOffsets;

    @Override
    public void fetchOperands(ByteReader reader) {
        reader.skipPadding();
        this.defaultOffset = reader.read32();
        this.low = reader.read32();
        this.high = reader.read32();
        int lengthOfJmpOffsets = this.high - this.low + 1;
        this.jmpOffsets = reader.readIntArray(lengthOfJmpOffsets);
    }

    @Override
    public void execute(MyFrame frame) {
        int index = frame.getOperandStack().popInt();
        int offset;
        if(index >= this.low && index <= this.high){
            offset = this.jmpOffsets[index];
        } else {
            offset = this.defaultOffset;
        }
        jump(frame, offset);
    }
}
