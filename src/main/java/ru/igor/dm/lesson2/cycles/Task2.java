package ru.igor.dm.lesson2.cycles;

import java.util.Scanner;

public class Task2 {

    /*Дано целое число.
    Написать функцию, которая принимает целое число, а возвращает целое число обратное этому (не строку!).
    Результат вывести на консоль.
    Например: 4508 -> 8054, 4700 -> 74, 1234567 -> 7654321

    Примечание: для решения может понадобиться функция возведение числа в степень: Math.pow(число, степень)*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        mirrorShow(x);

    }

    // 1428 - взять остаток от деления -> записать его в другую переменную и так, пока число не закончится
    //4508
    private static void mirrorShow(int x) {
        int number = 0;
        for (int i = x; i > 0; i /= 10) {
            number = ((i % 10) + number) * 10;
        }
        System.out.println(number/10);
    }
}
