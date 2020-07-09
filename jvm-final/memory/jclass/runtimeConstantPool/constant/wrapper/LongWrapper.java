package com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.wrapper;

import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.Constant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LongWrapper implements Constant {
    private long value;

    public LongWrapper(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "long " + value;
    }
}
