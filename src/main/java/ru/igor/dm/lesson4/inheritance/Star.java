package ru.igor.dm.lesson4.inheritance;

public class Star extends NaturalObject implements SpaceObjects {

    private final String name;
    private final double weight;
    private final double radius;
    private final double temperature;
    private final double initialDistance;

    public Star(String name, double weight, double radius, double temperature, double initialDistance) {
        this.name = name;
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
    public void movementInSpace() {
        System.out.println("звезда вращается вокруг своей оси");
    }

    @Override
    public void objectDestruction() {
        System.out.println("звезда взрывается, оставляя после себя черные дыры и нейтронные звезды");
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

    public String getName() {
        return name;
    }

    public double getInitialDistance() {
        return initialDistance;
    }

    @Override
    public String toString() {
        return "Звезда " + name +
                ", вес звезды: " + weight +
                ", радиус звезды: " + radius +
                ", температура звезды: " + temperature +
                ", расстояние от начальной точки космоса: " + initialDistance + " световых лет";
    }
}
