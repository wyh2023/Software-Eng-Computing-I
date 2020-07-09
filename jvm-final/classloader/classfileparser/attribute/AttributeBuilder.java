package com.njuse.jvmfinal.classloader.classfileparser.attribute;

import com.njuse.jvmfinal.classloader.classfileparser.BuildUtil;
import com.njuse.jvmfinal.classloader.classfileparser.attribute.smta.StackMapTableAttribute;
import com.njuse.jvmfinal.classloader.classfileparser.constantpool.info.ConstantPoolInfo;
import com.njuse.jvmfinal.classloader.classfileparser.constantpool.info.UTF8Info;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class AttributeBuilder {

    public static final String AnnotationDefault = "AnnotationDefault";
    public static final String BootstrapMethods = "BootstrapMethods";
    public static final String CharacterRangeTable = "CharacterRangeTable";
    public static final String Code = "Code";
    public static final String ConstantValue = "ConstantValue";
    public static final String CompilationID = "CompilationID";
    public static final String Deprecated = "Deprecated";
    public static final String EnclosingMethod = "EnclosingMethod";
    public static final String Exceptions = "Exceptions";
    public static final String InnerClasses = "InnerClasses";
    public static final String LineNumberTable = "LineNumberTable";
    public static final String LocalVariableTable = "LocalVariableTable";
    public static final String LocalVariableTypeTable = "LocalVariableTypeTable";
    public static final String MethodParameters = "MethodParameters";
    public static final String RuntimeVisibleAnnotations = "RuntimeVisibleAnnotations";
    public static final String RuntimeInvisibleAnnotations = "RuntimeInvisibleAnnotations";
    public static final String RuntimeVisibleParameterAnnotations = "RuntimeVisibleParameterAnnotations";
    public static final String RuntimeInvisibleParameterAnnotations = "RuntimeInvisibleParameterAnnotations";
    public static final String RuntimeVisibleTypeAnnotations = "RuntimeVisibleTypeAnnotations";
    public static final String RuntimeInvisibleTypeAnnotations = "RuntimeInvisibleTypeAnnotations";
    public static final String Signature = "Signature";
    public static final String SourceDebugExtension = "SourceDebugExtension";
    public static final String SourceFile = "SourceFile";
    public static final String SourceID = "SourceID";
    public static final String StackMap = "StackMap";
    public static final String StackMapTable = "StackMapTable";
    public static final String Synthetic = "Synthetic";
    private static Map<String, Class<? extends AttributeInfo>> standardAttributes;

    private static void init() {
        standardAttributes = new HashMap<>();
        standardAttributes.put(ConstantValue, ConstantValueAttr.class);
        standardAttributes.put(Code, CodeAttribute.class);
        standardAttributes.put(StackMapTable, StackMapTableAttribute.class);
        standardAttributes.put(Exceptions, ExceptionsAttribute.class);
        standardAttributes.put(BootstrapMethods, BootstrapMethodsAttribute.class);
    }


    public static AttributeInfo createAttribute(BuildUtil buildUtil) {
        if (standardAttributes == null) {
            init();
        }

        int attributeNameAndIndex = buildUtil.getU2();
        int attributeLength = (int) buildUtil.getU4();

        ConstantPoolInfo constantPoolInfo = buildUtil.getConstantPool().get(attributeNameAndIndex);

        if (constantPoolInfo instanceof UTF8Info) {
            String attrName = ((UTF8Info) constantPoolInfo).getString();
            //find the class of the attribute
            Class<? extends AttributeInfo> attrClz = standardAttributes.get(attrName);
            if (attrClz != null) {
                try {
                    //get the constructor of this attribute
                    Constructor<? extends AttributeInfo> constructor = attrClz.getDeclaredConstructor(
                            BuildUtil.class, Integer.TYPE, Integer.TYPE);
                    return constructor.newInstance(buildUtil, attributeNameAndIndex, attributeLength);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new UnsupportedOperationException("Error when parsing attribute " + attrName);
                }
            } else {
                //default attr info
                return new AttributeInfo(buildUtil, attributeNameAndIndex, attributeLength);
            }
        } else {
            throw new UnsupportedOperationException("The nameIndex of attribute is not a UTF-8 string!");
        }
    }

}
