package com.njuse.jvmfinal.execution;

import com.njuse.jvmfinal.instructions.base.ByteReader;
import com.njuse.jvmfinal.instructions.base.Instruction;
import com.njuse.jvmfinal.memory.jclass.Method;
import com.njuse.jvmfinal.runtime.MyFrame;
import com.njuse.jvmfinal.runtime.MyThread;
import com.njuse.jvmfinal.runtime.Slot;

import java.util.Arrays;

public class Interpreter {
    public Interpreter(){}

    public void interpret(Method method){

        MyThread thread = new MyThread();
        MyFrame frame = thread.newFrame(method);
        thread.pushFrame(frame);

        loop(thread, method.getCode());
    }

    public void loop(MyThread thread, byte[] code){
        ByteReader reader = new ByteReader();
        Opcode opcodeLst = new Opcode();
        MyFrame frameLook = thread.getCurrentFrame();

        while (true) {
            MyFrame frame = thread.getCurrentFrame();
            int pc = frame.getNextPC();

            thread.setPC(pc);

            reader.reset(frame.getMethod().getCode(), pc);
            int opcode = reader.readU8();
            Instruction instr = opcodeLst.newInstruction(opcode);
            instr.fetchOperands(reader);
            //System.out.println(reader.PC);
            frame.setNextPC(reader.PC);

            //beforeLog(pc, instr, frame);
            instr.execute(frame);
            //afterLog(pc, instr, frame);
            //System.out.println(frameLook.getOperandStack().getSize());

            if(thread.isStackEmpty()){
                break;
            }

        }
    }

    public void beforeLog(int pc, Instruction instr, MyFrame frame){
        System.out.printf("Before : PC = %-3d, Instr = %-15s frame = %s, opSize = %d\n", pc, instr.getClass().getSimpleName(),
                frame.toString().substring(frame.toString().length()-3), frame.getOperandStack().getSize());
    }

    public void afterLog(int pc, Instruction instr, MyFrame frame){
        System.out.printf("After  : PC = %-3d, Instr = %-15s frame = %s, opSize = %d\n", pc, instr.getClass().getSimpleName(),
                frame.toString().substring(frame.toString().length()-3), frame.getOperandStack().getSize());
    }
}
