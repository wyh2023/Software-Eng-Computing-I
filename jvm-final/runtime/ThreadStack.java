package com.njuse.jvmfinal.runtime;

import lombok.Getter;
import lombok.Setter;

import java.util.EmptyStackException;

@Getter
@Setter
public class ThreadStack {
    private static int maxSize = 1024;
    private int size;
    private MyFrame top;

    public ThreadStack(){
    }

    public void push(MyFrame frame){
        if(this.size >= maxSize) throw new StackOverflowError();
        if( this.top != null ){
            frame.setLower(this.top);
        }
        this.top = frame;
        this.size++;
    }

    public MyFrame pop(){
        if( this.top == null ) throw new EmptyStackException();
        MyFrame top = this.top;
        this.top = top.getLower();
        top.setLower(null);
        this.size--;
        return top;
    }

    public MyFrame getTop(){
        if( this.top == null ) throw new EmptyStackException();
        return top;
    }

    public boolean isEmpty(){
        return this.top == null;
    }
}
