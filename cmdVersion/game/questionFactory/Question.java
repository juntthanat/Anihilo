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

    /**
     * @param leftAnime
     * @param rightAnime
     * @param difficulty
     * @param prompt
     * @param answer
     * @param leftAnimeImgPath
     * @param rightAnimeImgPath
     * @param type
     */


    // Constructors for making the question
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

    // user choose left anime = -1, user choose right anime = 1;
    public boolean checkAnswer(int userAnswer){
        // this.answer == 0 means both side are correct "a freebie"
        return (userAnswer == this.answer) || (this.answer == 0);
    }


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
