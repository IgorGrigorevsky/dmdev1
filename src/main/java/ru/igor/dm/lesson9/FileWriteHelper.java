package ru.igor.dm.lesson9;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteHelper {

    public void write(String line, String additionalInfo, String filePath, boolean append) {
        String fullLine = line + (additionalInfo != null ? (", " + additionalInfo) : "");

        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(), append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(fullLine + System.lineSeparator());
            bufferedWriter.close();
            System.out.println(fullLine);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}