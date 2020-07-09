package com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.wrapper;

import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.Constant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IntWrapper implements Constant {
    private int value;

    public IntWrapper(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "int " + value;
    }
}
