import cmdVersion.game.Game;
import cmdVersion.game.GameFactory;
import connection.*;
import Frontend.GUI;

import java.util.HashMap;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {
    public static void main(String[] args) {
        try {
            GUI gui = GUI.getInstance();
            gui.useDefaultStartButton();

            Game game = null;
            game = GameFactory.createGame(GameFactory.gameModes[0]);
            game.initializeGame();

            // ONLY USE useDefaultButtonBehavior IN TEST
            // ENVIRONMENT
            // gui.useDefaultButtonBehavior();

            Game finalGame = game;

            gui.setLeftAnimeButtonCallback(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    gui.setButtonImages("./animeImage/rick.png", "./animeImage/rick.png");
                    gui.updateButtonImages();

                    gui.setInstructionText("Never gonna give you up");
                    gui.updateInstructionText();

                    gui.setResultText("Rick!");
                    gui.updateResultText();

                    gui.setScore("420");
                    gui.setAccuracy("69");
                    gui.setGuess("69");
                    gui.updateScoreboard();

                    gui.setAnimeTitle("Never gonna run around", "and desert you");
                    gui.updateAnimeTitle();
                    gui.setDifficultyText("VERY EASY");
                    System.out.println("Clicked left anime button");
                    finalGame.clickButtonLeftAnimeImg();
                    finalGame.clickButtonNextQuestion();

                }
            });

            gui.setRightAnimeButtonCallback(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    gui.setButtonImages("./animeImage/rick.png", "./animeImage/rick.png");
                    gui.updateButtonImages();

                    gui.setInstructionText("Never gonna give you up");
                    gui.updateInstructionText();

                    gui.setResultText("Rick!");
                    gui.updateResultText();

                    gui.setScore("420");
                    gui.setAccuracy("69");
                    gui.setGuess("69");
                    gui.updateScoreboard();

                    gui.setAnimeTitle("Never gonna run around", "and desert you");
                    gui.updateAnimeTitle();
                    System.out.println("Clicked right anime button");

                    finalGame.clickButtonRightAnimeImg();
                    finalGame.clickButtonNextQuestion();
                }
            });

            gui.start();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
