package ru.igor.dm.lesson4.inheritance;

public class Sputnik extends NaturalObject implements SpaceObjects {
    private final double weight;
    private final double radius;
    private final double initialDistance;


    public Sputnik(double weight, double radius, double initialDistance) {
        this.weight = weight;
        this.radius = radius;
        this.initialDistance = initialDistance;
    }

    @Override
    public void whoAmI() {
        System.out.println("я - спутник");
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

    @Override
    public String toString() {
        return "Sputnik{" +
                ", weight=" + weight +
                ", radius=" + radius +
                ", initialDistance=" + initialDistance +
                '}';
    }
}
