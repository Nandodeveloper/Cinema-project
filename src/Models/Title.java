package Models;

import javax.swing.border.TitledBorder;
import java.util.ArrayList;

public class Title implements Comparable<Title> {
    public static ArrayList<Title> list = new ArrayList<>();
    private String Name;
    private int Year;
    private double SumOfRating;
    private int TotalRatings;
    private int Duration;

    public void setDuration(int duration) {
        Duration = duration;
    }

    public Title (String name, int year){
        Name = name;
        Year = year;
    }
    public String getName() {
        return Name;
    }

    public int getYear() {
        return Year;
    }

    public int getDuration() {
        return Duration;
    }

    public int getTotalRatings() {
        return TotalRatings;
    }

    public double getSumOfRating() {
        return SumOfRating;
    }

    public void setTotalRatings(int totalRatings) {
        TotalRatings = totalRatings;
    }

    public void setSumOfRating(double sumOfRating) {
        SumOfRating = sumOfRating;
    }
    public void AddFilm(Film film) {
        list.add(film);
    }
    public void AddSerie(Serie serie) {
        list.add(serie);
    }

    public void DisplayDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Release year: " + getYear());
        System.out.println("Rating: " + Media() +" ("+getTotalRatings()+")");
    }
    public void Rate(int nota) {
        SumOfRating += nota;
        TotalRatings++;
    }
    public double Media() {
        return SumOfRating / TotalRatings;
    }

    @Override
    public int compareTo(Title o) {
        return Double.valueOf(this.getYear()).compareTo(Double.valueOf(o.getYear()));
    }
}