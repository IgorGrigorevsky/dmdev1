package ru.igor.dm.lesson5.collections.task3;

import java.util.*;

public class Cinema {

   /* - Кинотеатр, где есть всего лишь одно единственное поле: отсортированный ассоциативный
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

    private LinkedHashMap<Integer, HashSet<Movie>> map;

    public Cinema(LinkedHashMap<Integer, Set<Movie>> map) {
        this.map = new LinkedHashMap<>();
    }

    public void addMovie(Movie movie) {
        int year = movie.getAge();
        HashSet<Movie> set = new HashSet<>();
        if (map.containsKey(year)) {
            map.get(movie.getAge()).add(movie);
        } else {
            set.add(movie);
            map.put(year, set);
        }
    }

    // получить все фильмы по переданному году
    public void getMoviesByYear(int year) {
        if (map.containsKey(year)) {
            System.out.println("фильмы, вышедшие в " + year + " году: " + map.get(year) + "\n");
        } else {
            System.out.println("фильмов, вышедших в данном году, нет\n");
        }
    }

    // получить все фильмы по переданному году и месяцу
    public void getMoviesByYearAndMonth(int year, String month) {
        if (map.containsKey(year)) {
            HashSet<Movie> set = map.get(year);
            for (Movie movie : set) {
                if (Objects.equals(movie.month, month)) {
                    System.out.println("фильмы, вышедшие в " + year + " году и в месяце: " + month + " " + movie + "\n");
                }
            }
        } else {
            System.out.println("фильмов, вышедших в данном месяце и году, нет\n");
        }
    }

    // получить все фильмы по переданному жанру
    public void getMoviesByGenre(String genre) {
        for (Integer integer : map.keySet()) {
            for (Movie movie : map.get(integer)) {
                if (Objects.equals(movie.getMovieGenre(), genre))
                    System.out.println("фильмы с жанром " + genre + " это: " + movie + "\n");
            }
        }
    }

    // получать ТОП-10 фильмов отсортированные по Рейтингу в порядке убывания
    public void getMoviesByRatingOf10() {
        TreeSet<Movie> set = getSortedMoviesSet();
        int count = 10;
        iterationByRating(set, count);
    }

    private TreeSet<Movie> getSortedMoviesSet() {
        TreeSet<Movie> set = new TreeSet<>(new ComparatorByCount());
        for (Integer integer : map.keySet()) {
            set.addAll(map.get(integer));
        }
        return set;
    }

    private static void iterationByRating(TreeSet<Movie> set, int count) {
        Iterator<Movie> iterator = set.iterator();
        System.out.println("ТОП-10 фильмов по рейтингу: ");
        while (iterator.hasNext() && count > 0) {
            Movie entry = iterator.next();
            System.out.println(entry);
            count--;
        }
    }

    public static class ComparatorByCount implements Comparator<Movie> {
        @Override
        public int compare(Movie o1, Movie o2) {

            return Double.compare(o2.getRating(), o1.getRating());
        }
    }

    @Override
    public String toString() {
        return "Фильмы в кинотеатре " + map;
    }
}
