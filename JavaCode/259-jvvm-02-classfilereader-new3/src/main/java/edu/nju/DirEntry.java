package edu.nju;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * format : dir/subdir/.../
 */
public class DirEntry extends Entry{
    public DirEntry(String classpath) {
        super(classpath);
    }

    @Override
    public byte[] readClassFile(String className) throws IOException {
        File test = new File(classpath + FILE_SEPARATOR + className);
        if ( test.exists() ){
            InputStream inputstream = new FileInputStream(classpath + FILE_SEPARATOR + className);
            return IOUtil.readFileByBytes(inputstream);
        } else {
            return null;
        }
    }
}
