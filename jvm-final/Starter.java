package com.njuse.jvmfinal;


import com.njuse.jvmfinal.classloader.Classpath;
import com.njuse.jvmfinal.execution.Interpreter;
import com.njuse.jvmfinal.memory.jclass.JClass;
import com.njuse.jvmfinal.runtime.LocalVars;
import com.njuse.jvmfinal.runtime.OperandStack;
import com.njuse.jvmfinal.classloader.ClassLoader;

import java.io.File;
import java.io.IOException;

public class Starter {
    private static final String BASE_PATH=String.join("\\","src","test","testfilepath");
    private static final String cp = String.join(File.separator, "src", "test", "java");

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int i = 68;
        System.out.println((char) i);
        /*
        String cp = String.join(File.separator, "src", "test", "testConversion");
        Classpath classpath = new Classpath(cp);
        ClassLoader classLoader = new ClassLoader(classpath);
        JClass test = classLoader.loadClass("ConversionTest");
        Interpreter interpreter = new Interpreter();
        interpreter.interpret(test.getMainMethod());
         */
    }

    /**
     * ⚠️警告：不要改动这个方法签名，这是和测试用例的唯一接口
     */
    public static void runTest(String mainClassName, String cp) {
        try {
            Classpath classpath = new Classpath(cp);
            ClassLoader classLoader = new ClassLoader(classpath);
            JClass test = classLoader.loadClass(mainClassName);
            Interpreter interpreter = new Interpreter();
            interpreter.interpret(test.getMainMethod());
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void printHex(byte[] data){
        System.out.print("[");
        for(byte x : data){
            int a = x;
            a = a & 0xFF;
            if(Integer.toHexString(a).length()==1){
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(a));
            System.out.print(" ");
        }
        System.out.print("]");
    }

    public static void testLocalVars(LocalVars localVars){
        TestRef testRef = new TestRef();
        localVars.setInt(0, 142);
        localVars.setInt(1, 170);
        localVars.setLong(2, 8589934592L);
        localVars.setLong(4, 9223372036854775807L);
        localVars.setFloat(6, 3.1415926F);
        localVars.setDouble(7,2.71828182845D);
        localVars.setRef(9, null);
        //localVars.setRef(10, testRef);
        System.out.println(localVars.getInt(0));
        System.out.println(localVars.getInt(1));
        System.out.println(localVars.getLong(2));
        System.out.println(localVars.getLong(4));
        System.out.println(localVars.getFloat(6));
        System.out.println(localVars.getDouble(7));
        System.out.println(localVars.getRef(9));
        System.out.println(localVars.getRef(10));
    }

    public static void testOperandStack(OperandStack operandStack){
        TestRef testRef = new TestRef();
        operandStack.pushInt(142);
        operandStack.pushInt(170);
        operandStack.pushLong(8589934592L);
        operandStack.pushLong(9223372036854775807L);
        operandStack.pushFloat(3.1415925F);
        operandStack.pushDouble(2.71828182845D);
        operandStack.pushRef(null);
        //operandStack.pushRef(testRef);
        System.out.println(operandStack.popRef());
        System.out.println(operandStack.popRef());
        System.out.println(operandStack.popDouble());
        System.out.println(operandStack.popFloat());
        System.out.println(operandStack.popLong());
        System.out.println(operandStack.popLong());
        System.out.println(operandStack.popInt());
        System.out.println(operandStack.popInt());
    }

    public void testOpcode(){

    }

}

class TestRef {
    public TestRef(){

    }
}
