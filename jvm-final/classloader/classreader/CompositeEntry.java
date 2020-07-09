package com.njuse.jvmfinal.classloader.classreader;

import java.io.IOException;
import java.util.ArrayList;

public class CompositeEntry extends Entry {
    ArrayList<Entry> entries = new ArrayList<Entry>();

    public CompositeEntry(String classpath) {
        super(classpath);
        addElements(classpath);
    }

    @Override
    public byte[] readClass(String className) throws IOException {
        for (Entry entry : entries){
            byte[] ret = entry.readClass(className);
            if ( ret != null) return ret;
        }
        return null;
    }

    public void addElements(String classpath){
        String[] lst = classpath.split(PATH_SEPARATOR);
        for(String x : lst){
            //System.out.println(selectNewEntry(x));
            Entry entry = selectNewEntry(x);
            this.entries.add(entry);
        }
    }

    public Entry selectNewEntry(String classpath){
        if ( classpath.contains(".jar") || classpath.contains(".JAR") ||
             classpath.contains(".zip") || classpath.contains(".ZIP")) {
            return new ArchivedEntry(classpath);
        }
        if ( classpath.substring(classpath.length()-1).equals("*")){
            return new WildEntry(classpath);
        }
        return new DirEntry(classpath);
    }
}
