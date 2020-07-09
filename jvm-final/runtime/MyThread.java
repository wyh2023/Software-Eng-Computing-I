package com.njuse.jvmfinal.runtime;

import com.njuse.jvmfinal.memory.jclass.Method;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MyThread {
    private int PC;
    private ThreadStack threadStack;

    public MyThread(){
        this.threadStack = new ThreadStack();
    }

    public int getPC(){
        return this.PC;
    }

    public void setPC(int pc){
        this.PC = pc;
    }

    public void pushFrame(MyFrame frame){
        this.threadStack.push(frame);
    }

    public MyFrame popFrame(){
        return this.threadStack.pop();
    }

    public MyFrame getTopFrame(){
        return this.threadStack.getTop();
    }

    public MyFrame getCurrentFrame() {
        return this.threadStack.getTop();
    }

    public MyFrame newFrame(Method method){
        return new MyFrame(this, method);
    }

    public boolean isStackEmpty(){
        return this.threadStack.isEmpty();
    }

}
