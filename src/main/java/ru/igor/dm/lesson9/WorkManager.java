package ru.igor.dm.lesson9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WorkManager {

    private static final String SOURCE_LOG_PATH = String.valueOf(Path.of("src", "main", "java", "ru",
            "igor", "dm", "lesson9", "input.log"));
    private static final String TARGET_LOG_PATH = String.valueOf(Path.of("src", "main", "java", "ru",
            "igor", "dm", "lesson9", "output.log"));

    // количество потоков - это количество работников, которые обзванивают
    private static final int EMPLOYEE_COUNT = 3;


    //нижний код нужно в класс хелпер
    private final LogHandler logHandler = new LogHandler();
    private final LastIdHandler lastIdHandler = new LastIdHandler();
    private final FileWriteHelper fileWriteHelper = new FileWriteHelper();
    private final AdditionalInfoHelper additionalInfoHelper = new AdditionalInfoHelper();
    private final DispatcherService dispatcherService = new DispatcherService();

    // создаем три потока
    private final ExecutorService executor = Executors.newFixedThreadPool(EMPLOYEE_COUNT);

    private volatile boolean isWorkAllowed = true;

    public void startWork(long lastId) {
        try (BufferedReader reader = new BufferedReader(new FileReader(SOURCE_LOG_PATH))) {
            fileWriteHelper.write(String.format("Начало рабочего дня: %s", LocalDateTime.now()),
                    additionalInfoHelper.getInfo(), TARGET_LOG_PATH, true);
            String sourceLogLine;
            while (isWorkAllowed && (sourceLogLine = reader.readLine()) != null) {
                // у объекта обработчик журнала мы вызываем метод парсинга строки, куда передаем прочитанную строку
                // на выходе получаем объект "исходная запись журнала" и присваиваем это значение
                SourceLogRecord sourceLogRecord = logHandler.parseLogLine(sourceLogLine);
                // Пропускаем прочитанные строки
                if (sourceLogRecord.getId() <= lastId) {
                    continue;
                }
                // по очереди берем сотрудников и кидаем их на обработку записей-строк
                executor.execute(() ->
                        dispatcherService.processLine(sourceLogRecord, TARGET_LOG_PATH, isWorkAllowed));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
            try {
                executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
                ie.printStackTrace();
            } finally {
                lastIdHandler.saveLastId(lastId);
                fileWriteHelper.write(String.format("Конец рабочего дня: %s", LocalDateTime.now()),
                        additionalInfoHelper.getInfo(), TARGET_LOG_PATH, true);
            }
        }
    }

    public void stopWork() {
        isWorkAllowed = false;
    }
}