package edu.nju;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * format : dir/subdir/target.jar
 */
public class ArchivedEntry extends Entry{
    public ArchivedEntry(String classpath) {
        super(classpath);
    }

    @Override
    public byte[] readClassFile(String className) throws IOException {
        ZipFile zipFile = new ZipFile(classpath);
        String FileClassPath = null;
        ZipEntry out = null;
        for (Enumeration<? extends ZipEntry> e = zipFile.entries(); e.hasMoreElements();){
            ZipEntry entry=e.nextElement();
            FileClassPath = entry.getName();
            out = entry;
        }
        assert FileClassPath != null;
        FileClassPath = IOUtil.transform(FileClassPath);
        String[] ss  = classpath.split(Matcher.quoteReplacement(File.separator));
        System.out.println(out);
       if(FileClassPath.equals(className)){
           InputStream inputstream  = zipFile.getInputStream(out);
           return IOUtil.readFileByBytes(inputstream);
       } else {
           return null;
       }

        /*
        assert FileClassPath != null;
        InputStream inputstream  = new FileInputStream(FileClassPath);
        return IOUtil.readFileByBytes(inputstream);
         */
    }
}
