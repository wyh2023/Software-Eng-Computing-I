package com.njuse.jvmfinal.classloader.classfileparser.attribute;

import com.njuse.jvmfinal.classloader.classfileparser.BuildUtil;
import lombok.Getter;
import lombok.Setter;

import java.nio.ByteBuffer;

@Getter
@Setter
public class AttributeInfo {

    private int attributeNameAndIndex;
    private int attributeLength;
    private byte[] info;

    protected AttributeInfo(int attributeNameAndIndex, int attributeLength) {
        this.attributeNameAndIndex = attributeNameAndIndex;
        this.attributeLength = attributeLength;
    }

    public AttributeInfo(BuildUtil buildUtil, int index, int length) {
        ByteBuffer byteBuffer = buildUtil.getByteBuffer();
        this.attributeNameAndIndex = index;
        this.attributeLength = length;
        this.info = new byte[this.attributeLength];
        for (int i = 0; i < this.attributeLength; i++) {
            info[i] = byteBuffer.get();
        }
    }

}
