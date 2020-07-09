package com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.wrapper;

import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.Constant;
import lombok.Getter;
import lombok.Setter;

//not support String class in current version
@Getter
@Setter
public class StringWrapper implements Constant {
    private String value;

    public StringWrapper(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "String " + value;
    }
}
