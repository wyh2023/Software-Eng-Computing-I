package com.njuse.jvmfinal.instructions.control;

import com.njuse.jvmfinal.instructions.base.ByteReader;
import com.njuse.jvmfinal.instructions.base.Instruction;
import com.njuse.jvmfinal.runtime.MyFrame;

public class LOOKUP_SWITCH extends Instruction {
    public int defaultOffset;
    public int npairs;
    public int[] matchOffsets;

    @Override
    public void fetchOperands(ByteReader reader) {
        reader.skipPadding();
        this.defaultOffset = reader.read32();
        // Each of the npairs pairs consists of an int match and a signed 32-bit offset
        this.npairs = reader.read32();
        this.matchOffsets = reader.readIntArray(npairs * 2);
    }

    @Override
    public void execute(MyFrame frame) {
        int key = frame.getOperandStack().popInt();
        int offset;
        int flg = 0;
        for(int i=0; i<this.npairs*2; i+=2){
            if(this.matchOffsets[i] == key){
                flg = 1;
                jump(frame, this.matchOffsets[i+1]);
                break;
            }
        }
        if(flg == 0){
            jump(frame, this.defaultOffset);
        }
    }
}
