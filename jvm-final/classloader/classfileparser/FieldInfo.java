package com.njuse.jvmfinal.classloader.classfileparser;

import com.njuse.jvmfinal.classloader.classfileparser.attribute.AttributeInfo;
import com.njuse.jvmfinal.classloader.classfileparser.attribute.ConstantValueAttr;
import com.njuse.jvmfinal.classloader.classfileparser.constantpool.ConstantPool;
import com.njuse.jvmfinal.classloader.classfileparser.constantpool.info.UTF8Info;

import java.nio.ByteBuffer;
import java.util.function.Supplier;

public class FieldInfo {
    private short accessFlags;
    private short nameIndex;
    private String name;
    private short descriptorIndex;
    private String descriptor;
    private short attributesCount;
    private AttributeInfo[] attributes;

    public FieldInfo(ConstantPool constantPool, Supplier<AttributeInfo> attributeBuilder, ByteBuffer in) {
        this.accessFlags = in.getShort();
        this.nameIndex = in.getShort();
        this.descriptorIndex = in.getShort();
        this.attributesCount = in.getShort();
        this.attributes = new AttributeInfo[this.attributesCount];
        for (int i = 0; i < attributesCount; i++) {
            this.attributes[i] = attributeBuilder.get();
        }
        this.name = ((UTF8Info) constantPool.get(this.nameIndex)).getString();
        this.descriptor = ((UTF8Info) constantPool.get(this.descriptorIndex)).getString();

    }


    public short getAccessFlags() {
        return accessFlags;
    }


    public String getName() {
        return name;
    }


    public String getDescriptor() {
        return descriptor;
    }


    public ConstantValueAttr getConstantValueAttr() {
        for (AttributeInfo attribute : attributes) {
            if (attribute instanceof ConstantValueAttr) {
                return (ConstantValueAttr) attribute;
            }
        }
        return null;
    }
}
