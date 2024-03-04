package ru.igor.dm.lesson6;

import java.util.List;

public class Pair {

    /* - Отсортированный список студентов с пункта 2
- Средняя оценка этих студентов
*/
    private final List<Student> list;
    private final double averageGrade;

    public Pair(List<Student> list, double averageGrade) {
        this.list = list;
        this.averageGrade = averageGrade;
    }

    public List<Student> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "студенты: " + list +
                ", средняя оценка: " + averageGrade;
    }
}
