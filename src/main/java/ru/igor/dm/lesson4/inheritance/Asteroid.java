package ru.igor.dm.lesson4.inheritance;

public class Asteroid extends NaturalObject implements SpaceObjects {

    private final String name;
    private final double weight;
    private final double radius;
    // длина хвоста
    private final double tailLength;
    private final double initialDistance;

    public Asteroid(String name, double weight, double radius, double tailLength, double initialDistance) {
        this.name = name;
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
        System.out.println("астероид взорвался при падении на Землю");
    }

    @Override
    public void objectDestruction() {
        System.out.println("астероид разрушается, сталкиваясь с другими астероидами");

    }

    @Override
    public void movementInSpace() {
        System.out.println("астероид вращается вокруг Солнца");

    }

    @Override
    public double getWeight() {
        return weight;
    }

    public double getRadius() {
        return radius;
    }

    public String getName() {
        return name;
    }

    public double getTailLength() {
        return tailLength;
    }

    public double getInitialDistance() {
        return initialDistance;
    }

    @Override
    public String toString() {
        return "Астероид " + name +
                " вес астероида: " + weight +
                ", радиус астероида: " + radius +
                ", длина хвоста астероида: =" + tailLength +
                ", расстояние от начальной точки космоса: " + initialDistance + " световых лет";
    }
}
