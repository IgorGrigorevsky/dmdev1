package ru.igor.dm.lesson4.inheritance;

public abstract class SpaceObject {

    private double weight;
    private double radius;
    // начальное значение расстояния от центральной точки космоса
    private double initialDistance;

    // метод расчета диаметра космического объекта, если мы предполагаем, что они все круглые
    public double getDiameter(double radius) {
        return radius * 2;
    }

    // метод, сравнивающий массы 2 космических объектов
    public boolean massComparison(double weight1, double weight2) {
        if (weight1 > weight2) {
            System.out.println("масса первого объекта больше массы второго объекта");
            return true;
        }
        return false;
    }
    public abstract double getWeight();

    public double getRadius() {
        return radius;
    }

    public double getInitialDistance() {
        return initialDistance;
    }
}
