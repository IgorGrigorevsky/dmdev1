package ru.igor.dm.lesson4.inheritance;

// для простоты расчетов я исхожу из того, что объекты имеют круглую форму

public abstract class NaturalObject extends SpaceObject {

    private double weight;
    private double radius;
    private double initialDistance;

    public abstract void objectDestruction();
}
