package ru.igor.dm.lesson4.inheritance;

public class Sputnik extends NaturalObject implements SpaceObjects {
    private final String name;
    private final double weight;
    private final double radius;
    private final double initialDistance;


    public Sputnik(String name, double weight, double radius, double initialDistance) {
        this.name = name;
        this.weight = weight;
        this.radius = radius;
        this.initialDistance = initialDistance;
    }

    @Override
    public void whoAmI() {
        System.out.println("я - спутник");
    }

    @Override
    public void movementInSpace() {
        System.out.println("спутник вращается вокруг оси планеты, которую сопровождает");
    }

    @Override
    public void objectDestruction() {
        System.out.println("со временем спутник сгорает");
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public double getRadius() {
        return radius;
    }

    public double getInitialDistance() {
        return initialDistance;
    }

    @Override
    public String toString() {
        return "Спутник: " + name +
                ", вес спутника " + weight +
                ", радиус спутника: " + radius +
                ", расстояние от начальной точки космоса: " + initialDistance + " световых лет";
    }
}
