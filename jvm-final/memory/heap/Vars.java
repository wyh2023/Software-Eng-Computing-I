package com.njuse.jvmfinal.memory.heap;

import com.njuse.jvmfinal.runtime.Slot;

public class Vars {
    private Slot[] vars;

    public Vars(int slotCount){
        Slot[] slots = new Slot[slotCount];
        for(int i=0; i<slotCount; i++){
            slots[i] = new Slot();
        }
        this.setVars(slots);
    }

    public void setInt(int index, int val){
        this.vars[index].setVal(val);
    }

    public int getInt(int index){
        return this.vars[index].getVal();
    }

    public void setFloat(int index, float val){
        this.vars[index].setVal(Float.floatToIntBits(val));
    }

    public float getFloat(int index){
        int val = this.vars[index].getVal();
        return Float.intBitsToFloat(val);
    }

    public void setLong(int index, long val){
        int val_low = (int) val;
        int val_high = (int) (val >>> 32);
        this.vars[index].setVal(val_low);
        this.vars[index+1].setVal(val_high);
    }

    public long getLong(int index){
        long val_low = this.vars[index].getVal() & 0xFFFFFFFFL;
        long val_high = this.vars[index+1].getVal() & 0xFFFFFFFFL;
        return (val_high << 32) | val_low;
    }

    public void setDouble(int index, double val){
        long doubleBits = Double.doubleToLongBits(val);
        this.setLong(index, doubleBits);
    }

    public double getDouble(int index){
        long doubleBits = this.getLong(index);
        return Double.longBitsToDouble(doubleBits);
    }

    public void setRef(int index, MyObject ref){
        this.vars[index].setRef(ref);
    }

    public MyObject getRef(int index){
        return this.vars[index].getRef();
    }

    public Slot[] getVars() {
        return vars;
    }

    public void setVars(Slot[] vars) {
        this.vars = vars;
    }
}
