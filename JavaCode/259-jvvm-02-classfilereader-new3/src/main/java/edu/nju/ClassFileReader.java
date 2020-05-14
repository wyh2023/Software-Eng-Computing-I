package edu.nju;

import java.io.File;
import java.io.IOException;

public class ClassFileReader {
    private static final String FILE_SEPARATOR = File.separator;
    private static final String PATH_SEPARATOR = File.pathSeparator;

    private static Entry bootStrapReader;

    public static Entry chooseEntryType(String classpath) {
        /**
         * tips:
         *      Every case can correspond to a class
         *      These cases are disordered
         *      You should take care of the order of if-else
         * case 1 classpath with wildcard
         * case 2 normal dir path
         * case 3 archived file
         * case 4 classpath with path separator
         */
        if ( classpath.contains(PATH_SEPARATOR) ){
            return new CompositeEntry(classpath);
        } else {
            if ( classpath.contains("*") ){
                return new WildEntry(classpath);
            } else if ( classpath.contains(".jar")||classpath.contains(".JAR") ){
                return new ArchivedEntry(classpath);
            } else {
                return new DirEntry(classpath);
            }
        }
    }

    /**
     *
     * @param classpath where to find target class
     * @param className format: /package/.../class
     * @return content of classfile
     */
    public static byte[] readClassFile(String classpath,String className) throws ClassNotFoundException{
        if (className == null || classpath == null) throw new ClassNotFoundException();
        className = IOUtil.transform(className);
        className += ".class";
        bootStrapReader = chooseEntryType(classpath);
        byte[] ret = new byte[0];
        try {
            ret = bootStrapReader.readClassFile(className);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (ret==null)throw new ClassNotFoundException();
        return ret;
    }
}
