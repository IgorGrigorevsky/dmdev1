package ru.igor.dm.lesson2.arrays;

import java.util.Arrays;

public class Task1 {

    /*Дан одномерный массив целых чисел.
    Написать функцию, удаляющую из него все отрицательные элементы
    (удалить - значит создать новый массив с только положительными элементами).
    После удаления - умножить каждый элемент массива на его длину.
    Например: [3, 5, -6, 3, 2, -9, 0, -123] -> [15, 25, 15, 10, 0]*/

    public static void main(String[] args) {
        int[] array = {1, 3, 24, -7, 9, -123, 77, 0, -35, 5};
        System.out.println(Arrays.toString(changeForPositiveValue(array)));
    }

    private static int[] changeForPositiveValue(int[] array) {
        int[] newArray;
        int lengthOfNewArray = getPositiveNumberCount(array);
        newArray = new int[lengthOfNewArray];
        int x = 0;

        for (int j : array) {
            if (j >= 0) {
                newArray[x++] = j * lengthOfNewArray;
            }
        }
        return newArray;
    }

    private static int getPositiveNumberCount(int[] array) {
        int count = 0;
        for (int j : array) {
            if (j >= 0) {
                count++;
            }
        }
        return count;
    }
}
