package com.njuse.jvmfinal.runtime;

import com.njuse.jvmfinal.memory.heap.MyObject;

public class Slot {
    private int val;
    private MyObject ref;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public MyObject getRef(){
        return ref;
    }

    public void setRef(MyObject ref){
        this.ref = ref;
    }

    public Slot clone(){
        Slot newSlot = new Slot();
        newSlot.val = this.val;
        newSlot.ref = this.ref;
        return newSlot;
    }
}
