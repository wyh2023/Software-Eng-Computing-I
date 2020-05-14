package edu.nju;

import java.io.IOException;

/**
 * format : dir/subdir;dir/subdir/*;dir/target.jar*
 */
public class CompositeEntry extends Entry{
    public CompositeEntry(String classpath) {
        super(classpath);
    }

    @Override
    public byte[] readClassFile(String className) throws IOException {
        String[] classPaths = classpath.split(PATH_SEPARATOR);
        byte[] res = null;
        for (String classPath : classPaths) {
            if (classPath.contains("JAR") || classPath.contains("jar")) {
                ArchivedEntry arch = new ArchivedEntry(classPath);
                res = arch.readClassFile(className);
            } else if (classPath.contains("*")) {
                WildEntry wild = new WildEntry(classPath);
                res = wild.readClassFile(className);
            } else {
                DirEntry dir = new DirEntry(classPath);
                res = dir.readClassFile(className);
            }
            if (res != null) return res;
        }
        return res;
    }
}
