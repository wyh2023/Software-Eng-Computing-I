package com.njuse.jvmfinal.instructions.references;

import com.njuse.jvmfinal.instructions.base.Index16Instruction;
import com.njuse.jvmfinal.memory.heap.MyObject;
import com.njuse.jvmfinal.memory.jclass.JClass;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.RuntimeConstantPool;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.ref.ClassRef;
import com.njuse.jvmfinal.runtime.MyFrame;
import com.njuse.jvmfinal.runtime.OperandStack;

public class ANEWARRAY extends Index16Instruction {
    @Override
    public void execute(MyFrame frame) {
        RuntimeConstantPool rtcp = frame.getMethod().getClazz().getRuntimeConstantPool();
        ClassRef classRef = (ClassRef) rtcp.getConstant(this.getIndex());

        OperandStack stack = frame.getOperandStack();
        int len = stack.popInt();

        try {
            JClass jClass = classRef.resolveClass();
            JClass arrayClass = jClass.ArrayRefClass();
            MyObject arr = arrayClass.newArrayObject(len);
            stack.pushRef(arr);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
