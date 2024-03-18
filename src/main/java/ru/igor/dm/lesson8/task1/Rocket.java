package ru.igor.dm.lesson8.task1;

import java.util.ArrayList;
import java.util.List;

public class Rocket extends Thread {

    /*Маги огня и маги воздуха отправляют раз в сутки по ракете за добычей кристаллов.
    Каждая ракета может погрузить на борт от 2 до 5 рандомных кристаллов.
    Если кристаллов нет - ракета улетает пустой.*/
    private final Midnight midnight;
    private final Race race;
    private final Planet planet;

    public Rocket(Midnight midnight, Race race, Planet planet) {
        this.midnight = midnight;
        this.race = race;
        this.planet = planet;
    }

    @Override
    public synchronized void run() {
        try {

            for (int i = 0; i < Midnight.AMOUNT_OF_MIDNIGHT; i++) {
                List<Crystal> listOfGotCrystals = gatherCrystalsFromPlanet();
                race.getCrystalsFromRocket(listOfGotCrystals);
                gatherCrystalsFromPlanet().clear();
                System.out.println("ракета пуста - ждем следующий полет");
                System.out.println(" ");
                race.printInfo();
                if (race.win()) {
                    System.out.println("УРАААААА - команда " + race.getName() + " победила!!! и больше не соревнуется");
                    break;
                }
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

    private List<Crystal> gatherCrystalsFromPlanet() {
        List<Crystal> сrystalsInRocket = new ArrayList<>();
        synchronized (planet.getLock()) {
            if (planet.isNotEmpty()) {
                for (int i = 0; i < planet.crystalInPlanetList.size(); i++) {
                    Crystal removedCrystal = planet.crystalInPlanetList.remove(RandomHelper.getNext(planet.crystalInPlanetList.size()));
                    сrystalsInRocket.add(removedCrystal);
                }
                System.out.println("ракета " + race.getName() + " забрала кристаллы: " + сrystalsInRocket.size());
            }

        }
        return сrystalsInRocket;
    }
}
