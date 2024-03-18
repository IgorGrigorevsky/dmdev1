package ru.igor.dm.lesson8.task1;

import java.util.Random;

public final class RandomHelper {

    private static final Random RANDOM = new Random();

    private RandomHelper() {
    }

    public static int getNextWithoutZero(int count) {
        return RANDOM.nextInt(count) + 2;
    }

    public static int getNext(int count) {

        return RANDOM.nextInt(count);
    }
}