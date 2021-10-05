package cmdVersion.game.scoreControl;

import cmdVersion.game.stats.GameStats;

public abstract class ScoreControl {

    public abstract void update(GameStats gameStats);
    public abstract Integer calculateScore();
    public abstract String toString();

}
