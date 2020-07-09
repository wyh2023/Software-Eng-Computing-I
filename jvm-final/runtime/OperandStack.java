package com.njuse.jvmfinal.runtime;

import com.njuse.jvmfinal.memory.heap.MyObject;

public class OperandStack {
    private int size = 0;
    private Slot[] slots = null;

    public OperandStack(int maxSize){
        if(maxSize > 0){
            Slot[] slots = new Slot[maxSize];
            for(int i=0; i<maxSize; i++){
                slots[i] = new Slot();
            }
            this.setSlots(slots);
        }
    }

    public void pushInt(int val){
        this.slots[this.size].setVal(val);
        this.size++;
    }

    public int popInt(){
        this.size--;
        return this.slots[this.size].getVal();
    }

    public void pushFloat(float val){
        pushInt(Float.floatToIntBits(val));
    }

    public float popFloat(){
        int floatVal = this.popInt();
        return Float.intBitsToFloat(floatVal);
    }

    public void pushLong(long val){
        int val_low = (int) val;
        int val_high = (int) (val >>> 32);
        this.slots[this.size].setVal(val_low);
        this.slots[this.size+1].setVal(val_high);
        this.size += 2;
    }

    public long popLong(){
        this.size -= 2;
        long val_low = this.slots[this.size].getVal() & 0xffffffffL;
        long val_high = this.slots[this.size+1].getVal() & 0xffffffffL;
        return (val_high << 32) | val_low;
    }

    public void pushDouble(double val){
        long doubleBits = Double.doubleToLongBits(val);
        pushLong(doubleBits);
    }

    public double popDouble(){
        return Double.longBitsToDouble(this.popLong());
    }

    public void pushRef(MyObject ref){
        this.slots[this.size].setRef(ref);
        this.size++;
    }

    public MyObject popRef(){
        this.size--;
        MyObject ret = this.slots[this.size].getRef();
        this.slots[this.size].setRef(null);
        return ret;
    }

    public void pushSlot(Slot slot){
        this.slots[this.size] = slot;
        this.size++;
    }

    public Slot popSlot(){
        this.size--;
        return this.slots[this.size];
    }

    public void setSlots(Slot[] slots) {
        this.slots = slots;
    }

    public Slot[] getSlots(){
        return this.slots;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public MyObject getRefFromTop(int n){
        return this.slots[this.size-1-n].getRef();
    }
}
