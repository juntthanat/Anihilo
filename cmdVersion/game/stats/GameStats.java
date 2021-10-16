package cmdVersion.game.stats;

import cmdVersion.game.questionFactory.Question;

public class GameStats {

    Integer guessAmount = 0;
    Integer guessCorrect = 0;
    Integer guessCorrectStreak = 0;
    double guessAccuracy = 0;

    Question question = null;
    boolean latestQuestionAnsweredCorrect;

    // Getter START
    public Integer getGuessAmount() {
        return guessAmount;
    }

    public Integer getGuessCorrect() {
        return guessCorrect;
    }

    public Integer getGuessCorrectStreak() {
        return guessCorrectStreak;
    }

    public double getGuessAccuracy() {
        return guessAccuracy;
    }

    public Question getQuestion() {
        return question;
    }

    public boolean isLatestQuestionAnsweredCorrect() {
        return latestQuestionAnsweredCorrect;
    }
    // Getter END

    // Setter START
    public void setQuestion(Question question) {
        this.question = question;
    }

    // Setter END

    public void answeredCorrect(){
        this.latestQuestionAnsweredCorrect = true;
        this.guessAmount++;
        this.guessCorrect++;
        this.guessCorrectStreak++;
        this.guessAccuracy = ((double)this.guessCorrect)/this.guessAmount;
    }

    public void answeredWrong(){
        this.latestQuestionAnsweredCorrect = false;
        this.guessAmount++;
        this.guessCorrectStreak = 0;
        this.guessAccuracy = ((double)this.guessCorrect)/this.guessAmount;
    }

    @Override
    public String toString() {
        return "GameStats\n" +
                "guessAmount: " + guessAmount + "\n" +
                "guessCorrect: " + guessCorrect + "\n" +
                "guessCorrectStreak: " + guessCorrectStreak + "\n" +
                "guessAccuracy: " + guessAccuracy + "\n" +
                "question: " + "(choose to not print)" + "\n" +
                "latestQuestionAnsweredCorrect: " + latestQuestionAnsweredCorrect + "\n"
                ;
    }
}
