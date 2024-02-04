package ru.igor.dm.lesson2.arrays;

import java.util.Arrays;

public class Task3 {

    /*Дан одномерный массив целых чисел.

    Написать функцию, которая принимает этот массив и разбивает на 3 других:
    с только отрицательными числами, только положительными и только нули.
    Если для какого-то из массивов не будет значений, то должен быть создан пустой массив.
    Возвращает функция эти три массива в виде одного двумерного.

            Пример:
            [-4, -18]
            [-4, 0, 1, 9, 0, -18, 3] -> [0, 0]
            [1, 9, 3]
     */

    public static void main(String[] args) {

        int[] array = {-4, 0, 1, 9, 0, -18, 3};
        System.out.println(Arrays.deepToString(doubleArray(array)));
    }

    private static int countPositiveNumbers(int[] array) {
        int positiveNumber = 0;
        for (int j : array) {
            if (j > 0) {
                positiveNumber++;
            }
        }
        return positiveNumber;
    }

    private static int countNegativeNumbers(int[] array) {
        int negativeNumber = 0;
        for (int j : array) {
            if (j < 0) {
                negativeNumber++;
            }
        }
        return negativeNumber;
    }

    private static int countZeroNumbers(int[] array) {
        int zeroNumber = 0;
        for (int j : array) {
            if (j == 0) {
                zeroNumber++;
            }
        }
        return zeroNumber;
    }

    private static int[][] doubleArray(int[] array) {
        int[][] doubleArray = new int[3][];
        doubleArray[0] = new int[countPositiveNumbers(array)];
        doubleArray[1] = new int[countZeroNumbers(array)];
        doubleArray[2] = new int[countNegativeNumbers(array)];
        int p = 0;
        int n = 0;
        int z = 0;
        for (int j : array) {
            if (j > 0) {
                doubleArray[0][p++] = j;
            } else if (j == 0) {
                doubleArray[1][z++] = j;
            } else {
                doubleArray[2][n++] = j;
            }
        }
        return doubleArray;
    }
}
