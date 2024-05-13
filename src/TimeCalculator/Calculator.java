package TimeCalculator;
import Models.Title;

public class Calculator {
    private int fullTime = 0;

    public int getFullTime() {
        return fullTime;
    }
    public void includes(Title title){
        this.fullTime += title.getDuration();
    }
}