package ru.igor.dm.lesson1;


import java.util.Arrays;
import java.util.List;

public class Task2 {

    //Даны 3 переменные:
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
    private static final char INTEGER_DIVISION = '%';
    private static final char SUM = '+';
    private static final char SUBTRACT = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVISION = '/';
    private static final char BAD_CHAR = 'K';

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

    private static double calculate(double operand1, double operand2, char operation) {
        double result;
        switch (operation) {
            case SUM -> result = sum(operand1, operand2);
            case SUBTRACT -> result = subtract(operand1, operand2);
            case MULTIPLY -> result = multiply(operand1, operand2);
            case DIVISION -> result = division(operand1, operand2);
            case INTEGER_DIVISION -> result = integer_division(operand1, operand2);
            default -> throw new IllegalStateException("Неизвестный символ: " + operation);
        }
        return result;
    }

    private static double sum(double operand1, double operand2) {
        return operand1 + operand2;
    }

    private static double subtract(double operand1, double operand2) {
        return operand1 - operand2;
    }

    private static double multiply(double operand1, double operand2) {
        return operand1 * operand2;
    }

    private static double division(double operand1, double operand2) {
        if (operand2 != 0) {
            return operand1 / operand2;
        } else {
            throw new ArithmeticException("делить на ноль нельзя");
        }
    }

    private static double integer_division(double operand1, double operand2) {
        if (operand2 != 0) {
            return operand1 % operand2;
        } else {
            throw new ArithmeticException("делить на ноль нельзя");
        }
    }
}