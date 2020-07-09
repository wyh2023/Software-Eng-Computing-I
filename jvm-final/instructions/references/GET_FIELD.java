package com.njuse.jvmfinal.instructions.references;

import com.njuse.jvmfinal.instructions.base.Index16Instruction;
import com.njuse.jvmfinal.memory.heap.MyObject;
import com.njuse.jvmfinal.memory.heap.Vars;
import com.njuse.jvmfinal.memory.jclass.Field;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.RuntimeConstantPool;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.ref.FieldRef;
import com.njuse.jvmfinal.runtime.MyFrame;
import com.njuse.jvmfinal.runtime.OperandStack;

public class GET_FIELD extends Index16Instruction {
    @Override
    public void execute(MyFrame frame) {
        RuntimeConstantPool rtcp = frame.getMethod().getClazz().getRuntimeConstantPool();
        FieldRef fieldRef = (FieldRef) rtcp.getConstant(this.getIndex());
        try {
            Field field = fieldRef.resolveField();
            if(field.isSTATIC()){
                throw new IncompatibleClassChangeError();
            }

            OperandStack stack = frame.getOperandStack();
            MyObject ref = stack.popRef();
            if(ref.isNull()) throw new NullPointerException();

            String descriptor = field.getDescriptor();
            int slotID = field.getSlotID();
            Vars vars = ref.getFields();

            switch (descriptor.charAt(0)){
                case 'Z':
                case 'B':
                case 'C':
                case 'I':
                case 'S':
                    stack.pushInt(vars.getInt(slotID));
                    break;
                case 'F':
                    stack.pushFloat(vars.getFloat(slotID));
                    break;
                case 'J':
                    stack.pushLong(vars.getLong(slotID));
                    break;
                case 'D':
                    stack.pushDouble(vars.getDouble(slotID));
                    break;
                case 'L':
                case '[':
                    stack.pushRef(vars.getRef(slotID));
                default:
                    break;
            }

        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
