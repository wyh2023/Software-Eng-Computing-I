package com.njuse.jvmfinal.instructions.constants;

import com.njuse.jvmfinal.instructions.base.Index16Instruction;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.Constant;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.wrapper.DoubleWrapper;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.wrapper.FloatWrapper;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.wrapper.IntWrapper;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.wrapper.LongWrapper;
import com.njuse.jvmfinal.runtime.MyFrame;
import com.njuse.jvmfinal.runtime.OperandStack;

public class LDC2_W extends Index16Instruction {
    @Override
    public void execute(MyFrame frame) {
        OperandStack stack = frame.getOperandStack();
        Constant constant = frame.getMethod().getClazz().getRuntimeConstantPool().getConstant(this.getIndex());
        if (constant instanceof LongWrapper) {
            stack.pushLong(((LongWrapper) constant).getValue());
        }
        else if (constant instanceof DoubleWrapper) {
            stack.pushDouble(((DoubleWrapper) constant).getValue());
        }
    }
}
