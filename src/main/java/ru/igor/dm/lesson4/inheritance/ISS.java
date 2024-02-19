package ru.igor.dm.lesson4.inheritance;

public class ISS extends ArtificialObject implements SpaceObjects {

    private final String name;
    private final int countWorkers;
    private final double weight;
    private final double radius;
    private final double initialDistance;

    public ISS(String name, int countWorkers, double weight, double radius, double initialDistance) {
        this.name = name;
        this.countWorkers = countWorkers;
        this.weight = weight;
        this.radius = radius;
        this.initialDistance = initialDistance;
    }

    @Override
    public void whoAmI() {
        System.out.println("я - международная космическая станция");
    }

    @Override
    public void movementInSpace() {
        System.out.println("Космическая станция движется в космическом пространстве по заданным координатам");

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

    public String getName() {
        return name;
    }

    @Override
    public void returnEarth() {
        System.out.println("Космонавты на международной космической станции вернулись домой на планету Земля");
    }

    @Override
    public String toString() {
        return "Международная космическая станция " +
                " с названием: " + name +
                ", количество сотрудников: " + countWorkers +
                ", вес космической станции: " + weight +
                ", радиус космической станции: " + radius +
                ", расстояние от начальной точки космоса: " + initialDistance +
                " световых лет";
    }
}
