package cmdVersion.game.lifeControl;

import cmdVersion.game.stats.GameStats;

public class Hardcore extends LifeControl {
    private boolean isDead;

    public Hardcore() {
        isDead = false;
    }

    @Override
    public boolean isAlive() {
        return !isDead;
    }

    @Override
    public void update(GameStats gameStats) {
        isDead = !gameStats.isLatestQuestionAnsweredCorrect ();
    }

    @Override
    public String toString() {
        String output = "Hardcore\n";
        output += "Is Still Alive: " + !isDead + "\n";

        return output;
    }
}
