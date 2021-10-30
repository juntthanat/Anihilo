package cmdVersion.game.questionFactory;
import connection.Anime;

public class Question {
    Anime leftAnime;
    Anime rightAnime;

    String leftAnimeImgPath;
    String rightAnimeImgPath;

    String difficulty = "Question object default difficulty";
    String prompt = "Question object default prompt";
    String type = "Question object default type";
    int answer = 0; // -1 is left, 0 is both correct, 1 is right

    public static final Integer ANSWER_LEFT = -1;
    public static final Integer ANSWER_RIGHT = 1;
    public static final Integer ANSWER_BOTH_CORRECT = 0;

    /**
    * The Class Constructor
    *
    * @param leftAnime          One of the anime to be compared
    * @param rightAnime         Another anime to be compared
    * @param difficulty         The difficulty of the question
    * @param prompt             The prompt
    * @param answer             The answer to the question
    * @param leftAnimeImgPath   The Image path of the first anime
    * @param rightAnimeImgPath  The Image path of the second anime
    * @param type               The type of the question
    */
    public Question(Anime leftAnime, Anime rightAnime, String difficulty, String prompt, int answer, String leftAnimeImgPath, String rightAnimeImgPath, String type) {
        this.leftAnime = leftAnime;
        this.rightAnime = rightAnime;
        this.difficulty = difficulty;
        this.prompt = prompt;
        this.answer = answer; // -1 means left, 0 means both answer are correct, 1 means right
        this.leftAnimeImgPath = leftAnimeImgPath;
        this.rightAnimeImgPath = rightAnimeImgPath;
        this.type = type;
    }

    public Anime getLeftAnime() {
        return leftAnime;
    }

    public void setLeftAnime(Anime leftAnime) {
        this.leftAnime = leftAnime;
    }

    public Anime getRightAnime() {
        return rightAnime;
    }

    public void setRightAnime(Anime rightAnime) {
        this.rightAnime = rightAnime;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getLeftAnimeImgPath() {
        return leftAnimeImgPath;
    }

    public void setLeftAnimeImgPath(String leftAnimeImgPath) {
        this.leftAnimeImgPath = leftAnimeImgPath;
    }

    public String getRightAnimeImgPath() {
        return rightAnimeImgPath;
    }

    public void setRightAnimeImgPath(String rightAnimeImgPath) {
        this.rightAnimeImgPath = rightAnimeImgPath;
    }

    public String getLeftAnimeQuestionRelevantData(){
        return getAnimeQuestionRelevantData(leftAnime);
    }

    public String getRightAnimeQuestionRelevantData(){
        return getAnimeQuestionRelevantData(rightAnime);
    }

    public String getType() {
        return type;
    }

    /**
    * Gets the relevant data of the Anime
    *
    * @param anime The Anime object to get the data from
    * @return String The output string
    */
    public String getAnimeQuestionRelevantData(Anime anime){
        String output;

        if(type.equalsIgnoreCase(QuestionMaker.questionTypes[0])){
            output = String.valueOf(anime.get_rating_rank());
        } else if (type.equalsIgnoreCase(QuestionMaker.questionTypes[1])) {
            output = String.valueOf(anime.get_popularity_rank());
        } else if (type.equalsIgnoreCase(QuestionMaker.questionTypes[2])){
            output = String.valueOf(anime.get_start_date());
        } else {
            System.out.println("Error: At method getLeftAnimeQuestionReleventData() in Question()");
            System.out.println("Returning: The name of anime");
            output = String.valueOf(anime.get_name());
        }
        output = type + " is " + output;
        return output;
    }

    /**
    * Checks the answer of the user
    *
    * @param userAnswer The answer of the user (-1 left, 1 right)
    * @return boolean Whether the user answered correctly
    */
    public boolean checkAnswer(int userAnswer){
        // this.answer == 0 means both side are correct "a freebie"
        return (userAnswer == this.answer) || (this.answer == Question.ANSWER_BOTH_CORRECT);
    }

    /**
    * Returns the information string
    *
    * @return String The information string
    */
    @Override
    public String toString() {
        return "Question{" +
                "leftAnime=" + leftAnime.toString() +
                ", rightAnime=" + rightAnime.toString() +
                ", difficulty='" + difficulty + '\'' +
                ", prompt='" + prompt + '\'' +
                ", answer=" + answer +
                '}';
    }


}
