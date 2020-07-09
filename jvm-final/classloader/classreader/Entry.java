package com.njuse.jvmfinal.classloader.classreader;

import java.io.File;
import java.io.IOException;

public abstract class Entry {
    public final String PATH_SEPARATOR = "" + File.pathSeparator;
    public final String FILE_SEPARATOR = "" + File.separator;
    public String classpath;

    public Entry(String classpath) {
        this.classpath = classpath;
    }

    public String toString(){
        return classpath;
    }

    public abstract byte[] readClass(String className) throws IOException;
}
