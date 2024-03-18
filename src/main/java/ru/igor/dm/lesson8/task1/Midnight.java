package ru.igor.dm.lesson8.task1;

public class Midnight extends Thread {

    public static final int AMOUNT_OF_MIDNIGHT = 20;
    public static final int MIDNIGHT_INTERVAL = 100;
    private final Object lock = new Object();

    @Override
    public synchronized void run() {

        for (int i = 0; i < AMOUNT_OF_MIDNIGHT; i++) {
            synchronized (lock) {
                try {
                    System.out.printf("----------------\nMidnight %s started\n", (i + 1));
                    lock.notifyAll();
                    lock.wait(MIDNIGHT_INTERVAL);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    public Object getLock() {
        return lock;
    }
}




