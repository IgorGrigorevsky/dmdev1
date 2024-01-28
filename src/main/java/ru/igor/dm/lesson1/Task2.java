package ru.igor.dm.lesson1;


import java.util.Arrays;
import java.util.List;

public class Task2 {//Даны 3 переменные:
    //
    //- operand1 (double)
    //- operand2 (double)
    //- operation (char ‘+’, ‘-’, ‘*’, ‘/’, ‘%’)
    //
    //Написать функцию, которая принимает в качестве параметров эти три переменные и возвращает результат операции.
    //Протестировать функцию в main.
    //
    //Например:
    //
    //Параметры: operand1 = 24.4, operand2 = 10.1, operation = ‘+’
    //Результат: 34.5 (24.4 + 10.1)
    public static final char INTEGER_DIVISION = '%';
    public static final char SUM = '+';
    public static final char SUBTRACT = '-';
    public static final char MULTIPLY = '*';
    public static final char DIVISION = '/';
    public static final char BAD_CHAR = 'K';

    public static void main(String[] args) {

        List<Character> operations = Arrays.asList(SUM, SUBTRACT, MULTIPLY, BAD_CHAR, DIVISION, INTEGER_DIVISION, BAD_CHAR);
        double operand1 = 20.0;
        double operand2 = 10.0;
        for (Character operation : operations) {
            try {
                System.out.println(calculate(operand1, operand2, operation));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static double calculate(double operand1, double operand2, char operation) {
        double result;
        switch (operation) {
            case SUM -> result = operand1 + operand2;
            case SUBTRACT ->  result = operand1 - operand2;
            case MULTIPLY -> result = operand1 * operand2;
            case DIVISION -> result = operand1 / operand2;
            case INTEGER_DIVISION -> result = operand1 % operand2;
            default -> throw new IllegalStateException("Unexpected value: " + operation);
        }
        return result;
    }
}