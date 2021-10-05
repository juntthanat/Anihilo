package cmdVersion.game.lifeControl;

import cmdVersion.game.stats.GameStats;

public abstract class LifeControl {

    public abstract boolean isAlive();
    public abstract void update(GameStats gameStats);
    public abstract String toString();

}


