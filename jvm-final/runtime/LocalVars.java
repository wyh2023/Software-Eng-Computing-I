package com.njuse.jvmfinal.runtime;

import com.njuse.jvmfinal.memory.heap.MyObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalVars {
    private Slot[] localVars;

    public LocalVars(int maxLocals){
        setLocalVars(maxLocals);
    }

    public void setLocalVars(int maxLocals){
        if(maxLocals > 0){
            Slot[] local = new Slot[maxLocals];
            for(int i=0; i<maxLocals; i++){
                local[i] = new Slot();
            }
            this.setLocalVars(local);
        }
    }

    public void setInt(int index, int val){
        this.localVars[index].setVal(val);
    }

    public int getInt(int index){
        return this.localVars[index].getVal();
    }

    public void setFloat(int index, float val){
        this.localVars[index].setVal(Float.floatToIntBits(val));
    }

    public float getFloat(int index){
        int val = this.localVars[index].getVal();
        return Float.intBitsToFloat(val);
    }

    public void setLong(int index, long val){
        int val_low = (int) val;
        int val_high = (int) (val >>> 32);
        this.localVars[index].setVal(val_low);
        this.localVars[index+1].setVal(val_high);
    }

    public long getLong(int index){
        long val_low = this.localVars[index].getVal() & 0xFFFFFFFFL;
        long val_high = this.localVars[index+1].getVal() & 0xFFFFFFFFL;
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
        this.localVars[index].setRef(ref);
    }

    public MyObject getRef(int index){
        return this.localVars[index].getRef();
    }

    public void setLocalVars(Slot[] localVars) {
        this.localVars = localVars;
    }

    public void setSlot(int index, Slot slot){
        this.localVars[index] = slot;
    }
}
