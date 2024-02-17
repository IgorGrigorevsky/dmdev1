package ru.igor.dm.lesson2.cycles;

import java.util.Scanner;

public class Task1 {

    /*Посчитать четные и нечетные цифры целого числа и вывести их на консоль.
    Для решения написать 2 функции, которые будут принимать введенное целое число,
    а возвращать количество четных цифр (вторая функция - нечетных).

    Например: если введено число 228910, то у него 4 четные цифры (2, 2, 8, 0) и 2 нечетные (9, 1).*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите целое число:");
        int x = sc.nextInt();

        //нечетное - Odd четное - Even
        returnOddNumberCountByFor(x);
        returnOddNumberCountByWhile(x);
        returnEvenNumberCountByFor(x);
        returnEvenNumberCountByWhile(x);
    }

    private static void returnOddNumberCountByFor(int value) {
        int count = 0;
        for (int i = value; i > 0; i /= 10) {
            if ((i % 10) % 2 != 0) {
                count++;
            }
        }
        System.out.println("количество нечетных чисел составляет: " + count);
    }

    private static void returnOddNumberCountByWhile(int value) {
        int count = 0;
        int i = value;
        while (i > 0) {
            if ((i % 10) % 2 != 0) {
                count++;
            }
            i = i / 10;
        }
        System.out.println("количество нечетных чисел составляет: " + count);
    }

    private static void returnEvenNumberCountByFor(int value) {
        int count = 0;
        for (int i = value; i > 0; i /= 10) {
            if ((i % 10) % 2 == 0) {
                count++;
            }
        }
        System.out.println("количество четных чисел составляет: " + count);
    }

    private static void returnEvenNumberCountByWhile(int value) {
        int count = 0;
        int i = value;
        while (i > 0) {
            if ((i % 10) % 2 == 0) {
                count++;
            }
            i = i / 10;
        }
        System.out.println("количество четных чисел составляет: " + count);
    }
}
