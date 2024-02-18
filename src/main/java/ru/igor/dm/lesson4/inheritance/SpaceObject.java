package ru.igor.dm.lesson4.inheritance;

public class SpaceObject {

    private double weight;
    private double radius;
    // начальное значение расстояния от центральной точки космоса
    private final double initialDistance = 0;

    // метод расчета диаметра космического объекта, если мы предполагаем, что они круглые
    public static double getDiameter(double radius) {
        return radius * 2;
    }

    // метод, сравнивающий массы 2 космических объектов
    public static boolean massComparison(double weight1, double weight2) {
        if (weight1 > weight2) {
            System.out.println("масса первого объекта больше массы второго объекта");
            return true;
        }
        return false;
    }

    public double getWeight() {
        return weight;
    }

    public double getRadius() {
        return radius;
    }

    public double getInitialDistance() {
        return initialDistance;
    }
}
