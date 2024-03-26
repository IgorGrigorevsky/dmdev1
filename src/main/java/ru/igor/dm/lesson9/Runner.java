package ru.igor.dm.lesson9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Runner {
    public static void main(String[] args) throws InterruptedException {

        WorkManager workManager = new WorkManager();
        LastIdHandler lastIdHandler = new LastIdHandler();
        AdditionalInfoHelper additionalInfoHelper = new AdditionalInfoHelper();

        // Опционально - начинаем рабочий день с повторной обработки всех записей
        // если закомментируем, то будем читать файл с последнего id в файле, если нет, то читаем с самого начала
        lastIdHandler.resetLastId();

        // Начинаем рабочий день с еще не обработанных записей - получаем последний id
        long lastId = lastIdHandler.getSavedLastId();

        // выводим в консоль дополнительную информацию в getInfo - получаем текущий поток
        System.out.println(additionalInfoHelper.getInfo());

        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            executor.execute(() -> workManager.startWork(lastId));
        } finally {
            executor.shutdown();
            try {
                executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }

        Thread.sleep(1500);
        workManager.stopWork();

        //выводим какой поток
        System.out.println(additionalInfoHelper.getInfo());
    }
}

