package ru.igor.dm.lesson8.task1;

import java.util.LinkedList;
import java.util.List;

public class Planet extends Thread {

   /* Кристаллы растут на другой планете с рандомной скоростью от 2 до 5 рандомных кристаллов в сутки
            (может быть 1 красный и 2 белых, а может и вовсе все 4 кристалла красного цвета).*/

    private static final int CRYSTALS_COUNT = 3;
    public List<Crystal> crystalInPlanetList = new LinkedList<>();
    private final Midnight midnight;

    private final Object lock = new Object();

    public Object getLock() {
        return lock;
    }

    // конструктор без параметров
    public Planet(Midnight midnight) {
        this.midnight = midnight;

    }

    @Override
    public synchronized void run() {
        try {
            for (int i = 0; i < Midnight.AMOUNT_OF_MIDNIGHT; i++) {
                growNewCrystals();
                waitNextMidnight();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private void waitNextMidnight() throws InterruptedException {
        synchronized (midnight.getLock()) {
            midnight.getLock().wait();
        }
    }


    // метод добавления кристалов на планету после того, как они выросли
    private void growNewCrystals() {
        int countGrownCrystals = RandomHelper.getNextWithoutZero(CRYSTALS_COUNT);
        synchronized (getLock()) {
            for (int j = 0; j < countGrownCrystals; j++) {
                Crystal crystal = new Crystal();
                crystalInPlanetList.add(crystal);
            }
            System.out.println("на планете выросли новые кристаллы. Количество новых кристаллов: " + countGrownCrystals);
        }
    }

    public int size() {
        return crystalInPlanetList.size();
    }

    public boolean isNotEmpty() {
        return !crystalInPlanetList.isEmpty();
    }
}






