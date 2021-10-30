package cmdVersion.game.lifeControl;

import cmdVersion.game.stats.GameStats;

public class Hardcore extends LifeControl {
    private boolean isDead;

    /**
    * The class constructor
    */
    public Hardcore() {
        isDead = false;
    }

    /**
    * Checks whether the player is still alive
    *
    * @return boolean Whether the player is still alive
    */
    @Override
    public boolean isAlive() {
        return !isDead;
    }

    /**
    * Make the player dead if he should be dead
    */
    @Override
    public void update(GameStats gameStats) {
        isDead = !gameStats.isLatestQuestionAnsweredCorrect ();
    }

    /**
    * Returns the information String
    *
    * @return String The information string
    */
    @Override
    public String toString() {
        String output = "Hardcore\n";
        output += "Is Still Alive: " + !isDead + "\n";

        return output;
    }

    @Override
    public void reset() {
        isDead = false;
    }
}
