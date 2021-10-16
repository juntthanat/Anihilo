package cmdVersion.game.scoreControl;

import cmdVersion.game.stats.GameStats;

public class StageScoreControl extends ScoreControl{

    Integer totalScore = 0;
    Integer baseScorePerQuestion = 100;
    Integer streakBonus = 10;

    /**
    * Updates the current score of the player.
    */
    @Override
    public void update(GameStats gameStats) {
        if(gameStats.isLatestQuestionAnsweredCorrect()){
            totalScore += baseScorePerQuestion;
            totalScore += gameStats.getGuessCorrectStreak() * streakBonus;
        }
    }

    /**
    * Returns the current score of the user
    *
    * @return totalScore The total score of the user
    */
    @Override
    public Integer calculateScore() {
        return totalScore;
    }

    /**
    * Returns the score-related information as a string
    *
    * @return outputString The output string.
    */
    @Override
    public String toString() {
        String output = "StageScoreControl\n";
        output += "Current score: " + calculateScore() + "\n";
        return output;
    }
}
