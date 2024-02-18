package ru.igor.dm.lesson4.inheritance;

public class Asteroid extends NaturalObject implements SpaceObjects {
    private double weight;
    private double radius;
    // длина хвоста
    private double tailLength;
    private double initialDistance;

    public Asteroid(double weight, double radius, double tailLength, double initialDistance) {
        this.weight = weight;
        this.radius = radius;
        this.tailLength = tailLength;
        this.initialDistance = initialDistance;
    }

    @Override
    public void whoAmI() {
        System.out.println("Я - астероид");
    }

    public void explode() {
        System.out.println("комета взорвалась при падении");
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public double getRadius() {
        return radius;
    }

    public double getTailLength() {
        return tailLength;
    }

    public double getInitialDistance() {
        return initialDistance;
    }

    @Override
    public String toString() {
        return "Asteroid{" +
                "weight=" + weight +
                ", radius=" + radius +
                ", tailLength=" + tailLength +
                ", initialDistance=" + initialDistance +
                '}';
    }
}
