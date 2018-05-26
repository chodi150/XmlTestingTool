package com.example.projektpik.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Piotr on 26.05.2018.
 */
public class TempFileCreator {

    public static File createTempFile(String body) throws IOException {
        File file = new File("temp");
        FileWriter fw = new FileWriter(file);
        fw.write(body);
        fw.close();
        return file;
    }
}
