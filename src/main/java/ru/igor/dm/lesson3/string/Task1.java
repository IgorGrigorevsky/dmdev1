package ru.igor.dm.lesson3.string;

public class Task1 {

   /* Дана строка.
    Удалить из нее все повторяющиеся символы без учета регистра, если они идут друг за другом. Также удалить пробелы.
    Результат привести к верхнему регистру.

            Например:
            "abc Cpddd Dio OsfWw" -> "ABCPDIOSFW" */

    public static void main(String[] args) {

        String variable = "abc Cpddd Dio OsfWw";
        System.out.println(changeString(variable));

    }

    private static String changeString(String variable) {
        if (variable == null || variable.isBlank()) {
            return variable;
        }

        String str = variable.replaceAll(" ", "")
                .toUpperCase();

        if (str.length() == 1) {
            return str;
        }

        StringBuilder builder = new StringBuilder();
        builder.append(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) != str.charAt(i)) {
                builder.append(str.charAt(i));
            }
        }
        return builder.toString();
    }
}
