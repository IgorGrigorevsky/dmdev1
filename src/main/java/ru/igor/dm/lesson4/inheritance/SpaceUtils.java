package ru.igor.dm.lesson4.inheritance;

public final class SpaceUtils {

    // предполагаем, что гравитация для всех тел в космосе 1.7
    final static double G = 1.7;

    private SpaceUtils() {
    }

    public static boolean isStar(SpaceObject spaceObject) {
        if (spaceObject.getClass() != Star.class) {
            System.out.println("данный объект не является звездой");
            return false;
        }
        System.out.println("данный объект является звездой");
        return true;
    }

    // предположим, что сила гравитации между объектами рассчитывается делением
    // их расстояния от нулевой точки друг на друга и умножением на константу
    public static double gravityForce(SpaceObject spaceObject1, SpaceObject spaceObject2) {
        return spaceObject1.getInitialDistance() / spaceObject2.getInitialDistance() * G;
    }
}
