package ru.igor.dm.lesson8.task1;

public class Runner {
    public static void main(String[] args) throws InterruptedException {

        /**
         * Существует две постоянно соревнующиеся расы: маги огня и маги воздуха.
         Их задача - как можно быстрее набрать 500 красных и 500 белых кристаллов.

         Кристаллы растут на другой планете с рандомной скоростью от 2 до 5 рандомных кристаллов в сутки
         (может быть 1 красный и 2 белых, а может и вовсе все 4 кристалла красного цвета).

         Маги огня и маги воздуха отправляют раз в сутки по ракете за добычей кристаллов.
         Каждая ракета может погрузить на борт от 2 до 5 рандомных кристаллов.
         Если кристаллов нет - ракета улетает пустой.

         Написать программу, которая симулирует процесс заполнения кристаллов у магов огня и воздуха.
         Для симуляции принять, что и кристаллы создаются, и ракеты прилетают в одно и то же время - полночь.

         Соревнование заканчивается, когда какая-то раса соберет необходимые кристаллы. */


        Midnight midnight = new Midnight();
        Planet planet = new Planet(midnight);

        Race race1 = new Race("Маги огня");
        Race race2 = new Race("Маги воздуха");
        Rocket rocket1 = new Rocket(midnight, race1, planet);
        Rocket rocket2 = new Rocket(midnight, race2, planet);

        ThreadHelper.startThreads(midnight, planet, rocket1, rocket2);
        ThreadHelper.joinThreads(midnight, planet, rocket1, rocket2);


        viewStatistic(race1, race2);

    }


    private static void viewStatistic(Race race1, Race race2) {
        System.out.println("----------------");
        race1.printInfo();
        System.out.println();
        System.out.println();
        race2.printInfo();
    }
}


