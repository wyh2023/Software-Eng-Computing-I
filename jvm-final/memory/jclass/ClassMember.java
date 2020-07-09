package com.njuse.jvmfinal.memory.jclass;

import com.njuse.jvmfinal.classloader.classfileparser.constantpool.info.MemberRefInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ClassMember {
    public short accessFlags;
    public String name;
    public String descriptor;
    public JClass clazz;

    public boolean isPublic(){
        return (this.getAccessFlags() & AccessFlags.ACC_PUBLIC) != 0;
    }

    public boolean isPrivate() {
        return (this.getAccessFlags() & AccessFlags.ACC_PRIVATE) != 0;
    }

    public boolean isProtected() {
        return (this.getAccessFlags() & AccessFlags.ACC_PROTECTED) != 0;
    }

    public boolean isSTATIC() {
        return (this.getAccessFlags() & AccessFlags.ACC_STATIC) != 0;
    }

    public boolean isFINAL() {
        return (this.getAccessFlags() & AccessFlags.ACC_FINAL) != 0;
    }

    public boolean isAbstract() {
        return (this.getAccessFlags() & AccessFlags.ACC_ABSTRACT) != 0;
    }

    public boolean isLongOrDouble() {
        return descriptor.equals("J") || descriptor.equals("D");
    }

    public boolean isNative() {
        return 0 != (this.accessFlags & 256);
    }

    public boolean isAccessibleTo(JClass caller) {
        JClass callee = this.getClazz();
        if(callee.isPublic()) return true;
        if(this.isProtected()){
            return callee == caller || callee.isChildOf(caller) ||
                    callee.getPackageName().equals(caller.getPackageName());
        }
        if(!this.isProtected()){
            return callee.getPackageName().equals(caller.getPackageName());
        }
        return callee == caller;
    }

}
