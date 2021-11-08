package cmdVersion.game.lifeControl;

import cmdVersion.game.stats.GameStats;

public class StageLifeControl extends LifeControl{

    public static final Integer DEFAULT_AMOUNT_OF_LIVES = 3;

    Integer remainingLives = 3;
    final Integer DEFAULT_CORRECT_GUESS_TILL_NEXT_LIFE = 3;
    Integer lifeGivenOut = 0;
    Integer correctGuessTillNextLife = 0;
    /**
    * Class constructor
    */
    public StageLifeControl(){
        correctGuessTillNextLife = lifeGivenOut + DEFAULT_CORRECT_GUESS_TILL_NEXT_LIFE;
    }

    /**
    * Checks if the player is still alive
    *
    * @return boolean Whether the player is still alive
    */
    @Override
    public boolean isAlive() {
        return remainingLives > 0;
    }

    /**
    * Updates the life count of the user
    */
    @Override
    public void update(GameStats gameStats) {
        if(gameStats.isLatestQuestionAnsweredCorrect()){
            correctGuessTillNextLife--;
            if(correctGuessTillNextLife <= 0){
                remainingLives++;
                lifeGivenOut++;
                correctGuessTillNextLife = DEFAULT_CORRECT_GUESS_TILL_NEXT_LIFE * lifeGivenOut;
            }
        } else {
            remainingLives--;
        }
    }

    /**
    * Returns the information string
    *
    * @return String The output String
    */
    @Override
    public String toString() {
        String output = "";
        output += "Remaining lives: " + remainingLives + "<br/>";
        output += "Correct guess til next life: " + correctGuessTillNextLife + "\n";
        return output;
    }

    @Override
    public void reset() {
        remainingLives = DEFAULT_AMOUNT_OF_LIVES;
        lifeGivenOut = 0;
        correctGuessTillNextLife = DEFAULT_CORRECT_GUESS_TILL_NEXT_LIFE;
    }
}
