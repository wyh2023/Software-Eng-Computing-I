package com.njuse.jvmfinal.classloader.classfileparser.constantpool.info;

import com.njuse.jvmfinal.classloader.classfileparser.BuildUtil;
import com.njuse.jvmfinal.classloader.classfileparser.constantpool.ConstantPool;
import org.apache.commons.lang3.tuple.Pair;

import java.nio.ByteBuffer;

public class ConstantPoolInfo {
    public static final byte CLASS = 7;
    public static final byte FIELD_REF = 9;
    public static final byte METHOD_REF = 10;
    public static final byte INTERFACE_METHOD_REF = 11;
    public static final byte STRING = 8;
    public static final byte INTEGER = 3;
    public static final byte FLOAT = 4;
    public static final byte LONG = 5;
    public static final byte DOUBLE = 6;
    public static final byte NAME_AND_TYPE = 12;
    public static final byte UTF8 = 1;
    public static final byte METHOD_HANDLE = 15;
    public static final byte METHOD_TYPE = 16;
    public static final byte INVOKE_DYNAMIC = 18;
    protected byte tag;
    protected ConstantPool myCP;

    public ConstantPoolInfo(ConstantPool myCP) {
        this.myCP = myCP;
    }

    /**
     * return the constant pool info instance and
     * the number of bytes read by this method
     */
    public static Pair<ConstantPoolInfo, Integer> getConstantPoolInfo(ConstantPool constantPool, byte[] classfile, int ofs) {
        ByteBuffer buffer = ByteBuffer.wrap(classfile, ofs, classfile.length - ofs);
        BuildUtil in = new BuildUtil(buffer);
        ConstantPoolInfo ret;
        int tag = in.getU1();
        int bytesRead = 1;
        switch (tag) {
            case CLASS:
                ret = new ClassInfo(constantPool, in.getU2());
                bytesRead += 2;
                break;
            case FIELD_REF: {
                ret = new FieldrefInfo(constantPool, in.getU2(), in.getU2());
                bytesRead += 4;
                break;
            }
            case METHOD_REF: {
                ret = new MethodrefInfo(constantPool, in.getU2(), in.getU2());
                bytesRead += 4;
                break;
            }
            case INTERFACE_METHOD_REF: {
                ret = new InterfaceMethodrefInfo(constantPool, in.getU2(), in.getU2());
                bytesRead += 4;
                break;
            }
            case STRING: {
                ret = new StringInfo(constantPool, in.getU2());
                bytesRead += 2;
                break;
            }

            case INTEGER: {
                ret = new IntegerInfo(constantPool, read4Bytes(in));
                bytesRead += 4;
                break;
            }

            case FLOAT: {
                ret = new FloatInfo(constantPool, read4Bytes(in));
                bytesRead += 4;
                break;
            }

            case LONG: {
                ret = new LongInfo(constantPool, read4Bytes(in), read4Bytes(in));
                bytesRead += 8;
                break;
            }

            case DOUBLE: {
                ret = new DoubleInfo(constantPool, read4Bytes(in), read4Bytes(in));
                bytesRead += 8;
                break;
            }
            case NAME_AND_TYPE: {
                ret = new NameAndTypeInfo(constantPool, in.getU2(), in.getU2());
                bytesRead += 4;
                break;
            }

            case UTF8: {
                Pair<UTF8Info, Integer> utf8InfoIntegerPair = UTF8Info.getInstance(constantPool, classfile, in.getByteBuffer().position());
                ret = utf8InfoIntegerPair.getKey();
                bytesRead += utf8InfoIntegerPair.getValue();
                break;
            }

            case METHOD_HANDLE: {
                ret = new MethodHandleInfo(constantPool, in.getU1(), in.getU2());
                bytesRead += 3;
                break;
            }

            case METHOD_TYPE: {
                ret = new MethodTypeInfo(constantPool, in.getU2());
                bytesRead += 2;
                break;
            }

            case INVOKE_DYNAMIC: {
                ret = new InvokeDynamicInfo(constantPool, in.getU2(), in.getU2());
                bytesRead += 4;
                break;
            }

            default:
                throw new UnsupportedOperationException("Unsupported constant pool tag" + tag);
        }
        return Pair.of(ret, bytesRead);
    }

    private static byte[] read4Bytes(BuildUtil in) {
        byte b1 = in.getByteBuffer().get();
        byte b2 = in.getByteBuffer().get();
        byte b3 = in.getByteBuffer().get();
        byte b4 = in.getByteBuffer().get();
        return new byte[]{b1, b2, b3, b4};
    }

    public int getEntryLength() {
        return 1;
    }

    public byte getTag() {
        return tag;
    }
}
