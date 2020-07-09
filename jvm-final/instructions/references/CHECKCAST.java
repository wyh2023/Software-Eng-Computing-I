package com.njuse.jvmfinal.instructions.references;

import com.njuse.jvmfinal.instructions.base.Index16Instruction;
import com.njuse.jvmfinal.memory.heap.MyObject;
import com.njuse.jvmfinal.memory.jclass.JClass;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.RuntimeConstantPool;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.ref.ClassRef;
import com.njuse.jvmfinal.runtime.MyFrame;
import com.njuse.jvmfinal.runtime.OperandStack;

public class CHECKCAST extends Index16Instruction {
    @Override
    public void execute(MyFrame frame) {
        OperandStack stack = frame.getOperandStack();
        MyObject ref = stack.popRef();
        stack.pushRef(ref);
        if(!ref.isNull()){
            RuntimeConstantPool rtcp = frame.getMethod().getClazz().getRuntimeConstantPool();
            ClassRef classRef = (ClassRef) rtcp.getConstant(this.getIndex());
            try {
                JClass target = classRef.resolveClass();
                if(!ref.isInstanceOf(target)) throw new ClassCastException();
            } catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }
    }
}
