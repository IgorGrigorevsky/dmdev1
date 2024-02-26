package ru.igor.dm.lesson5.collections.task2;

public class User {

    /*который имеет 3 поля: id (целочисленный идентификатор),
    имя и возраст.*/

    private final int id;
    private final String name;
    private final int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Пользователь: " +
                "id: " + id +
                " , имя пользователя: " + name +
                " , возраст пользователя: " + age;
    }
}
