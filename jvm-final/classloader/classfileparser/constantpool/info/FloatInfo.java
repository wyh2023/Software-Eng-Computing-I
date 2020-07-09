package com.njuse.jvmfinal.classloader.classfileparser.constantpool.info;

import com.njuse.jvmfinal.classloader.classfileparser.constantpool.ConstantPool;

import java.nio.ByteBuffer;

public class FloatInfo extends ConstantPoolInfo {
    private byte[] bytes;
    private float value;

    public FloatInfo(ConstantPool constantPool, byte[] bytes) {
        super(constantPool);
        this.bytes = bytes;
        if (bytes.length != 4) {
            throw new UnsupportedOperationException(
                    "Float constantpool info expects 4 bytes, actual is " + bytes.length);
        }
        this.value = ByteBuffer.wrap(bytes).getFloat();
        super.tag = ConstantPoolInfo.FLOAT;

    }

    public Float getValue() {
        return value;
    }
}
