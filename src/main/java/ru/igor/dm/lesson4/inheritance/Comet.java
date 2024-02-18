package ru.igor.dm.lesson4.inheritance;

public class Comet  extends NaturalObject implements SpaceObjects{

    private double weight;
    private double radius;
    // длина хвоста
    private double tailLength;
    private double percentIce;
    private double initialDistance;


    public Comet(double weight, double radius, double tailLength, double percentIce, double initialDistance) {
        this.weight = weight;
        this.radius = radius;
        this.tailLength = tailLength;
        this.percentIce = percentIce;
        this.initialDistance = initialDistance;
    }

    public void burnedDown () {
        System.out.println("комета сгорела при падении");
    }

    @Override
    public void whoAmI() {
        System.out.println("я - комета");
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

    public double getPercentIce() {
        return percentIce;
    }

    public double getInitialDistance() {
        return initialDistance;
    }

    @Override
    public String toString() {
        return "Comet{" +
                "weight=" + weight +
                ", radius=" + radius +
                ", tailLength=" + tailLength +
                ", percentIce=" + percentIce +
                ", initialDistance=" + initialDistance +
                '}';
    }
}
