package cmdVersion.game.lifeControl;

import cmdVersion.game.stats.GameStats;

public class AccLifeControl extends LifeControl {
    private double MIN_ACC;
    private double currentAcc;

    /**
    * Class constructor
    */
    public AccLifeControl() {
        MIN_ACC = 50.0;
        currentAcc = 100.0;
    }

    /**
    * Class constructor with minimum accuracy
    *
    * @param minAcc The minimum threshold
    */
    public AccLifeControl (double minAcc) {
        MIN_ACC = minAcc;
        currentAcc = 0.0;
    }

    /**
    * Checks if the user is still alive
    *
    * @return boolean Whether the player is still alive
    */
    @Override
    public boolean isAlive() {
        return this.currentAcc > MIN_ACC;
    }

    /**
    * Updates the accuracy of the player
    */
    @Override
    public void update(GameStats gameStats) {
        this.currentAcc = gameStats.getGuessAccuracy();
    }

    /**
    * Returns the information String
    *
    * @return String The information string
    */
    @Override
    public String toString() {
        String outString = "MINIMUM Threshold: " + MIN_ACC + "\n";
        outString += "Current Accuracy: " + currentAcc + "\n";
        return outString;
    }
}
