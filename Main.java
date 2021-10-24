import connection.*;
import Frontend.GUI;

import java.util.HashMap;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {
    public static void main(String[] args) {
        try {
            GUI gui = new GUI();
            gui.useDefaultStartButton();

            // ONLY USE useDefaultButtonBehavior IN TEST
            // ENVIRONMENT
            // gui.useDefaultButtonBehavior();

            gui.setLeftAnimeButtonCallback(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    gui.setButtonImages("./animeImage/rick.png", "./animeImage/rick.png");
                    gui.updateButtonImages();

                    gui.setInstructionText("Never gonna give you up");
                    gui.updateInstructionText();

                    gui.setScore("420");
                    gui.setAccuracy("69");
                    gui.setGuess("69");
                    gui.updateScoreboard();

                    gui.setAnimeTitle("Never gonna run around", "and desert you");
                    gui.updateAnimeTitle();
                }
            });

            gui.setRightAnimeButtonCallback(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    gui.setButtonImages("./animeImage/rick.png", "./animeImage/rick.png");
                    gui.updateButtonImages();

                    gui.setInstructionText("Never gonna give you up");
                    gui.updateInstructionText();

                    gui.setScore("420");
                    gui.setAccuracy("69");
                    gui.setGuess("69");
                    gui.updateScoreboard();

                    gui.setAnimeTitle("Never gonna run around", "and desert you");
                    gui.updateAnimeTitle();
                }
            });

            gui.start();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
