package Models;

import TimeCalculator.Classification;

public class Episode implements Classification {
    private int Number;
    private String EpName;
    private Serie serie;
    private int TotalViews;

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public String getEpName() {
        return EpName;
    }

    public void setEpName(String epName) {
        EpName = epName;
    }

    @Override
    public int getClassification() {
        if (TotalViews > 100) {
            return 4;
        } else {
            return 2;
        }
    }
}