package com.njuse.jvmfinal.instructions.constants;

import com.njuse.jvmfinal.instructions.base.Index8Instruction;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.Constant;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.wrapper.FloatWrapper;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.wrapper.IntWrapper;
import com.njuse.jvmfinal.runtime.MyFrame;
import com.njuse.jvmfinal.runtime.OperandStack;

public class LDC extends Index8Instruction {
    @Override
    public void execute(MyFrame frame) {
        OperandStack stack = frame.getOperandStack();
        Constant constant = frame.getMethod().getClazz().getRuntimeConstantPool().getConstant(this.index);
        if (constant instanceof IntWrapper) {
            stack.pushInt(((IntWrapper) constant).getValue());
        }
        else if (constant instanceof FloatWrapper) {
            stack.pushFloat(((FloatWrapper) constant).getValue());
        }
    }
}
