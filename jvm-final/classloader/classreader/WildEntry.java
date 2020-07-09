package com.njuse.jvmfinal.classloader.classreader;

import java.io.File;
import java.io.IOException;

public class WildEntry extends Entry {

    public WildEntry(String classpath) {
        super(classpath);
    }

    @Override
    public byte[] readClass(String className) throws IOException {
        File file = new File(classpath.replace(FILE_SEPARATOR+"*", ""));
        String[] files = file.list();
        //System.out.println(classpath.replace(FILE_SEPARATOR+"*", ""));
        if( files != null ){
            //System.out.println(stringConstructor(files, classpath, PATH_SEPARATOR));
            CompositeEntry comp = new CompositeEntry(stringConstructor(files, classpath, PATH_SEPARATOR));
            return comp.readClass(className);
        }
        return null;
    }

    public static String stringConstructor(String[] files, String classpath, String PATH_SEPERATOR){
        StringBuilder str = new StringBuilder();
        for( String file : files){
            str.append(classpath.replace("*", file));
            str.append(PATH_SEPERATOR);
        }
        return str.toString();
    }
}
