package com.njuse.jvmfinal.instructions.extended;

import com.njuse.jvmfinal.instructions.base.ByteReader;
import com.njuse.jvmfinal.instructions.base.Instruction;
import com.njuse.jvmfinal.instructions.loads.*;
import com.njuse.jvmfinal.instructions.math.IINC;
import com.njuse.jvmfinal.instructions.stores.*;
import com.njuse.jvmfinal.runtime.MyFrame;

public class WIDE extends Instruction {
    public Instruction modifiedInstruction;

    @Override
    public void fetchOperands(ByteReader reader) {
        int opcode = reader.readU8();
        Instruction instr;
        switch (opcode){
            case 0x15:
                ILOAD iload = new ILOAD();
                iload.index = reader.readU16();
                this.modifiedInstruction = iload;
                break;
            case 0x16:
                LLOAD lload = new LLOAD();
                lload.index = reader.readU16();
                this.modifiedInstruction = lload;
                break;
            case 0x17:
                FLOAD fload = new FLOAD();
                fload.index = reader.readU16();
                this.modifiedInstruction = fload;
                break;
            case 0x18:
                DLOAD dload = new DLOAD();
                dload.index = reader.readU16();
                this.modifiedInstruction = dload;
                break;
            case 0x19:
                ALOAD aload = new ALOAD();
                aload.index = reader.readU16();
                this.modifiedInstruction = aload;
                break;
            case 0x36:
                ISTORE istore = new ISTORE();
                istore.index = reader.readU16();
                this.modifiedInstruction = istore;
                break;
            case 0x37:
                LSTORE lstore = new LSTORE();
                lstore.index = reader.readU16();
                this.modifiedInstruction = lstore;
                break;
            case 0x38:
                FSTORE fstore = new FSTORE();
                fstore.index = reader.readU16();
                this.modifiedInstruction = fstore;
                break;
            case 0x39:
                DSTORE dstore = new DSTORE();
                dstore.index = reader.readU16();
                this.modifiedInstruction = dstore;
                break;
            case 0x3a:
                ASTORE astore = new ASTORE();
                astore.index = reader.readU16();
                this.modifiedInstruction = astore;
                break;
            case 0x84:
                IINC iinc = new IINC();
                iinc.index = reader.readU16();
                iinc.CONST = reader.readU16();
                this.modifiedInstruction = iinc;
                break;
        }
    }

    @Override
    public void execute(MyFrame frame) {
        this.modifiedInstruction.execute(frame);
    }
}
