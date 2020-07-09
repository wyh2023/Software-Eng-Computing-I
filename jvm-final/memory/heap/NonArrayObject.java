package com.njuse.jvmfinal.memory.heap;

import com.njuse.jvmfinal.memory.jclass.JClass;

public class NonArrayObject extends MyObject {
    public NonArrayObject(JClass jClass){
        this.jClass = jClass;
        this.data = (new Vars(jClass.getInstanceSlotCount()));
        this.isNull = false;
    }
}
