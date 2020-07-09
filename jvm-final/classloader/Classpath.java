package com.njuse.jvmfinal.classloader;

import com.njuse.jvmfinal.classloader.classreader.*;
import com.njuse.jvmfinal.util.IOUtil;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.tuple.Pair;

import java.io.File;
import java.io.IOException;

@Getter
@Setter
public class Classpath {
    Entry bootClasspath;
    Entry extClasspath;
    Entry userClasspath;

    public Classpath(String classpath){
        String jre = getJREString();
        setBootClasspath(jre);
        setExtClasspath(jre);
        setUserClasspath(classpath);
    }

    public Pair<byte[], Entry> readClass(String className) throws IOException, ClassNotFoundException {
        className = IOUtil.transform(className);
        byte[] ret = null;
        Entry entry = null;
        try {
            ret = bootClasspath.readClass(className);
            entry = bootClasspath;
            if( ret == null ){
                ret = extClasspath.readClass(className);
                entry = extClasspath;
                if( ret == null ){
                    ret = userClasspath.readClass(className);
                    entry = userClasspath;
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        if(ret == null) throw new ClassNotFoundException();
        return Pair.of(ret, entry);
    }

    public void setBootClasspath(String jre){
        String libPath = String.join(File.separator, jre, "lib", "*");
        this.bootClasspath = new WildEntry(libPath);
    }

    public void setExtClasspath(String jre){
        String extPath = String.join(File.separator, jre, "lib", "ext", "*");
        this.extClasspath = new WildEntry(extPath);
    }

    public void setUserClasspath(String cp){
        this.userClasspath = markEntry(cp);
    }

    public String getJREString() {
        String javahome = System.getenv("JAVA_HOME");
        return String.join(File.separator, javahome, "jre");
    }

    public Entry markEntry(String classpath){
        if( classpath.contains(File.pathSeparator) ){
            return new CompositeEntry(classpath);
        }
        if( classpath.substring(classpath.length()-1).equals("*") ){
            return new WildEntry(classpath);
        }
        if ( classpath.contains(".jar") || classpath.contains(".JAR") ||
                classpath.contains(".zip") || classpath.contains(".ZIP")) {
            return new ArchivedEntry(classpath);
        }
        return new DirEntry(classpath);
    }
}
