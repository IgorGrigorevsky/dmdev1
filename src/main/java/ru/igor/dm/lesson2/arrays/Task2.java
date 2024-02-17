package ru.igor.dm.lesson2.arrays;

public class Task2 {

   /* Дан одномерный массив символов.
    Преобразовать его в одномерный массив чисел, где число - это код символа
    (любой символ - это число в памяти компьютера).
    Например: [‘a’, ‘6’, ‘y’, ‘P’, ‘T’, ‘q’, ‘9’, ‘+’] -> [97, 54, 121, 80, 84, 113, 57, 43]

    Далее определить среднее арифметическое всех элементов целочисленного массива и вывести на
     консоль только те элементы, которые больше этого среднего арифметического.
*/

    public static void main(String[] args) {

        char[] array = {'a', '6', 'y', 'P', 'T', 'q', '9', '+'};
        sum(changeIntoIntArray(array));

    }

    private static int[] changeIntoIntArray(char[] charArray) {
        int[] array = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            array[i] = charArray[i];
        }
        return array;
    }

    private static double average(int[] array) {
        int average = 0;
        for (int j : array) {
            average += j;
        }
        return (double) average / array.length;
    }

    private static void sum(int[] array) {
        System.out.println("среднее арифметическое значение чисел массива - " + average(array));
        for (int j : array) {
            if (j > average(array)) {
                System.out.println(j + " выше " + average(array));
            }
        }
    }
}
