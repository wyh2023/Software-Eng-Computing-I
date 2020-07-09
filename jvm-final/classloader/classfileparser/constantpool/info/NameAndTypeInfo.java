package com.njuse.jvmfinal.classloader.classfileparser.constantpool.info;

import com.njuse.jvmfinal.classloader.classfileparser.constantpool.ConstantPool;
import lombok.Getter;
import org.apache.commons.lang3.tuple.Pair;

@Getter
public class NameAndTypeInfo extends ConstantPoolInfo {
    private int nameIndex;
    private int descriptorIndex;

    public NameAndTypeInfo(ConstantPool constantPool, int nameIndex, int descriptorIndex) {
        super(constantPool);
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
        super.tag = ConstantPoolInfo.NAME_AND_TYPE;
    }

    public Pair<String, String> getNameAndDescriptor() {
        return Pair.of(
                ((UTF8Info) myCP.get(nameIndex)).getString(),
                ((UTF8Info) myCP.get(descriptorIndex)).getString());
    }
}
