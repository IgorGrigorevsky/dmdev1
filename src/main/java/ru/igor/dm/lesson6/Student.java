package ru.igor.dm.lesson6;

import java.util.List;

public class Student {

    /*Дан список студентов с полями:
- Имя
- Фамилия
- Номер курса в университете
- Список оценок за учебу
     */

    private final String lastName;
    private final String name;
    private final String patronymic;
    private final Integer courseNumber;
    private final List<Integer> grade;

    public Student(String lastName, String name, String patronymic, Integer courseNumber, List<Integer> grade) {
        this.lastName = lastName;
        this.name = name;
        this.patronymic = patronymic;
        this.courseNumber = courseNumber;
        this.grade = grade;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public Integer getCourseNumber() {
        return courseNumber;
    }

    public List<Integer> getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return lastName + " " + name + (patronymic != null ? " " + patronymic : "") +
                ", курс: " + courseNumber +
                ", оценка " + grade;
    }
}
