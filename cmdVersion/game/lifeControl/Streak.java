package cmdVersion.game.lifeControl;

import cmdVersion.game.stats.GameStats;

public class Streak extends LifeControl {
    private int streak;

    /**
    * The class constructor
    */
    public Streak() {
        streak = 0;
    }

    /**
    * Checks whether the player is still alive
    *
    * @return boolean Whether if the player is still alive
    */
    @Override
    public boolean isAlive() {
        return streak > 0;
    }

    /**
    * Updates the streak of the player
    */
    @Override
    public void update(GameStats gameStats) {
        streak = gameStats.getGuessCorrectStreak();
    }

    /**
    * Returns the information string
    *
    * @return String The information string
    */
    @Override
    public String toString() {
        String output = "Streak\n";
        output += "Current Streak: " + streak + "\n";

        return output;
    }

    @Override
    public void reset() {
        streak = 0;
    }

}
