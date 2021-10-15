package cmdVersion.game.lifeControl;

import cmdVersion.game.stats.GameStats;

public class Streak extends LifeControl {
    private int streak;

    public Streak() {
        streak = 0;
    }

    @Override
    public boolean isAlive() {
        return streak > 0;
    }

    @Override
    public void update(GameStats gameStats) {
        streak = gameStats.getGuessCorrectStreak();
    }

    @Override
    public String toString() {
        String output = "Streak\n";
        output += "Current Streak: " + streak + "\n";

        return output;
    }
}
