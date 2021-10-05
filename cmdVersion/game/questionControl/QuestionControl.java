package cmdVersion.game.questionControl;

import cmdVersion.game.stats.GameStats;

public abstract class QuestionControl {

    public abstract String getQuestionDifficulty();
    public abstract String getQuestionType();
    public abstract String toString();
    public abstract void update(GameStats gameStats);
    
}
