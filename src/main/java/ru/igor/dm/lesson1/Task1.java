package ru.igor.dm.lesson1;

import java.util.Arrays;
import java.util.List;

public class Task1 {

    private static final int MIN_FIRST_QUARTER = 0;
    private static final int MAX_FIRST_QUARTER = 15;
    private static final int MIN_SECOND_QUARTER = 16;
    private static final int MAX_SECOND_QUARTER = 30;
    private static final int MIN_THIRD_QUARTER = 31;
    private static final int MAX_THIRD_QUARTER = 45;
    private static final int MIN_FOURTH_QUARTER = 46;
    private static final int MAX_FOURTH_QUARTER = 59;


    //В переменной minutes лежит число от 0 до 59.
    //    Написать функцию, которая принимает в качестве параметра значение
    //    переменной minutes и выводит на консоль
    //    в какую четверть часа попадает это число (в первую, вторую,
    //    третью или четвертую).
    //
    //    Протестировать функцию в main.
    //

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(-1, 0, 15, 16, 30, 31, 45, 46, 59, 65);

        System.out.println("первый метод \n");
        for (Integer i : list) {
            whatQuarterByIf(i);
        }

        System.out.println("\nвторой метод \n");
        for (Integer e : list) {
            System.out.print("минута " + e + "  ");
            whatQuarterByDivision(e);
        }
    }

    private static void whatQuarterByIf(int minutes) {

        if (isInRange(minutes, MIN_FIRST_QUARTER, MAX_FIRST_QUARTER)) {
            print(minutes, 1);
        } else if (isInRange(minutes, MIN_SECOND_QUARTER, MAX_SECOND_QUARTER)) {
            print(minutes, 2);
        } else if (isInRange(minutes, MIN_THIRD_QUARTER, MAX_THIRD_QUARTER)) {
            print(minutes, 3);
        } else if (isInRange(minutes, MIN_FOURTH_QUARTER, MAX_FOURTH_QUARTER)) {
            print(minutes, 4);
        } else {
            System.out.println("не относится к интервалу от 0 до 59");
        }
    }

    private static boolean isInRange(int minutes, int min, int max) {
        return minutes >= min && minutes <= max;
    }

    private static void print(int minutes, int num) {
        String pattern = "минута %d относятся к %d четверти часа%n";
        System.out.printf(pattern, minutes, num);
    }

    private static void whatQuarterByDivision(int minutes) {
        if (minutes < 0 || minutes > 59) {
            System.out.println("не входит в диапазон от 0 до 59");
        } else {
            int quarterOfHour = 60 / 4;
            int quarter = (minutes - 1) / quarterOfHour;
            System.out.printf("относится к %d четверти часа %n", quarter + 1);
        }
    }
}
