package ru.igor.dm.lesson4.inheritance;

public class SpaceRunner {
    public static void main(String[] args) {


        Sputnik moon = new Sputnik(700, 45, 140);
        NaturalObject earth = new Planet(true, true, true, 1, 1000, 500, 300, moon);
        NaturalObject star = new Star(55, 17, 333, 133);

        System.out.println(SpaceUtils.gravityForce(moon, earth));

        SpaceUtils.isStar(moon);
        SpaceUtils.isStar(earth);
        SpaceUtils.isStar(star);

        System.out.println(SpaceObject.getDiameter(moon.getRadius()));
        System.out.println(SpaceObject.massComparison(earth.getWeight(), star.getWeight()));

        // полиморфизм
        ((Planet) earth).whoAmI();
        ((Star) star).whoAmI();


    }
}
