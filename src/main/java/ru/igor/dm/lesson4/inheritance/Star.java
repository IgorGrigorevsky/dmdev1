package ru.igor.dm.lesson4.inheritance;

public class Star extends NaturalObject implements SpaceObjects {

    private final double weight;
    private final double radius;
    private final double temperature;
    private final double initialDistance;

    public Star(double weight, double radius, double temperature, double initialDistance) {
        this.weight = weight;
        this.radius = radius;
        this.temperature = temperature;
        this.initialDistance = initialDistance;
    }

    @Override
    public void whoAmI() {
        System.out.println("я - звезда");
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public double getRadius() {
        return radius;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getInitialDistance() {
        return initialDistance;
    }

    @Override
    public String toString() {
        return "Star{" +
                "weight=" + weight +
                ", radius=" + radius +
                ", temperature=" + temperature +
                ", initialDistance=" + initialDistance +
                '}';
        }
}
