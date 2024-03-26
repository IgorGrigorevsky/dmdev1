package ru.igor.dm.lesson9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

// последний идентификатор
public class LastIdHandler {

    private static final String FILE_FOR_LAST_ID_PATH = String.valueOf(Path.of("src", "main", "java", "ru",
            "igor", "dm", "lesson9", "lastId.log"));

    private final FileWriteHelper fileWriteHelper = new FileWriteHelper();

    public void saveLastId(long lastId) {
        fileWriteHelper.write(String.valueOf(lastId), null, FILE_FOR_LAST_ID_PATH, false);
    }

    public void resetLastId() {
        this.saveLastId(-1);
    }

    public long getSavedLastId() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_FOR_LAST_ID_PATH))) {
            return Long.parseLong(reader.readLine());
        } catch (IOException e) {
            // Если не можем считать крайний обработанный id - читаем лог-файл с начала
            return -1;
        }
    }
}