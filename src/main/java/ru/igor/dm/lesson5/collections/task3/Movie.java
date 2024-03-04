package ru.igor.dm.lesson5.collections.task3;

import java.util.Arrays;

public class Movie {

//    - Фильм с 5-ю полями: Уникальный Целочисленный идентификатор (id), Год издания, Месяц издания, Жанр и Рейтинг;

    int id;
    int age;
    String month;
    String movieGenre;
    double rating;

    public Movie(int id, int age, String month, String movieGenre, double rating) {
        this.id = id;
        this.age = age;
        this.month = month;
        this.movieGenre = movieGenre;
        this.rating = rating;
    }

    public int getAge() {
        return age;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Кино c номером id: " + id +
                ", год: " + age +
                ", месяц: " + month +
                ", жанр: " + movieGenre +
                ", рейтинг: " + rating;
    }
}
