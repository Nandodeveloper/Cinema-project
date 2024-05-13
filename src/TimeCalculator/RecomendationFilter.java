package TimeCalculator;

public class RecomendationFilter {
    public Object Filter(Classification classification) {
        if (classification.getClassification() >= 4){
            System.out.println("It is among the favorites!" + "("+classification.getClassification()+")");
            System.out.println("******************************************");
            System.out.println();
        } else if (classification.getClassification() >= 2){
            System.out.println("Very well rated right now!");
            System.out.println("******************************************");
            System.out.println();
        } else {
            System.out.println("Put it on your list to watch later!");
            System.out.println("******************************************");
            System.out.println();
        }
        return classification.getClassification();
    }

}