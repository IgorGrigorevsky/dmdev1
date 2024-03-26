package ru.igor.dm.lesson9;

public class DispatcherService {
    private static final int TASK_DURATION = 500;

    private final FileWriteHelper fileWriteHelper = new FileWriteHelper();
    private final AdditionalInfoHelper additionalInfoHelper = new AdditionalInfoHelper();
    private final LogHandler logHandler = new LogHandler();

    public void processLine(SourceLogRecord sourceLogRecord, String targetLogPath, boolean isWorkAllowed) {
        if (!isWorkAllowed) {
            return;
        }
        try {
            // делает работу пол секунды
            Thread.sleep(TASK_DURATION);
            //формируем строку для записи в лог и записываем ее в лог
            String line = logHandler.getTargetLogRecord(sourceLogRecord);
            fileWriteHelper.write(line, additionalInfoHelper.getInfo(), targetLogPath, true);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
