package com.njuse.jvmfinal.classloader.classfileparser.attribute;

import com.njuse.jvmfinal.classloader.classfileparser.BuildUtil;
import lombok.Getter;
import lombok.Setter;

import java.nio.ByteBuffer;

/**
 * todo：bonus
 */
@Getter
@Setter
public class CodeAttribute extends AttributeInfo {
    private int maxStack;
    private int maxLocal;
    private int codeLength;
    private byte[] code;
    private int exceptionTableLength;
    private ExceptionTable[] exceptionTable;
    private int attributesCount;
    private AttributeInfo[] attributes;

    public CodeAttribute(BuildUtil buildUtil, int index, int length) {
        super(index, length);
        maxStack = buildUtil.getU2();
        maxLocal = buildUtil.getU2();
        codeLength = (int) buildUtil.getU4();
        code = new byte[codeLength];
        ByteBuffer buffer = buildUtil.getByteBuffer();
        for (int i = 0; i < codeLength; i++) {
            code[i] = buffer.get();
        }
        exceptionTableLength = buildUtil.getU2();
        exceptionTable = new ExceptionTable[exceptionTableLength];
        for (int i = 0; i < exceptionTableLength; i++) {
            exceptionTable[i] = new ExceptionTable(buildUtil.getU2(), buildUtil.getU2(),
                    buildUtil.getU2(), buildUtil.getU2());
        }
        attributesCount = buildUtil.getU2();
        attributes = new AttributeInfo[attributesCount];
        for (int i = 0; i < attributesCount; i++) {
            attributes[i] = AttributeBuilder.createAttribute(buildUtil);
        }
    }
}

