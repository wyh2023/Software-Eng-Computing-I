package com.njuse.jvmfinal.memory.heap;

import com.njuse.jvmfinal.memory.jclass.JClass;
import com.njuse.jvmfinal.runtime.Slot;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public abstract class MyObject {
    protected JClass jClass;
    protected Object data;
    protected boolean isNull;
    protected boolean isArray = false;

    public MyObject(){
    }

    public boolean isInstanceOf(JClass target) throws ClassNotFoundException {
        return target.isAssignableFrom(this.jClass);
    }

    public Vars getFields(){
        return (Vars) data;
    }

}
