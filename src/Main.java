import Models.Episode;
import Models.Film;
import Models.Title;
import TimeCalculator.Calculator;
import Models.Serie;
import TimeCalculator.RecomendationFilter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to ScreenMatch!");
        System.out.println();

        Calculator calculator = new Calculator();
        RecomendationFilter filter = new RecomendationFilter();

        Film film1 = new Film("Steve Jobs", 2022, "Danny Boyle");
        film1.Rate(10);
        film1.Rate(9);
        film1.Rate(8);
        film1.AddFilm(film1);
        calculator.includes(film1);
        film1.setDuration(120);
        film1.DisplayDetails();
        filter.Filter(film1);

        Film film2 = new Film("Avatar", 2009, "James Cameron");
        film2.Rate(7);
        film2.Rate(8);
        film2.Rate(6);
        film2.setDuration(150);
        film2.AddFilm(film2);
        calculator.includes(film2);
        film2.DisplayDetails();
        filter.Filter(film2);


        Serie lost = new Serie("Lost", 2000);
        lost.setSeasons(10);
        lost.setEpForSeason(10);
        lost.setMinutesForEp(50);
        lost.Rate(10);
        lost.Rate(8);
        lost.Rate(6);
        lost.AddSerie(lost);
        calculator.includes(lost);
        lost.DisplayDetails();
        filter.Filter(lost);


        Title.list.sort(Comparator.comparing(Title::getYear));
        for (Title item: Title.list) {
            System.out.println(item.toString());
            if (item instanceof Film film) {
                System.out.println("Classification: " + film.Media());
                System.out.println();
            } else if (item instanceof Serie series) {
                System.out.println("Classification: " + series.Media());
                System.out.println();
            }
        }
        Title.list.sort(Comparator.comparing(Title::getYear));
        System.out.println("Your to-watch list:");
        System.out.println(Title.list);


        Episode ep = new Episode();
        ep.setNumber(8);
        ep.setSerie(lost);
        ep.setEpName("Confidence Man");
    }
}