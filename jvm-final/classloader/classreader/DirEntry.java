package com.njuse.jvmfinal.classloader.classreader;

import com.njuse.jvmfinal.util.IOUtil;

import java.io.*;

public class DirEntry extends Entry {
    public String absDir;

    public DirEntry(String classpath) {
        super(classpath);
        this.absDir = new File(classpath).getAbsolutePath();
    }

    //className doesn't contain ".class"
    @Override
    public byte[] readClass(String className) throws IOException {
        File file = new File(constructPath(className));
        if ( file.exists() ) {
            InputStream inputStream = new FileInputStream(constructPath(className));
            return IOUtil.readFileByBytes(inputStream);
        } else {
            return null;
        }
    }

    public String constructPath(String className) {
        return IOUtil.transform(absDir + FILE_SEPARATOR
                + className.replace(".", FILE_SEPARATOR) + ".class");
    }

    public String toString() {
        return absDir;
    }

    public static String transform(String pathName) {
        return pathName.contains("/") ? pathName.replace("/", File.separator) : pathName;
    }

}
