package ru.igor.dm.lesson4.inheritance;

public class Planet extends NaturalObject implements SpaceObjects {

    private final boolean hasLife;
    private final boolean hasWater;
    private final boolean hasAtmosphere;
    private final int numberOfSputniks;
    private final double weight;
    private final double radius;
    private final double initialDistance;
    private final Sputnik sputnik;

    public Planet(boolean hasLife, boolean hasWater, boolean hasAtmosphere, int numberOfSputniks, double weight, double radius, double initialDistance, Sputnik sputnik) {
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

    public Sputnik getSputnik() {
        return sputnik;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "hasLife=" + hasLife +
                ", hasWater=" + hasWater +
                ", hasAtmosphere=" + hasAtmosphere +
                ", numberOfSputniks=" + numberOfSputniks +
                ", weight=" + weight +
                ", radius=" + radius +
                ", initialDistance=" + initialDistance +
                ", sputnik=" + sputnik +
                '}';
    }
}
