package ru.igor.dm.lesson1;

import java.util.Arrays;
import java.util.List;

public class Task1 {

    public static final int MIN_FIRST_QUARTER = 0;
    public static final int MAX_FIRST_QUARTER = 15;
    public static final int MIN_SECOND_QUARTER = 16;
    public static final int MAX_SECOND_QUARTER = 30;
    public static final int MIN_THIRD_QUARTER = 31;
    public static final int MAX_THIRD_QUARTER = 45;
    public static final int MIN_FOURTH_QUARTER = 46;
    public static final int MAX_FOURTH_QUARTER = 59;


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

    public static void whatQuarterByIf(int minutes) {

        if (minutes >= MIN_FIRST_QUARTER && minutes <= MAX_FIRST_QUARTER) {
            print(minutes, 1);
        } else if (minutes >= MIN_SECOND_QUARTER && minutes <= MAX_SECOND_QUARTER) {
            print(minutes, 2);
        } else if (minutes >= MIN_THIRD_QUARTER && minutes <= MAX_THIRD_QUARTER) {
            print(minutes, 3);
        } else if (minutes >= MIN_FOURTH_QUARTER && minutes <= MAX_FOURTH_QUARTER) {
            print(minutes, 4);
        } else {
            System.out.println("не относится к интервалу от 0 до 59");
        }
    }

    private static void print(int minutes, int num) {
        String pattern = "минута %d относятся к %d четверти часа%n";
        System.out.printf(pattern, minutes, num);
    }

    public static void whatQuarterByDivision(int minutes) {
        if (minutes < 0 || minutes > 59) {
            System.out.println("не входит в диапазон от 0 до 59");
        } else {
            int quarterOfHour = 60 / 4;
            int quarter = (minutes - 1) / quarterOfHour;
            System.out.printf("относится к %d четверти часа %n", quarter + 1);
        }
    }
}
