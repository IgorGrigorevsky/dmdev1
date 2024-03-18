package ru.igor.dm.lesson8.task1;

import java.util.Random;

public class Crystal {

    private String colour;
    private final Random random = new Random();

    public Crystal() {
        this.colour = getRandomColour();

    }

    // получаем случайный цвет - красный или белый для кристалла
    private String getRandomColour () {
        boolean randomColour = random.nextBoolean();
        if (!randomColour) {
            colour = "red";
        } else {
            colour = "white";
        }
        return colour;
    }

    public String getColour() {
        return colour;
    }
}
