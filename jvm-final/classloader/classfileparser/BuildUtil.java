package com.njuse.jvmfinal.classloader.classfileparser;

import com.njuse.jvmfinal.classloader.classfileparser.constantpool.ConstantPool;
import lombok.Getter;
import lombok.Setter;

import java.nio.ByteBuffer;

@Getter
@Setter
public class BuildUtil {
    private ConstantPool constantPool;
    private ByteBuffer byteBuffer;

    public BuildUtil(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
    }

    public BuildUtil(ConstantPool constantPool, ByteBuffer byteBuffer) {
        this.constantPool = constantPool;
        this.byteBuffer = byteBuffer;
    }

    public int getU1() {
        int signed = byteBuffer.get();
        return signed & 0xFF;
    }

    public int getU2() {
        int signed = byteBuffer.getShort();
        return signed & 0xFFFF;
    }

    public long getU4() {
        long signed = byteBuffer.getInt();
        return signed & 0xFFFFFFFFL;
    }
}
