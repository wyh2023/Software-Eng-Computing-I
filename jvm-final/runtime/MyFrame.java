package com.njuse.jvmfinal.runtime;

import com.njuse.jvmfinal.memory.jclass.Method;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MyFrame {
    private MyFrame lower;
    private LocalVars localVars;
    private OperandStack operandStack;
    private MyThread thread;
    private Method method;
    private int nextPC;

    public MyFrame(MyThread thread, Method method){
        this.thread = thread;
        this.method = method;
        this.localVars = new LocalVars(method.getMaxLocal());
        this.operandStack = new OperandStack(method.getMaxStack());
    }

    public MyFrame(MyThread thread, Method method, int maxStack, int maxLocal){
        this.thread = thread;
        this.method = method;
        this.localVars = new LocalVars(maxLocal);
        this.operandStack = new OperandStack(maxStack);
    }

    public void revertPC(){
        this.nextPC = this.thread.getPC();
    }
}
