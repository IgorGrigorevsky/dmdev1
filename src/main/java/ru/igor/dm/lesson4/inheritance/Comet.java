package ru.igor.dm.lesson4.inheritance;

public class Comet extends NaturalObject implements SpaceObjects {

    private final String name;
    private final double weight;
    private final double radius;
    // длина хвоста
    private final double tailLength;
    private final double percentIce;
    private final double initialDistance;


    public Comet(String name, double weight, double radius, double tailLength, double percentIce, double initialDistance) {
        this.name = name;
        this.weight = weight;
        this.radius = radius;
        this.tailLength = tailLength;
        this.percentIce = percentIce;
        this.initialDistance = initialDistance;
    }

    public void burnedDown() {
        System.out.println("комета сгорела при падении на Землю");
    }

    @Override
    public void whoAmI() {
        System.out.println("я - комета");
    }

    @Override
    public void movementInSpace() {
        System.out.println("комета вращается вокруг Солнца");
    }

    @Override
    public void objectDestruction() {
        System.out.println("комета разрушается каждый раз, когда приближается к Солнцу");
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

    public double getTailLength() {
        return tailLength;
    }

    public double getPercentIce() {
        return percentIce;
    }

    public double getInitialDistance() {
        return initialDistance;
    }

    @Override
    public String toString() {
        return "Комета " + name +
                "вес кометы: " + weight +
                ", радиус кометы: " + radius +
                ", длина хвоста кометы: " + tailLength +
                ", процент льда в составе кометы: " + percentIce +
                ", расстояние от начальной точки космоса: " + initialDistance + " световых лет";
    }
}
