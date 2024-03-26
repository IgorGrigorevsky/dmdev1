package ru.igor.dm.lesson9;

import java.time.LocalDateTime;
import java.util.Objects;

// объект - исходная запись журнала
public class SourceLogRecord {
    private final long id;
    private final LocalDateTime dateTime;
    private final String name;
    private final String phone;
    private final String message;

    public SourceLogRecord(long id, LocalDateTime dateTime, String name, String phone, String message) {
        this.id = id;
        this.dateTime = dateTime;
        this.name = name;
        this.phone = phone;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SourceLogRecord that = (SourceLogRecord) o;
        return id == that.id
                && Objects.equals(dateTime, that.dateTime)
                && Objects.equals(name, that.name)
                && Objects.equals(phone, that.phone)
                && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateTime, name, phone, message);
    }

    @Override
    public String toString() {
        return "SourceLogRecord{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

}
