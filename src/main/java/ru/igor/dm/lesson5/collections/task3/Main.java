package ru.igor.dm.lesson5.collections.task3;

import java.util.LinkedHashMap;

public class Main {

    /* Даны 2 класса:

             - Фильм с 5-ю полями: Уникальный Целочисленный идентификатор (id), Год издания,
              Месяц издания, Жанр и Рейтинг;

             - Кинотеатр, где есть всего лишь одно единственное поле: отсортированный ассоциативный
             массив, где ключом является год издания, а значением - все фильмы, вышедшие
             в этом году.

     Добавить функционал в кинотеатр таким образом, чтобы можно было:
             - добавлять в него новый фильм
             - получить все фильмы по переданному году
             - получить все фильмы по переданному году и месяцу
             - получить все фильмы по переданному жанру
             - получать ТОП-10 фильмов отсортированные по Рейтингу в порядке убывания

     Учесть следующее:
             - в кинотеатре фильмы должны храниться в порядке их добавления в него
              (т.е. предусмотреть порядок значения ассоциативного массива)
             - не должен добавляться фильм, если такой уже есть в кинотеатре.
             Продемонстрировать работу кинотеатра в отдельном классе.*/

    public static void main(String[] args) {

        Cinema cinema = new Cinema(new LinkedHashMap<>());

        Movie rocky = new Movie(1, 1976, "ноябрь", "спорт", 8.0);
        Movie terminator2 = new Movie(2, 1991, "июль", "боевик", 8.4);
        Movie aquaman2 = new Movie(3, 2023, "декабрь", "фэнтези", 6.1);
        Movie minions = new Movie(4, 2015, "июнь", "мультфильм", 6.2);
        Movie homeALone = new Movie(5, 1990, "ноябрь", "комедия", 8.3);
        Movie meetTheFockers = new Movie(6, 2004, "декабрь", "комедия", 7.1);
        Movie WeAreTheMillers = new Movie(7, 2013, "август", "комедия", 7.2);
        Movie sawX = new Movie(8, 2023, "сентябрь", "триллер", 6.6);
        Movie it = new Movie(9, 2017, "сентябрь", "ужасы", 7.3);
        Movie it2 = new Movie(10, 2019, "август", "ужасы", 6.5);
        Movie avatar = new Movie(11, 2009, "декабрь", "приключения", 8.0);
        Movie hotShots = new Movie(12, 1991, "июль", "комедия", 7.6);

        // добавляем фильмы
        cinema.addMovie(rocky);
        cinema.addMovie(terminator2);
        cinema.addMovie(aquaman2);
        cinema.addMovie(minions);
        cinema.addMovie(homeALone);
        cinema.addMovie(meetTheFockers);
        cinema.addMovie(WeAreTheMillers);
        cinema.addMovie(sawX);
        cinema.addMovie(it);
        cinema.addMovie(it2);
        cinema.addMovie(rocky);
        cinema.addMovie(avatar);
        cinema.addMovie(hotShots);


        cinema.getMoviesByYear(1991);
        cinema.getMoviesByYearAndMonth(1976, "ноябрь");
        cinema.getMoviesByGenre("ужасы");
        cinema.getMoviesByRatingOf10();
    }
}
