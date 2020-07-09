package com.njuse.jvmfinal.memory.heap;

import com.njuse.jvmfinal.memory.jclass.JClass;

public class NullObject extends MyObject {
    public NullObject(){
        this.isNull = true;
    }
}
