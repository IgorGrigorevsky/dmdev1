package ru.igor.dm.lesson4.inheritance;

public class ISS extends ArtificialObject implements SpaceObjects{
    private final int countWorkers;
    private final double weight;
    private final double radius;
    private final double initialDistance;

    public ISS(int countWorkers, double weight, double radius, double initialDistance) {
        this.countWorkers = countWorkers;
        this.weight = weight;
        this.radius = radius;
        this.initialDistance = initialDistance;
    }

    @Override
    public void whoAmI() {
        System.out.println("я - международная космическая станция");
    }

    public double getInitialDistance() {
        return initialDistance;
    }

    public int getCountWorkers() {
        return countWorkers;
    }

    public double getWeight() {
        return weight;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "ISS{" +
                "countWorkers=" + countWorkers +
                ", weight=" + weight +
                ", radius=" + radius +
                ", initialDistance=" + initialDistance +
                '}';
    }
}
