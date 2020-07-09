package com.njuse.jvmfinal.instructions.base;

public class ByteReader {
    public byte[] code;
    public int PC;

    public ByteReader(){
    }

    public void reset(byte[] code, int PC){
        this.code = code;
        this.PC = PC;
    }

    public int readU8(){
        byte byteCode = this.code[this.PC];
        this.PC++;
        return byteCode & 0xff;
    }

    public int read8(){
        byte byteCode = this.code[this.PC];
        this.PC++;
        return byteCode;
    }

    public int readU16(){
        int byteCode1 = readU8();
        int byteCode2 = readU8();
        return (byteCode1 << 8) | byteCode2;
    }

    public int read16(){
        int ret = readU16();
        return (ret << 16) >> 16;
    }

    public int read32(){
        int byteCode1 = readU8();
        int byteCode2 = readU8();
        int byteCode3 = readU8();
        int byteCode4 = readU8();
        return (byteCode1 << 24) | (byteCode2 << 16) | (byteCode3 << 8) | byteCode4;
    }

    public void skipPadding(){
        while (this.PC % 4 != 0){
            this.readU8();
        }
    }

    public int[] readIntArray(int n){
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = this.read32();
        }
        return nums;
    }
}
