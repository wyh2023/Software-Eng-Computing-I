package edu.nju;

import java.io.*;

public class IOUtil {
    public static byte[] readFileByBytes(InputStream is) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            BufferedInputStream in = null;
            in = new BufferedInputStream(is);
            int buf_size = 1024;
            byte[] buffer = new byte[buf_size];
            int len = 0;
            while (-1 != (len = in.read(buffer, 0, buf_size))) {
                bos.write(buffer, 0, len);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static String transform(String pathName) {
        if (pathName.contains("/")) {
            return pathName.replace("/", File.separator);
        }
        return pathName;
    }
}
