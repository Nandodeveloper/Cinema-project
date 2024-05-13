package Models;
import Models.Episode;
import TimeCalculator.Classification;

import java.util.ArrayList;

public class Serie extends Title implements Classification {

    public Serie(String name, int year) {
        super(name, year);
    }
    private int Seasons;
    public int getSeasons() {
        return Seasons;
    }
    public void setSeasons(int seasons) {
        Seasons = seasons;
    }
    private int EpForSeason;
    public int getEpForSeason() {
        return EpForSeason;
    }
    public void setEpForSeason(int epForSeason) {
        EpForSeason = epForSeason;
    }
    private boolean Active;
    public boolean isActive() {
        return Active;
    }
    public void setActive(boolean active) {
        Active = active;
    }
    private int MinutesForEp;
    public int getMinutesForEp() {
        return MinutesForEp;
    }
    public void setMinutesForEp(int minutesForEp) {
        MinutesForEp = minutesForEp;
    }
    @Override
    public int getDuration() {
        return Seasons * EpForSeason * MinutesForEp;
    }
    @Override
    public void DisplayDetails() {
        System.out.println("Series: " + getName());
        System.out.println("Release year: " + getYear());
        System.out.println("Seasons: " + getSeasons());
        System.out.println("Episode for each season: " + getEpForSeason());
        System.out.println("Time for marathon this series: " + getDuration() + " min");
        System.out.println("Rating: " + (float) Media());
        System.out.println("Total Ratings: " + getTotalRatings());
        System.out.println();
    }

    @Override
    public int getClassification() {
        return (int) Media() / 2;
    }
    @Override
    public String toString() {
        return "Series: " + this.getName() + " (" + this.getYear() + ")";
    }
}