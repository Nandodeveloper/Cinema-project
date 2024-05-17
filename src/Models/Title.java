package Models;
import Exceptions.ConversionErrorException;

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
    public Title(OMDBTitle myOMDBtitle) {
        this.Name = myOMDBtitle.title();
        this.Year = Integer.valueOf(myOMDBtitle.year().substring(0,4));
        if (myOMDBtitle.year().length() > 4 ){
            throw new ConversionErrorException("It was not possible to convert the year because have more than 4 characters");
        }
        if(myOMDBtitle.runtime().length() == 6) {
            this.Duration = Integer.valueOf(myOMDBtitle.runtime().substring(0,2));
        } else if (myOMDBtitle.runtime().length() == 7) {
            this.Duration = Integer.valueOf(myOMDBtitle.runtime().substring(0,3));
        }
    }
    public Title (String name, int year){
        this.Name = name;
        this.Year = year;
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

    @Override
    public String toString() {
        return "(Title: " + Name + ", Year: " + Year + ", Duration: " + Duration + " min)";
    }
}