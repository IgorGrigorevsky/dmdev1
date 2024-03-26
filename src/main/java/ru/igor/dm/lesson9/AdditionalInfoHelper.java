package ru.igor.dm.lesson9;

// дополнительный информационный помощник
public class AdditionalInfoHelper {

    private boolean isEnable;

    AdditionalInfoHelper() {
        this.isEnable = true;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    // тут возвращаем имя текущего потока для проверки
    public String getInfo() {
        String additionalInfo = Thread.currentThread().getName();
        return isEnable ? additionalInfo : null;
    }
}