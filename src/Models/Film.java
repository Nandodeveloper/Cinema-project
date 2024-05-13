package Models;

import TimeCalculator.Classification;
import java.util.ArrayList;

public class Film extends Title implements Classification {
    private String Diretor;

    public Film(String name, int year, String diretor) {
        super(name, year);
        Diretor = diretor;
    }

    private String getDiretor() {
        return Diretor;
    }

    public void setDiretor(String diretor) {
        Diretor = diretor;
    }
    @Override
    public int getClassification() {
        return (int) Media() / 2;
    }
    @Override
    public void DisplayDetails() {
        System.out.println("Film: " + getName());
        System.out.println("Release year: " + getYear());
        System.out.println("Director: " + getDiretor());
        System.out.println("Rating: " + (float) Media());
        System.out.println("Total Ratings: " + getTotalRatings());
        System.out.println("Duration: " + getDuration() + " min");
        System.out.println();
    }
    @Override
    public String toString() {
        return "Film: " + this.getName() + " (" + this.getYear() + ")";
    }
}