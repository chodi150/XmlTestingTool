package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Piotr on 19.05.2018.
 */
public class FileUtil {
    private FileUtil(){
    }

    public static void saveFile(String filename, String content) throws IOException {
        File file = new File( filename );
        FileWriter fw = new FileWriter(file);
        fw.write(content);
        fw.close();

    }
}
