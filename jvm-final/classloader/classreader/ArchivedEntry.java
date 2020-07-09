package com.njuse.jvmfinal.classloader.classreader;

import com.njuse.jvmfinal.util.IOUtil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ArchivedEntry extends Entry {
    public String absDir;

    public ArchivedEntry(String classpath){
        super(classpath);
        this.absDir = new File(classpath).getAbsolutePath();
    }

    //className doesn't contain ".class"
    @Override
    public byte[] readClass(String className) throws IOException {
        File dir = new File(this.classpath);
        String absDirPath = dir.getAbsolutePath();
        ZipFile zipFile = new ZipFile(absDirPath);
        Enumeration entries = zipFile.entries();

        ZipEntry ze;
        String pathName;
        do {
            if (!entries.hasMoreElements()) {
                return null;
            }

            ze = (ZipEntry)entries.nextElement();
            pathName = transform(ze.getName());
        } while(!pathName.equals(className + ".class"));

        return IOUtil.readFileByBytes(zipFile.getInputStream(ze));
    }

    public String toString() {
        return absDir;
    }

    public String constructPath(String className) {
        return IOUtil.transform(absDir + FILE_SEPARATOR
                + className.replace(".", FILE_SEPARATOR) + ".class");
    }

    public static String transform(String pathName) {
        return pathName.contains("/") ? pathName.replace("/", File.separator) : pathName;
    }
}
