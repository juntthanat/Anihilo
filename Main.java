import cmdVersion.game.Game;
import cmdVersion.game.GameFactory;
import connection.*;
import Frontend.GUI;

import java.util.HashMap;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
/*            gui.setLeftAnimeButtonCallback(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    game.clickButtonLeftAnimeImg();

                }
            });*/

            gui.setLeftAnimeButtonMouseCallback(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() > 1) {
                        System.out.println("doubled");
                    } else {
                        game.clickButtonLeftAnimeImg();
                    }
                }
            });

/*            gui.setRightAnimeButtonCallback(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    game.clickButtonRightAnimeImg();
                }
            });*/

            gui.setRightAnimeButtonMouseCallback(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() > 1) {
                        System.out.println("doubled");
                    } else {
                        game.clickButtonRightAnimeImg();
                    }
                }
            });

            gui.setResetButtonCallback(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    game.clickButtonResetGame();
                }
            });

            gui.start();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
