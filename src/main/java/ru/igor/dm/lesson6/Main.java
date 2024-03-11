package ru.igor.dm.lesson6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

     /*Дан список студентов с полями:
- Имя
- Фамилия
- Номер курса в университете
- Список оценок за учебу

Преобразовать этот список студентов в ассоциативный массив, где ключом является номер курса, а значением:

Средняя оценка студентов этого курса, количество оценок у которых больше 3-х

Список студентов данного курса, но только с полями Имя и Фамилия.
Список должен быть отсортированы по этим двум полям

Объект с двумя полями:
- Отсортированный список студентов с пункта 2
- Средняя оценка этих студентов

Подумать, как ассоциативный массив можно было представить в коде в виде отсортированного - TreeMap*/

    public static void main(String[] args) {


        List<Student> studentList = List.of(
                new Student("Афанасьев", "Афанасий", null, 5, List.of(5, 5, 5, 5)),
                new Student("Нинова", "Нина", "Ниновна", 2, List.of(5, 5, 5, 5)),
                new Student("Петров", "Петр", "Петровна", 3, List.of(4, 5, 3, 2)),
                new Student("Алексеев", "Алексей", "Алексеевич", 2, List.of(3, 3, 3, 3)),
                new Student("Олегов", "Олег", "Олегович", 4, List.of(3, 4)),
                new Student("Никитьев", "Никитий", null, null, null),
                new Student("Ксюшикова", "Ксюша", "Ксюшовна", 4, List.of(4, 4)),
                new Student("Оликова", "Оля", "Оликовна", 1, List.of(4, 5, 5, 4))
        );

        System.out.println("Средняя оценка студентов этого курса, количество оценок у которых больше 3-х");
        Map<Integer, Double> moreThanThreeGrade = studentList.stream()
                .filter(student -> student.getCourseNumber() != null)
                .filter(student -> student.getGrade() != null)
                .filter(student -> student.getGrade().size() > 3)
                .collect(Collectors.groupingBy(
                        Student::getCourseNumber,
                        Collectors.averagingDouble(student -> student.getGrade().stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(0.0))));
        System.out.println(moreThanThreeGrade);

        System.out.println("\nЗначением является список студентов данного курса, но только с полями Имя и Фамилия. " +
                "Список должен быть отсортированы по этим двум полям");

        Map<Integer, List<Student>> sortedStudentsListsByCourse =
                studentList.stream()
                        .filter(student -> student.getName() != null)
                        .filter(student -> student.getLastName() != null)
                        .filter(student -> student.getCourseNumber() != null)
                        .collect(Collectors.groupingBy(
                                Student::getCourseNumber,// ключом является номер курса
                                Collectors.collectingAndThen(
                                        Collectors.toCollection(ArrayList::new),
                                        list -> {
                                            list.sort(Comparator
                                                    .comparing(Student::getLastName)
                                                    .thenComparing(Student::getName));
                                            return list;
                                        }
                                )
                        ));

        sortedStudentsListsByCourse.entrySet()
                .forEach(System.out::println);

        System.out.println("\nЗначением является объект с двумя полями: отсортированный список студентов с пункта 2 " +
                "и средняя оценка этих студентов");

        Map<Integer, Pair> sortedStudentsListsWithAvgGradesByCourse =
                sortedStudentsListsByCourse.entrySet().stream()
                        .collect(Collectors.toMap(
                                        entry -> entry.getKey(),
                                        entry -> {
                                            List<Student> sortedStudentList = entry.getValue();
                                            Double averageGrade = sortedStudentList.stream()
                                                    .map(Student::getGrade)
                                                    .flatMap(Collection::stream)
                                                    .collect(Collectors.averagingDouble(Integer::doubleValue));
                                            return new Pair(sortedStudentList, averageGrade);
                                        }
                                )
                        );

        sortedStudentsListsWithAvgGradesByCourse.entrySet()
                .forEach(System.out::println);
    }
}


