package ru.igor.dm.lesson4.inheritance;

public class SpaceRunner {
    public static void main(String[] args) {

        Sputnik moon = new Sputnik("Луна", 700, 45, 140);
        Sputnik[] sputnik = new Sputnik[]{moon};
        Planet earth = new Planet("Земля", true, true, true, 1, 1000, 500, 300, sputnik);
        Star star = new Star("Феникс", 55, 17, 333, 133);
        Comet comet = new Comet("Комета Галлея", 1000, 500, 50, 30, 7000);
        Asteroid asteroid = new Asteroid("Астероид Церера", 1000, 300, 25, 6500);
        ISS iss = new ISS("Спутник-7", 3, 700, 100, 3000);
        Cosmonaut cosmonaut1 = new Cosmonaut(iss, "Петр", "физик", "Россия", 77.00);
        Cosmonaut cosmonaut2 = new Cosmonaut(iss, "Афанасий", "химик-биолог", "Беларусь", 80.00);


        cosmonaut1.goIntoSpace();
        cosmonaut2.goIntoSpace();
        cosmonaut1.returnToTheShip();
        cosmonaut2.returnToTheShip();
        System.out.println("количество космонавтов на станции: " + iss.getCountWorkers());
        iss.returnEarth();
        System.out.println("температура звезды: "+ star.getTemperature());

        moon.objectDestruction();
        asteroid.objectDestruction();
        comet.objectDestruction();

        System.out.println(asteroid.getDiameter(asteroid.getRadius()));
        System.out.println(earth.getDiameter(earth.getRadius()));

        cosmonaut1.whoAmI();
        iss.whoAmI();
        asteroid.whoAmI();
        comet.whoAmI();
        System.out.println("процент льда в составе кометы: " + comet.getPercentIce());
        comet.burnedDown();

        System.out.println("Сила гравитации между " + moon + " и" + earth + SpaceUtils.gravityForce(moon, earth));
        System.out.println("Сила гравитации между " + star + " и" + asteroid +SpaceUtils.gravityForce(star, asteroid));

        SpaceUtils.isStar(moon);
        SpaceUtils.isStar(earth);
        SpaceUtils.isStar(star);

        System.out.println(moon);
        System.out.println(cosmonaut2);
        System.out.println(star);
        System.out.println(earth);
    }
}
