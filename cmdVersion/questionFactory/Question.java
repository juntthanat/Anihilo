package cmdVersion.questionFactory;
import connection.Anime;

public class Question {
    Anime leftAnime;
    Anime rightAnime;

    String leftAnimeImgPath;
    String rightAnimeImgPath;

    String difficulty = "Question object default difficulty";
    String prompt = "Question object default prompt";
    int answer = -1; // -1 is default, 0 is left, 1 is right

    /**
     * @param leftAnime
     * @param rightAnime
     * @param difficulty
     * @param prompt
     * @param answer
     * @param leftAnimeImgPath
     * @param rightAnimeImgPath
     */
    // Constructors for making the question
    public Question(Anime leftAnime, Anime rightAnime, String difficulty, String prompt, int answer, String leftAnimeImgPath, String rightAnimeImgPath) {
        this.leftAnime = leftAnime;
        this.rightAnime = rightAnime;
        this.difficulty = difficulty;
        this.prompt = prompt;
        this.answer = answer; // -1 means left, 0 means both answer are correct, 1 means right
        this.leftAnimeImgPath = leftAnimeImgPath;
        this.rightAnimeImgPath = rightAnimeImgPath;
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
