package edu.nju;

import org.junit.Test;
import seec.test.util.classfileparser.ClassFile;
import static org.junit.Assert.*;

import java.io.File;
import java.util.Arrays;

public class ClassFileReaderTest {
    public static final String PATH_SEPARATOR = File.pathSeparator;
    public static final String FILE_SEPARATOR = File.separator;
    private static final String OBJECT = "java/lang/Object";
    private static final String BASE_PATH=String.join(FILE_SEPARATOR,"src","test","testfilepath");

    private boolean readClass(String classpath,String expectedName){
        byte[] res;
        try {
            res = ClassFileReader.readClassFile(classpath,expectedName);
        } catch (ClassNotFoundException e) {
            return false;
        }
        assert res != null;
        //System.out.println(Arrays.toString(res));
        ClassFile classFile = new ClassFile(res);
        String realName = classFile.getClassName();
        return realName.equals(expectedName);
    }

    @Test
    public void testWildCardSuccess() throws ClassNotFoundException {
        assertTrue(readClass(String.join(FILE_SEPARATOR,BASE_PATH,"dir","subdir","*"),OBJECT));
    }

    @Test
    public void testWildCardFail(){
        assertFalse(readClass(String.join(FILE_SEPARATOR,BASE_PATH,"dir","*"),OBJECT));
    }

    @Test
    public void testDirSuccess(){
        assertTrue(readClass(String.join(FILE_SEPARATOR,BASE_PATH,"dir"),OBJECT));

    }

    @Test
    public void testDirFail(){
        assertFalse(readClass(String.join(FILE_SEPARATOR,BASE_PATH,"dir","subdir"),OBJECT));
    }

    @Test
    public void testArchivedSuccess(){
        assertTrue(readClass(String.join(FILE_SEPARATOR,BASE_PATH,"dir","subdir","rt.JAR"),OBJECT));
    }

    @Test
    public void testArchivedFail(){
        assertFalse(readClass(String.join(FILE_SEPARATOR,BASE_PATH,"dir","subdir","empty.jar"),OBJECT));
    }

    @Test
    public void testCompositeSuccess(){
        String dirPath = String.join(FILE_SEPARATOR,BASE_PATH,"subdir");
        String archivedPath = String.join(FILE_SEPARATOR,BASE_PATH,"dir","subdir","rt.JAR");
        String wildPath = String.join(FILE_SEPARATOR,BASE_PATH,"dir","*");
        String compositePath = String.join(PATH_SEPARATOR,dirPath,archivedPath,wildPath);
        assertTrue(readClass(compositePath,OBJECT));
    }

    @Test
    public void testCompositeFail(){
        String dirPath = String.join(FILE_SEPARATOR,BASE_PATH,"subdir");
        String archivedPath = String.join(FILE_SEPARATOR,BASE_PATH,"dir","subdir","empty.jar");
        String wildPath = String.join(FILE_SEPARATOR,BASE_PATH,"dir","*");
        String compositePath = String.join(PATH_SEPARATOR,dirPath,archivedPath,wildPath);
        assertFalse(readClass(compositePath,OBJECT));
    }

    @Test
    public void testNull(){
        assertFalse(readClass(null,null));
    }
}
