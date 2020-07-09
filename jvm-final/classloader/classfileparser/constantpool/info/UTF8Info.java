package com.njuse.jvmfinal.classloader.classfileparser.constantpool.info;

import com.njuse.jvmfinal.classloader.classfileparser.constantpool.ConstantPool;
import lombok.Getter;
import org.apache.commons.lang3.tuple.Pair;

import java.nio.ByteBuffer;


/**
 * todo
 */
@Getter
public class UTF8Info extends ConstantPoolInfo {
    private int length;
    private byte[] bytes;
    private String myString;

    public UTF8Info(ConstantPool constantPool, int length, byte[] bytes) {
        super(constantPool);
        this.length = length;
        this.bytes = bytes;
        if (bytes.length != length) {
            throw new UnsupportedOperationException(
                    "UTF8 constantpool info expects " + length + " but actual is " + bytes.length);
        }
        myString = new String(bytes);
        super.tag = ConstantPoolInfo.UTF8;
    }

    static Pair<UTF8Info, Integer> getInstance(ConstantPool constantPool, byte[] in, int offset) {
        ByteBuffer buffer = ByteBuffer.wrap(in, offset, in.length - offset);
        int length = 0xFFFF & (int) buffer.getShort();
        byte[] bytes = new byte[length];
        for (int i = 0; i < length; i++) {
            bytes[i] = buffer.get();
        }
        return Pair.of(new UTF8Info(constantPool, length, bytes), 2 + length);
    }

    public String getString() {
        return myString;
    }
}
