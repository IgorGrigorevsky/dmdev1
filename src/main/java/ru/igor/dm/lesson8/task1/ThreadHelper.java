package ru.igor.dm.lesson8.task1;


public final class ThreadHelper {

    ThreadHelper() {
    }

    public static void startThreads(Thread... threads) {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public static void joinThreads(Thread... threads) throws InterruptedException {
        for (Thread thread : threads) {
            thread.join();
        }
    }

    public void interruptThreads(Thread... threads) throws InterruptedException {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
}
