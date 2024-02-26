package ru.igor.dm.lesson4.inheritance;

import java.util.Arrays;

public class Planet extends NaturalObject implements SpaceObjects {

    private String name;
    private final boolean hasLife;
    private final boolean hasWater;
    private final boolean hasAtmosphere;
    private final int numberOfSputniks;
    private final double weight;
    private final double radius;
    private final double initialDistance;
    private final Sputnik[] sputnik;

    public Planet(String name, boolean hasLife, boolean hasWater, boolean hasAtmosphere, int numberOfSputniks, double weight,
                  double radius, double initialDistance, Sputnik[] sputnik) {
        this.name = name;
        this.hasLife = hasLife;
        this.hasWater = hasWater;
        this.hasAtmosphere = hasAtmosphere;
        this.numberOfSputniks = numberOfSputniks;
        this.weight = weight;
        this.radius = radius;
        this.initialDistance = initialDistance;
        this.sputnik = sputnik;
    }

    @Override
    public void whoAmI() {
        System.out.println("я - планета");
    }

    @Override
    public void movementInSpace() {
        System.out.println("планеты вращается вокруг Солнца");
    }

    @Override
    public void objectDestruction() {
        System.out.println("в идеальных условиях планета не разрушается");

    }

    public boolean isHasLife() {
        return hasLife;
    }

    public boolean isHasWater() {
        return hasWater;
    }

    public boolean isHasAtmosphere() {
        return hasAtmosphere;
    }

    public int getNumberOfSputniks() {
        return numberOfSputniks;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public double getRadius() {
        return radius;
    }

    public double getInitialDistance() {
        return initialDistance;
    }

    public Sputnik[] getSputnik() {
        return sputnik;
    }

    @Override
    public String toString() {
        return "Планета: " + name +
                " имеется ли на планете жизнь? " + hasLife +
                ", имеется ли на планете вода? " + hasWater +
                ", имеется ли на планете атмосфера? " + hasAtmosphere +
                ", сколько у планеты спутников? " + numberOfSputniks +
                ", вес планеты: " + weight +
                ", радиус планеты " + radius +
                ", расстояние от начальной точки космоса " + initialDistance + " световых лет" +
                ", спутники планеты: " + Arrays.toString(sputnik);
    }
}
