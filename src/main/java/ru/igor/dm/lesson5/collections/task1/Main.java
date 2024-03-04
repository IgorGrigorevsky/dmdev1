package ru.igor.dm.lesson5.collections.task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Main {

    /*Дан список чатов.
    Каждый чат состоит из двух полей: название и количество пользователей в этом чате.

            Задача:

            - Удалить с помощью итератора из этого списка те чаты, что содержат
            менее 1000 пользователей.

            - Оставшиеся чаты отсортировать с помощью компараторов по убыванию
            по количеству пользователей, а если это количество совпадает, то по
             названию в алфавитном порядке.

            - Также предоставить сортировку чатов по названию по умолчанию.*/
    public static void main(String[] args) {

        List<Chat> chatList = getChats();

        // начальное состояние списка
        System.out.println(chatList);

        Iterator<Chat> iterator = chatList.iterator();
        while (iterator.hasNext()) {
            Chat next = iterator.next();
            if (next.getUsersCount() < 1000) {
                iterator.remove();
            }
        }

        // состояние списка после удаления чатов с количеством участников менее 1000
        System.out.println(chatList);

        // сортировка по имени
        chatList.sort(new ChatComparatorByName());
        System.out.println(chatList);

        // сортировка по убыванию
        chatList.sort(new ChatComparatorByCount());
        System.out.println(chatList);

        // дополнительная сортировка по имени
        chatList.sort(new ChatComparatorByCount().thenComparing(Chat::getChatName));
        System.out.println(chatList);


    }

    private static List<Chat> getChats() {
        Chat chat1 = new Chat("Домовой чат", 70);
        Chat chat2 = new Chat("Рабочий чат", 300);
        Chat chat3 = new Chat("Семейный чат", 15);
        Chat chat4 = new Chat("Школьный чат", 500);
        Chat chat5 = new Chat("чат фанатов настольных игр", 1070);
        Chat chat6 = new Chat("чат фанатов кинематографа", 2000);
        Chat chat7 = new Chat("чат развития региона", 1000);
        Chat chat8 = new Chat("Спортивный чат", 1500);
        Chat chat9 = new Chat("чат любителей домашних животных", 1200);
        Chat chat10 = new Chat("Медицинский чат", 1500);

        List<Chat> chatList = new ArrayList<>() {{
            add(chat1);
            add(chat2);
            add(chat3);
            add(chat4);
            add(chat5);
            add(chat6);
            add(chat7);
            add(chat8);
            add(chat9);
            add(chat10);
        }};
        return chatList;
    }

    public static class ChatComparatorByName implements Comparator<Chat> {
        @Override
        public int compare(Chat o1, Chat o2) {
            return o1.getChatName().compareTo(o2.getChatName());
        }
    }

    public static class ChatComparatorByCount implements Comparator<Chat> {
        @Override
        public int compare(Chat o1, Chat o2) {
            return Integer.compare(o2.getUsersCount(), o1.getUsersCount());
        }
    }

}
