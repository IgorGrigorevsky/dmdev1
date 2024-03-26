package ru.igor.dm.lesson9;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// реализация обработчика журнала
public class LogHandler {

    private static final int COLUMNS_COUNT = 5;

    private static final String REGEX_ID = "\\d{1,19}";
    private static final String REGEX_DATE_TIME = "20\\d{2}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}";
    private static final String REGEX_NAME = "[А-ЯЁ][а-яё]+(-[А-ЯЁ][а-яё]+)?\\s[А-ЯЁ][а-яё]+(-[А-ЯЁ][а-яё]+)?";
    private static final String REGEX_PHONE = "(\\+)?(375)?(\\d{2})(\\d{3})(\\d{2})(\\d{2})";


    public SourceLogRecord parseLogLine(String line) {
        String[] split = line.split("\\s*,\\s*");
        if (split.length != 5) {
            throw new IllegalArgumentException(
                    String.format("Количество столбцов не равно %d: %s", COLUMNS_COUNT, line));
        }
        return new SourceLogRecord(
                parseId(split[0]),
                parseDateTime(split[1]),
                parseName(split[2]),
                parsePhone(split[3]),
                split[4]);
    }

    private long parseId(String id) {
        if (!id.matches(REGEX_ID)) {
            throw new IllegalArgumentException("Id должен содержать только цифры, не более 19 цифр: " + id);
        }
        return Long.parseLong(id);
    }

    private LocalDateTime parseDateTime(String dateTime) {
        if (!dateTime.matches(REGEX_DATE_TIME)) {
            throw new IllegalArgumentException("DateTime должен соответствовать формату 'yyyy-MM-dd HH:mm:ss': " + dateTime);
        }
        return LocalDateTime.parse(dateTime);
    }

    private String parseName(String name) {
        if (!name.matches(REGEX_NAME)) {
            throw new IllegalArgumentException("Имя и фамилия должны быть разделены пробелами, " +
                    "начинаться с большой буквы, и содержать только русские буквы и дефисы: " + name);
        }
        return name;
    }

    private String parsePhone(String phone) {
        String phoneDigits = phone.replaceAll("\\D", "");
        if (!phoneDigits.matches(REGEX_PHONE)) {
            throw new IllegalArgumentException("Телефон должен состоять из 9 цифр," +
                    "в начале возможен код страны РБ '+375': " + phone);
        }
        return phoneDigits;
    }


    public String getTargetLogRecord(SourceLogRecord source) {
        String formattedDateTime = source.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        String formattedPhone = source.getPhone().replaceAll(REGEX_PHONE, "+375 ($3) $4-$5-$6");
        return String.format("%d, %s, %s", source.getId(), formattedDateTime, formattedPhone);
    }
}