package cmdVersion.game.questionFactory;
import cmdVersion.game.questionFactory.animeComparator.popularityRankAnimeComparator;
import cmdVersion.game.questionFactory.animeComparator.ratingRankAnimeComparator;
import cmdVersion.game.questionFactory.animeComparator.startDateAnimeComparator;
import connection.Anime;
import connection.ConnectionError;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class QuestionMaker {
    ArrayList<Anime> animeList = new ArrayList<Anime>();
    ArrayList<Integer> randomNumberList = new ArrayList<Integer>();

    public static final int MAX_RANDOM_NUMBER_SIZE = 1000;
    public static final int MIN_RANDOM_NUMBER_SIZE = 100;
    public static final int MAX_ANIME_SIZE = 50;
    public static final int MIN_ANIME_SIZE = 10;

    public static final String[] difficultyLevels = {"easy", "medium", "hard", "death"};
    public static final double EASY_POSITIONAL_DIFFERENCE = 0.4;
    public static final double MEDIUM_POSITIONAL_DIFFERENCE = 0.2;
    public static final double HARD_POSITIONAL_DIFFERENCE = 0.1;
    public static final double DEATH_POSITIONAL_DIFFERENCE = 0.01;

    public final static String[] questionTypes = {"ratingRank", "popularityRank", "startDate"};

    public static final String animeImgFolderPath = "animeImage\\"; // This is from source root which the "Anihilo" so this represent Anihilo\animeImg\
    public static final String animeImgFileExtension = ".jpg";

    public QuestionMaker() throws ConnectionError {
        this.generateRandomNumberList();
        this.fillAnimeList();
    }

    // Generate Question with random difficulty and type
    public Question makeQuestion() throws ConnectionError {
        Random random = new Random();
        int randomDifficultyIndex = random.nextInt(difficultyLevels.length);
        String randomDifficulty = difficultyLevels[randomDifficultyIndex];
        return makeQuestion(randomDifficulty);

    }
//  Generate Question() with determined difficulty and random type
    public Question makeQuestion(String difficulty) throws ConnectionError {
        Random random = new Random();
        int randomTypeIndex = random.nextInt(questionTypes.length);
        String randomType = questionTypes[randomTypeIndex];
        return makeQuestion(difficulty, randomType);
    }


//  Generate Question() with determined difficulty and type
    public Question makeQuestion(String difficulty, String inType) throws ConnectionError {
        String generatedPrompt = QuestionMaker.getPrompt(inType);
        Comparator<Anime> generatedComparator = QuestionMaker.getComparator(inType);
        double positionalDifference;


        if (difficulty.equalsIgnoreCase(difficultyLevels[0])) { // Easy
            positionalDifference = EASY_POSITIONAL_DIFFERENCE;

        } else if (difficulty.equalsIgnoreCase(difficultyLevels[1])){ // Medium
            positionalDifference = MEDIUM_POSITIONAL_DIFFERENCE;

        } else if(difficulty.equalsIgnoreCase(difficultyLevels[2])){ // Hard
            positionalDifference = HARD_POSITIONAL_DIFFERENCE;

        } else if(difficulty.equalsIgnoreCase(difficultyLevels[3])){ // Death
            positionalDifference = DEATH_POSITIONAL_DIFFERENCE;

        } else {
            System.out.println("Error: QuestionMaker makeQuestion(String,String)");
            positionalDifference = MEDIUM_POSITIONAL_DIFFERENCE;
        }

        return internalMakeQuestion(positionalDifference, generatedComparator, generatedPrompt, difficulty, inType);
    }

    // Algorithm for generating question based on difficulty
    // Difficulty is based on the positionalDifference of the list
    // For example if we have a list of 100 anime listed by rank
    // We pick a random number then by random chance move forward/backward by positionalDifference% of the list
    // The two anime will then be selected for making question object
    public Question internalMakeQuestion(double positionalDifference, Comparator<Anime> comparator, String prompt, String difficulty, String type) throws ConnectionError {

        // Generate anime list and sort them
        this.fillAnimeList();
        this.sortBy(comparator);

        // Generate the positional difference for question
        Random random = new Random();
        int randomIndexA = random.nextInt(animeList.size());
        int indexDifference = (int)Math.ceil(animeList.size() * positionalDifference);
        int randomIndexB = randomIndexA;

        // Bounds checking and calculate randomIndexB
        if((randomIndexB + indexDifference) > animeList.size()-1) {
            randomIndexB -= indexDifference;
        } else {
            randomIndexB += indexDifference;
        }

        // Randomize the anime order
        Anime anime1;
        Anime anime2;
        if(random.nextInt(2)==1){
            anime1 = animeList.get(randomIndexA);
            anime2 = animeList.get(randomIndexB);
        } else {
            anime1 = animeList.get(randomIndexB);
            anime2 = animeList.get(randomIndexA);
        }

        animeList.remove(anime1);
        animeList.remove(anime2);

        // Calculate answer
        int answer;
        int comparatorInt = comparator.compare(anime1,anime2);
        if(comparatorInt > 0){ // Anime1 which is on the left is selected to be the answer
            answer = -1;
        } else if (comparatorInt == 0){
            answer = 0;
        } else {
            answer = 1;
        }

        // Download img of anime if needed
        //anime1.download_medium_img("C:\\Users\\Lenovo\\IdeaProjects\\Anihilo\\cmdVersion\\animeImg\\");
        String anime1ImgPath = this.generateAnimeImagePath(anime1);
        String anime2ImgPath = this.generateAnimeImagePath(anime2);

        return new Question(anime1,anime2,difficulty,prompt,answer, anime1ImgPath, anime2ImgPath, type);
    }
    // END of internalMakeQuestion()


    // Download image of anime if image doesn't exist and return absolute path of the anime img file
    public String generateAnimeImagePath(Anime inAnime){

        String animeImgPath = animeImgFolderPath + inAnime.get_kitsu_id() + animeImgFileExtension;
        File animeImgFile = new File(animeImgPath);

        if(! animeImgFile.exists()){
            inAnime.download_medium_img(animeImgFolderPath);
        }

        return animeImgPath;
    }

    // Instantiate MAX_RANDOM_NUMBER_SIZE numbers for randomNumberList
    public void generateRandomNumberList(){
        for(int i = 1; i < MAX_RANDOM_NUMBER_SIZE; i++){
            this.randomNumberList.add(i);
        }
        Collections.shuffle(this.randomNumberList);
    }

    // Get a random number from the list so when choosing an anime it don't repeat till the player practically did 900 which is near impossible to reach
    // "Pop" from beginning of list
    public int getRandomNumberFromList(){
        return this.randomNumberList.remove(0);
    }

    // Sort the animeList
    public void sortBy(Comparator<Anime> inComparator){
        animeList.sort(inComparator);
    }


    public void fillAnimeList() throws ConnectionError {
        int amountOfAnimeToAdd = MAX_ANIME_SIZE - this.animeList.size();

        for(int i = 0; i < amountOfAnimeToAdd; i++){
            int randNumFromList = getRandomNumberFromList();
            this.animeList.add(new Anime(randNumFromList, false));
        }
    }

    public static Comparator<Anime> getComparator(String inType){
        //Comparator<Anime> ratingRankComp = (a1,a2) -> a2.get_rating_rank()-a1.get_rating_rank(); // Positive when a1 has better rank than a2
        //Comparator<Anime> popularityRankComp = (a1,a2) -> a2.get_rating_rank()-a1.get_rating_rank(); // Positive when a1 has better popularity rank than a2


        if(inType.equalsIgnoreCase(questionTypes[0])){
            return new ratingRankAnimeComparator();
        } else if (inType.equalsIgnoreCase(questionTypes[1])){
            return new popularityRankAnimeComparator();
        } else if (inType.equalsIgnoreCase(questionTypes[2])){
            return new startDateAnimeComparator();
        } else {
            System.out.println("Error: QuestionMaker getComparator()");
            System.out.println("Returning ratingRankComp comparator as default");
            return new ratingRankAnimeComparator();
        }
    }

    public static String getPrompt(String inType){

        if(inType.equalsIgnoreCase(questionTypes[0])){
            return "Select the anime with better rank in term of rating";
        } else if (inType.equalsIgnoreCase(questionTypes[1])){
            return "Select the anime with better rank in term of popularity";
        } else if (inType.equalsIgnoreCase(questionTypes[2])){
            return "Select the anime which came out first";
        }else {
            return "Default prompt";
        }

    }




}
