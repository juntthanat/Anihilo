package cmdVersion.game;

import cmdVersion.game.lifeControl.LifeControl;
import cmdVersion.game.lifeControl.StageLifeControl;
import cmdVersion.game.questionControl.QuestionControl;
import cmdVersion.game.questionControl.StageQuestionControl;
import cmdVersion.game.scoreControl.ScoreControl;
import cmdVersion.game.scoreControl.StageScoreControl;
import connection.ConnectionError;


public class GameFactory {
    public static final String[] gameModes = {"Classic"};

    public static Game createGame(String gameModeName) {

        QuestionControl questionControl;
        ScoreControl scoreControl;
        LifeControl lifeControl;

        if (gameModeName.equalsIgnoreCase(gameModes[0])){ // Classic
            questionControl = new StageQuestionControl();
            scoreControl = new StageScoreControl();
            lifeControl = new StageLifeControl();
        } else {
            System.out.println("Error at createGame");
            System.out.println("Returning classic game mode");
            questionControl = new StageQuestionControl();
            scoreControl = new StageScoreControl();
            lifeControl = new StageLifeControl();
        }

        return new Game(questionControl, lifeControl, scoreControl);
    }
}
