package com.njuse.jvmfinal.classloader.classfileparser.attribute;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionTable {
    private int startPC;
    private int endPC;
    private int handlerPC;
    private int catchType;

    public ExceptionTable(int startPC, int endPC, int handlerPC, int catchType) {
        this.startPC = startPC;
        this.endPC = endPC;
        this.handlerPC = handlerPC;
        this.catchType = catchType;
    }
}
