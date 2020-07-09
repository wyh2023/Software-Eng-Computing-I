package com.njuse.jvmfinal.memory.heap;

import com.njuse.jvmfinal.memory.jclass.JClass;

import java.util.ArrayList;

public class ArrayObject extends MyObject {

    public ArrayObject(JClass jClass, Object array){
        this.jClass = jClass;
        this.data = array;
        this.isNull = false;
        this.isArray = true;
    }

    public int[] getBytes(){
        return (int[]) data;
    }

    public int[] getShorts(){
        return (int[]) data;
    }

    public int[] getInts(){
        return (int[]) data;
    }

    public long[] getLongs(){
        return (long[]) data;
    }

    public int[] getChars(){
        return (int[]) data;
    }

    public float[] getFloats(){
        return (float[]) data;
    }

    public double[] getDoubles(){
        return (double[]) data;
    }

    public MyObject[] getRefs(){
        return (MyObject[]) data;
    }

    public int length(){
        switch (this.data.getClass().getSimpleName()) {
            case "byte[]":
            case "short[]":
            case "int[]":
                return ((int[]) data).length;
            case "long[]":
                return ((long[]) data).length;
            case "char[]":
                return ((char[]) data).length;
            case "float[]":
                return ((float[]) data).length;
            case "double[]":
                return ((double[]) data).length;
            case "MyObject[]":
                return ((MyObject[]) data).length;
            default:
                throw new RuntimeException("wrong type of the Array!");
        }
    }
}
