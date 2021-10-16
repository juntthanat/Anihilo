package cmdVersion.game.lifeControl;

import cmdVersion.game.stats.GameStats;

public class StageLifeControl extends LifeControl{

    Integer remainingLives = 3;
    final Integer baseGuessTillNextLife = 3;
    Integer lifeGivenOut = 0;
    Integer correctGuessTillNextLife = 0;

    /**
    * Class constructor
    */
    public StageLifeControl(){
        correctGuessTillNextLife = lifeGivenOut + baseGuessTillNextLife;
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
                correctGuessTillNextLife = baseGuessTillNextLife + lifeGivenOut;
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
        String output = "StageLifeControl: " + "\n";
        output += "Remaining lives: " + remainingLives + "\n";
        output += "Correct guess til next life: " + correctGuessTillNextLife + "\n";
        return output;
    }
}
