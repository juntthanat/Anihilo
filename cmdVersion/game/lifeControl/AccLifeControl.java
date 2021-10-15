package cmdVersion.game.lifeControl;

import cmdVersion.game.stats.GameStats;

public class AccLifeControl extends LifeControl {
    private double MIN_ACC;
    private double currentAcc;

    public AccLifeControl() {
        MIN_ACC = 50.0;
        currentAcc = 100.0;
    }

    public AccLifeControl (double minAcc) {
        MIN_ACC = minAcc;
    }

    @Override
    public boolean isAlive() {
        return this.currentAcc > MIN_ACC;
    }

    @Override
    public void update(GameStats gameStats) {
        this.currentAcc = gameStats.getGuessAccuracy();
    }

    @Override
    public String toString() {
        String outString = "MINIMUM Threshold: " + MIN_ACC + "\n";
        outString += "Current Accuracy: " + currentAcc + "\n";
        return outString;
    }
}
