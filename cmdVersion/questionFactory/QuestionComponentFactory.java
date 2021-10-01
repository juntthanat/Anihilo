package cmdVersion.questionFactory;
import connection.Anime;
import java.util.Comparator;

// Provides component for constructing a question
// Provides constants for referencing the functions

public class QuestionComponentFactory {
    public final static String[] questionTypes = {"ratingRank"};

    public static Comparator<Anime> getComparator(String inType){
        Comparator<Anime> ratingRankComp = (a1,a2) -> a2.get_rating_rank()-a1.get_rating_rank(); // Positive when a1 has better rank than a2

        if(inType.equalsIgnoreCase(questionTypes[0])){
            return ratingRankComp;
        } else {
            System.out.println("Error: QuestionMaker getComparator()");
            System.out.println("Returning ratingRankComp comparator as default");
            return ratingRankComp;
        }
    }

    public static String getPrompt(String inType){

        if(inType.equalsIgnoreCase(questionTypes[0])){
            return "Select the anime with better rank";
        } else {
            return "Default prompt";
        }

    }

}
