package ru.igor.dm.lesson5.collections.task1;

public class Chat {

    private final String chatName;
    private final int usersCount;

    public Chat(String chatName, int usersCount) {
        this.chatName = chatName;
        this.usersCount = usersCount;
    }

    public String getChatName() {
        return chatName;
    }

    public int getUsersCount() {
        return usersCount;
    }

    @Override
    public String toString() {
        return chatName +
                ", количество участников: " + usersCount;
    }
}
