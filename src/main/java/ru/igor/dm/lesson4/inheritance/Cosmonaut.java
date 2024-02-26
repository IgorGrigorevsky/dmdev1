package ru.igor.dm.lesson4.inheritance;

public class Cosmonaut extends ArtificialObject implements SpaceObjects {
    private final ISS iss;
    private final String name;
    private final String fieldOfKnowledge;
    private final String country;
    private final double weight;

    public Cosmonaut(ISS iss, String name, String fieldOfKnowledge, String country, double weight) {
        this.iss = iss;
        this.name = name;
        this.fieldOfKnowledge = fieldOfKnowledge;
        this.country = country;
        this.weight = weight;

    }

    @Override
    public void returnEarth() {
        System.out.println("космонавт вернулся на международную станцию для подготовки к возвращению домой");
        iss.returnEarth();
    }

    @Override
    public void whoAmI() {
        System.out.println("Я космонавт");
    }

    @Override
    public void movementInSpace() {
        System.out.println("Космонавт плывет в космическом пространстве в нужную точку");
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public void goIntoSpace() {
         System.out.println("Космонавт вышел в открытый космос из корабля для сбора данных");
    }

    public void returnToTheShip() {
        System.out.println("Космонавт вернулся из открытого космоса на корабль для отдыха");
    }

    @Override
    public String toString() {
        return "Космонавт " +
                "с именем: " + name +
                ", профессор в области " + fieldOfKnowledge + '\'' +
                ", гражданин " + country + '\'' +
                " работает на космической станции: " + iss.getName() +
                ", вес космонавта" + weight;
    }
}
