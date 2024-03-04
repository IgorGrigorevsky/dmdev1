package ru.igor.dm.lesson5.collections.task2;

import java.util.*;


public class Main {

    /*Дан список чатов с предыдущего задания, только вместо поля “количество пользователей”
     будет список объектов типа Пользователь, который имеет 3 поля: id (целочисленный идентификатор),
     имя и возраст.

    Задача:
            - Преобразовать список чатов в один список пользователей всех чатов,
            возраст которых больше 18 лет

            - С помощью итератора посчитать средний возраст всех оставшихся пользователей.*/

    public static void main(String[] args) {

        User user1 = new User(1, "Петя", 15);
        User user2 = new User(2, "Света", 18);
        User user3 = new User(3, "Коля", 19);
        User user4 = new User(4, "Аня", 20);
        User user5 = new User(5, "Никита", 21);
        User user6 = new User(6, "Дарья", 18);
        User user7 = new User(7, "Ксюша", 14);
        User user8 = new User(8, "Афанасий", 35);
        User user9 = new User(9, "Сережа", 8);
        User user10 = new User(10, "Катя", 25);

        List<User> userList1 = new ArrayList<>() {{
            add(user3);
            add(user5);
            add(user7);
            add(user8);
        }};
        List<User> userList2 = new ArrayList<>() {{
            add(user1);
            add(user2);
            add(user3);
            add(user4);
            add(user5);

        }};
        List<User> userList3 = new ArrayList<>() {{
            add(user6);
            add(user7);
            add(user8);
            add(user9);
            add(user10);
        }};
        List<User> userList4 = new ArrayList<>() {{
            add(user3);
            add(user4);
            add(user7);
            add(user9);
            add(user10);
        }};
        List<User> userList5 = new ArrayList<>() {{
            add(user1);
            add(user4);
            add(user5);
            add(user6);
            add(user8);
        }};

        Group group1 = new Group("Домовой чат", userList1);
        Group group2 = new Group("Рабочий чат", userList2);
        Group group3 = new Group("Семейный чат", userList3);
        Group group4 = new Group("Школьный чат", userList4);
        Group group5 = new Group("чат фанатов настольных игр", userList5);

        List<Group> groupList = new ArrayList<>() {{
            add(group1);
            add(group2);
            add(group3);
            add(group4);
            add(group5);
        }};

        Iterator<Group> iterator = groupList.iterator();
        Set<User> commonUsersList = new HashSet<>();
        while (iterator.hasNext()) {
            commonUsersList.addAll(iterator.next().getList());
        }
        List<User> immutableUsersList = List.copyOf(commonUsersList);
        List<User> finitoUsersList = new ArrayList<>(immutableUsersList);

        System.out.println("объединенный список пользователей");
        for (User user : finitoUsersList) {
            System.out.println(user);
        }

        Iterator<User> iterator1 = finitoUsersList.iterator();
        while (iterator1.hasNext()) {
            int userAge = iterator1.next().getAge();
            if (userAge <= 18) {
                iterator1.remove();
            }
        }

        System.out.println("\nсписок c участниками старше 18 лет");
        for (User user : finitoUsersList) {
            System.out.println(user);
        }

        Iterator<User> iterator2 = finitoUsersList.iterator();
        int commonAge = 0;
        int count = 0;
        while (iterator2.hasNext()) {
            int nextAge = iterator2.next().getAge();
            commonAge += nextAge;
            count++;
        }
        System.out.println("\nСредний возраст: " + (double) commonAge / count);

    }
}