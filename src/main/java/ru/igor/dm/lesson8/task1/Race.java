package ru.igor.dm.lesson8.task1;

import java.util.ArrayList;
import java.util.List;

public class Race {

    String name;
    private int redCrystalCount;
    private int whiteCrystalCount;
    List<Crystal> crystalsInRace = new ArrayList<>();

    /*
     * Существует две постоянно соревнующиеся расы: маги огня и маги воздуха.
    Их задача - как можно быстрее набрать 500 красных и 500 белых кристаллов.*/

    public Race(String name) {
        this.name = name;

    }

    public void getCrystalsFromRocket(List<Crystal> list) {
        if (!list.isEmpty()) {
            crystalsInRace.addAll(list);
            System.out.println(this.getName() + " забрали с ракеты " + list.size() + " кристаллов");
            list.clear();
        }
    }

    public void printCountWhiteCrystals(List<Crystal> list) {
        whiteCrystalCount = 0;
        for (Crystal crystal : crystalsInRace) {
            if (crystal.getColour().equals("white")) {
                whiteCrystalCount++;
            }
        }
        System.out.println(this.getName() + "  -> количество белых кристалов " + whiteCrystalCount);
    }

    public void printCountRedCrystals(List<Crystal> list) {
        redCrystalCount = 0;
        for (Crystal crystal : crystalsInRace) {
            if (crystal.getColour().equals("red")) {
                redCrystalCount++;
            }
        }
        System.out.println(this.getName() + " -> количество красных кристалов " + redCrystalCount);
    }

    public List<Crystal> getCrystalsInRace() {
        return crystalsInRace;
    }

    public int getRedCrystalCount() {
        return redCrystalCount;
    }

    public int getWhiteCrystalCount() {
        return whiteCrystalCount;
    }

    public String getName() {

        return name;
    }

    public boolean win() {
        return this.getRedCrystalCount() >= 10 && this.getWhiteCrystalCount() >= 10;
    }

    public void printInfo() {
        System.out.println(this.getName() + "\nобщее количество кристаллов: " + crystalsInRace.size());
        this.printCountRedCrystals(this.getCrystalsInRace());
        this.printCountWhiteCrystals(this.getCrystalsInRace());
        System.out.println("\n");
    }
}
