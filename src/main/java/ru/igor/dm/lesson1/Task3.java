package ru.igor.dm.lesson1;

public class Task3 {

    // Даны два прямоугольных треугольника.
    // Каждый из них задается двумя целочисленными переменными a и b - стороны треугольника.
    // Написать код, в котором вычисляется площадь каждого треугольника и затем эти площади сравниваются друг с другом.
    // Для этого понадобится написать 2 функции.

    // Первая: по двум сторонам прямоугольного треугольника возвращает его площадь.
    // Вторая: сравнивает переданные площади двух треугольников и выводит на консоль первый треугольник больше, меньше или равен второму.
    // Учитывать, что площадь может быть вещественным числом.

    public static void main(String[] args) {
        // стороны 1 и 2 треугольников
        int a0 = 5;
        int b0 = 7;
        int a1 = 7;
        int b1 = 9;
        // стороны 3 и 4 треугольников
        int a2 = 8;
        int b2 = 7;
        int a3 = 7;
        int b3 = 3;
        // стороны 5 и 6 треугольников
        int a4 = 5;
        int b4 = 7;
        int a5 = 7;
        int b5 = 5;
        // используем третий метод
        triangleCompare(a0, b0, a1, b1);
        triangleCompare(a2, b2, a3, b3);
        triangleCompare(a4, b4, a5, b5);
    }

    private static void triangleCompare(int a0, int b0, int a1, int b1) {
        double square0 = calculateSquare(a0, b0);
        double square1 = calculateSquare(a1, b1);
        resultCompare(square0, square1);
    }

    public static double calculateSquare(int a, int b) {
        return a * (double) b / 2;
    }

    public static void resultCompare(double square1, double square2) {
        double resultCompare = square1 - square2;
        String answer = resultCompare > 0 ? ">" :
                resultCompare < 0 ? "<" : "=";
        System.out.println("first triangle " + answer + " second triangle");
    }
}
