package ru.igor.dm.lesson5.collections.task2;

import java.util.List;

public class Group {

   /* вместо поля “количество пользователей”
    будет список объектов типа Пользователь, который имеет 3 поля: id (целочисленный идентификатор),
    имя и возраст.*/


    private final String groupName;
    private final List<User> list;

    public Group(String groupName, List<User> list) {
        this.groupName = groupName;
        this.list = list;
    }

    public List<User> getList() {
        return list;
    }

    @Override
    public String toString() {
        return groupName +
                " , list=" + list;
    }
}

