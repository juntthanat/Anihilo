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


            // ONLY USE useDefaultButtonBehavior IN TEST
            // ENVIRONMENT
            // gui.useDefaultButtonBehavior();

            Game game = GameFactory.createGame(GameFactory.gameModes[0]);
            game.initializeGame();
            gui.setLeftAnimeButtonCallback(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    game.clickButtonLeftAnimeImg();
                    game.clickButtonNextQuestion(); // Putting it here temp since 2021 Oct 30 since no next question button
                    gui.setLife("69");
                    gui.updateLife();
                }
            });

            gui.setRightAnimeButtonCallback(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    game.clickButtonLeftAnimeImg();
                    game.clickButtonNextQuestion(); // Putting it here temp since 2021 Oct 30 since no next question button
                }
            });

            gui.setResetButtonCallback(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Never gonna give you up");
                }
            });

            gui.start();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
