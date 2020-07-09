package com.njuse.jvmfinal.classloader.classfileparser;

import com.njuse.jvmfinal.classloader.classfileparser.attribute.AttributeBuilder;
import com.njuse.jvmfinal.classloader.classfileparser.attribute.AttributeInfo;
import com.njuse.jvmfinal.classloader.classfileparser.constantpool.ConstantPool;
import com.njuse.jvmfinal.classloader.classfileparser.constantpool.info.ClassInfo;
import com.njuse.jvmfinal.memory.jclass.Method;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.tuple.Pair;

import java.nio.ByteBuffer;
import java.util.function.Supplier;

@Getter
@Setter
public class ClassFile {
    private int magic;
    private short minorVersion;
    private short majorVersion;
    private short constantPoolCount;
    private ConstantPool constantPool; //
    private short accessFlags;
    private short thisClass; //
    private short superClass; //
    private short interfacesCount; //
    private short[] interfaces; //
    private short fieldsCount;
    private FieldInfo[] fields;
    private short methodsCount;
    private MethodInfo[] methods;
    private short attributeCount;
    private AttributeInfo[] attributes;

    private ByteBuffer in;
    Supplier<AttributeInfo> attrBuilder = this::getAttribute;

    public ClassFile(byte[] classfile) {
        in = ByteBuffer.wrap(classfile);
        this.magic = in.getInt();
        if (this.magic != 0xCAFEBABE) {
            throw new UnsupportedOperationException(
                    "Wrong magic number! Expect 0xCAFEBABE but actual is " + Integer.toHexString(this.magic));
        }
        this.minorVersion = in.getShort();
        this.majorVersion = in.getShort();
        parseConstantPool(classfile);
        this.accessFlags = in.getShort();
        this.thisClass = in.getShort();
        this.superClass = in.getShort();
        parseInterfaces();
        parseFields();
        parseMethods();
        parseAttributes();

    }

    private void parseAttributes() {
        this.attributeCount = in.getShort();
        this.attributes = new AttributeInfo[0xFFFF & this.attributeCount];
        for (int i = 0; i < attributes.length; i++) {
            this.attributes[i] = attrBuilder.get();
        }
    }


    private void parseMethods() {
        this.methodsCount = in.getShort();
        this.methods = new MethodInfo[0xFFFF & this.methodsCount];
        for (int i = 0; i < this.methods.length; i++) {
            this.methods[i] = new MethodInfo(this.constantPool, this.attrBuilder, in);
        }
    }

    private void parseFields() {
        this.fieldsCount = in.getShort();
        this.fields = new FieldInfo[0xFFFF & this.fieldsCount];
        for (int i = 0; i < this.fields.length; i++) {
            this.fields[i] = new FieldInfo(this.constantPool, this.attrBuilder, in);
        }
    }

    private void parseInterfaces() {
        this.interfacesCount = in.getShort();
        interfaces = new short[0xFFFF & this.interfacesCount];
        for (int i = 0; i < this.interfaces.length; i++) {
            this.interfaces[i] = in.getShort();
        }
    }

    private void parseConstantPool(byte[] classfile) {
        this.constantPoolCount = in.getShort();
        int currentPos = in.position();
        Pair<ConstantPool, Integer> cpInt = ConstantPool.getInstance(constantPoolCount, classfile, currentPos);
        constantPool = cpInt.getKey();
        currentPos += cpInt.getValue();
        in.position(currentPos);
    }

    public AttributeInfo getAttribute() {
        return AttributeBuilder.createAttribute(new BuildUtil(this.constantPool, in));
    }

    public String getClassName() {
        return ((ClassInfo) constantPool.get(thisClass)).getClassName();
    }

    public String getSuperClassName() {
        return ((ClassInfo) constantPool.get(superClass)).getClassName();
    }

    public String[] getInterfaceNames() {
        String[] ret = new String[interfacesCount];
        for (int i = 0; i < interfacesCount; i++) {
            ret[i] = ((ClassInfo) constantPool.get(interfaces[i])).getClassName();
        }
        return ret;
    }

    public MethodInfo getMainMethodInfo(){
        for(MethodInfo x: this.getMethods()){
            if (x.getName().equals("main") && x.getDescriptor().equals("([Ljava/lang/String;)V")){
                return x;
            }
        }
        return null;
    }

}
