package cmdVersion.game.questionControl;

import cmdVersion.game.stats.GameStats;
import cmdVersion.game.questionFactory.QuestionMaker;
import java.util.Random;

public class StageQuestionControl extends QuestionControl {

    Integer correctGuess = 0;

    @Override
    public String getQuestionDifficulty() {
        String output = "";

        if(correctGuess <= 5){
            output = QuestionMaker.difficultyLevels[0];
        } else if (correctGuess <= 10){
            output = QuestionMaker.difficultyLevels[1];
        } else if (correctGuess <= 15){
            output = QuestionMaker.difficultyLevels[2];
        } else {
            output = QuestionMaker.difficultyLevels[3];
        }

        return output;
    }


    @Override
    public String getQuestionType() {
        Random random = new Random();
        int randomIndex = random.nextInt(QuestionMaker.questionTypes.length);
        return QuestionMaker.questionTypes[randomIndex];
    }

    @Override
    public String toString() {
        String output = "StageQuestionControl\n";
        output += "Question Type: " + getQuestionType() + "\n";
        output += "Question Difficulty: " + getQuestionDifficulty() + "\n";
        return output;
    }

    @Override
    public void update(GameStats gameStats) {
        this.correctGuess = gameStats.getGuessCorrect();
    }
}
