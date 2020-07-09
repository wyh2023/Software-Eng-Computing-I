package com.njuse.jvmfinal.classloader.classfileparser.constantpool.info;

import com.njuse.jvmfinal.classloader.classfileparser.constantpool.ConstantPool;

import java.nio.ByteBuffer;

public class IntegerInfo extends ConstantPoolInfo {
    private byte[] bytes;
    private int value;

    public IntegerInfo(ConstantPool constantPool, byte[] bytes) {
        super(constantPool);
        this.bytes = bytes;
        if (bytes.length != 4) {
            throw new UnsupportedOperationException(
                    "Integer constantpool info expects 4 bytes, actual is " + bytes.length);
        }
        this.value = ByteBuffer.wrap(bytes).getInt();
        super.tag = ConstantPoolInfo.INTEGER;
    }


    public Integer getValue() {
        return value;
    }
}
