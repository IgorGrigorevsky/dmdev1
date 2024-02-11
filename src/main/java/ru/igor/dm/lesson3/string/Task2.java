package ru.igor.dm.lesson3.string;

import java.util.Arrays;

public class Task2 {

  /*Задание 2
    Дана строка с текстом, в котором есть цифры от 0 до 9.
    Написать 2 метода:
            - возвращающий массив цифр из переданной строки
            - возвращающий сумму цифр из переданного целочисленного массива

    Посчитать сумму всех чисел из строки
    Например:
            “Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?” -> 18 (8+1+2+4+3) */

    public static void main(String[] args) {
        String value = "Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?";
        System.out.println(Arrays.toString(returnsArray(value)));
        System.out.println(sum(value));

    }

    private static Integer [] returnsArray(String value) {
        String st = value.replaceAll("\\D", "");
        Integer [] result = new Integer [st.length()];
        for (int i = 0; i < st.length(); i++) {
            result[i] = Integer.parseInt(String.valueOf(st.charAt(i)));
        }
        return result;
    }

    private static int sum (String value) {
        int sum = 0;
        for (Integer i : (returnsArray(value))) {
            sum+=i;
        }
        return sum;
    }
}
