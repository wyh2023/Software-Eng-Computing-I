package com.njuse.jvmfinal.memory.jclass.runtimeConstantPool;

import com.njuse.jvmfinal.classloader.classfileparser.constantpool.ConstantPool;
import com.njuse.jvmfinal.classloader.classfileparser.constantpool.info.*;
import com.njuse.jvmfinal.memory.jclass.JClass;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.Constant;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.other.NameAndType;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.other.UTF8;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.ref.ClassRef;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.ref.FieldRef;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.ref.InterfaceMethodRef;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.ref.MethodRef;
import com.njuse.jvmfinal.memory.jclass.runtimeConstantPool.constant.wrapper.*;
import lombok.Getter;
import lombok.Setter;

import static com.njuse.jvmfinal.classloader.classfileparser.constantpool.info.ConstantPoolInfo.*;

@Setter
@Getter
public class RuntimeConstantPool {
    private JClass clazz;
    private Constant[] constants;

    public RuntimeConstantPool(ConstantPool constantPool, JClass clazz) {
        this.clazz = clazz;
        ConstantPoolInfo[] infos = constantPool.getInfos();
        int length = infos.length - 1;//real num of constant pool item is length-1
        constants = new Constant[length];
        for (int i = 0; i < length; i++) {
            ConstantPoolInfo info = infos[i];
            switch (info.getTag()) {
                case INTEGER:
                    IntegerInfo intInfo = (IntegerInfo) info;
                    constants[i] = new IntWrapper(intInfo.getValue());
                    break;

                case FLOAT:
                    FloatInfo floatInfo = (FloatInfo) info;
                    constants[i] = new FloatWrapper(floatInfo.getValue());
                    break;

                case LONG:
                    LongInfo longInfo = (LongInfo) info;
                    constants[i] = new LongWrapper(longInfo.getValue());
                    //long value takes two slots
                    i++;
                    break;

                case DOUBLE:
                    DoubleInfo doubleInfo = (DoubleInfo) info;
                    constants[i] = new DoubleWrapper(doubleInfo.getValue());
                    //double value takes two slots
                    i++;
                    break;

                case STRING:
                    StringInfo stringInfo = (StringInfo) info;
                    constants[i] = new StringWrapper(stringInfo.getStringValue());
                    break;

                case CLASS:
                    ClassInfo classInfo = (ClassInfo) info;
                    constants[i] = new ClassRef(this, classInfo);
                    break;

                case FIELD_REF:
                    FieldrefInfo fieldrefInfo = (FieldrefInfo) info;
                    constants[i] = new FieldRef(this, fieldrefInfo);
                    break;

                case METHOD_REF:
                    MethodrefInfo methodrefInfo = (MethodrefInfo) info;
                    constants[i] = new MethodRef(this, methodrefInfo);
                    break;

                case INTERFACE_METHOD_REF:
                    InterfaceMethodrefInfo interfaceMethodrefInfo = (InterfaceMethodrefInfo) info;
                    constants[i] = new InterfaceMethodRef(this, interfaceMethodrefInfo);
                    break;
                case NAME_AND_TYPE:
                    NameAndTypeInfo nameAndTypeInfo = (NameAndTypeInfo) info;
                    constants[i] = new NameAndType(nameAndTypeInfo);
                    break;
                case ConstantPoolInfo.UTF8:
                    UTF8Info utf8Info = (UTF8Info) info;
                    constants[i] = new UTF8(utf8Info);
                    break;
                default:
                    break;
            }
        }

    }

    public Constant getConstant(int index) {
        assert index >= 1;
        return constants[index - 1];
    }
}
