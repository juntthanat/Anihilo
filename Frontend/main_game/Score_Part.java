package Frontend.main_game;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Frontend.utility.Utils;

public class Score_Part {
        public Score_Part(JPanel main_game_page, JPanel main_page, CardLayout page) {
                // * Create Border
                // * Panel for score
                JPanel score_border = new JPanel();
                score_border.setBounds(0, 450, 250, 150);
                score_border.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));

                // ? wait for tae input in score_test
                String score_test = "10000";
                JLabel score = new JLabel(Utils.toHTML(
                                "<p style='font-size:20px; text-align:center;'>Score<br />" + score_test + "</p>"));

                score_border.add(score);
                main_game_page.add(score_border);

                // * Panel for Guess
                JPanel guess_border = new JPanel();
                guess_border.setBounds(250, 450, 250, 150);
                guess_border.setBorder(new MatteBorder(1, 0, 1, 0, Color.black));
                // wait for tae input in guess_test
                String guess_test = "1";
                JLabel guess = new JLabel(Utils.toHTML(
                                "<p style='font-size:20px; text-align:center;'>Guess<br />" + guess_test + "</p>"));

                guess_border.add(guess);
                main_game_page.add(guess_border);

                // * Panel for accuracy
                JPanel accuracy_border = new JPanel();
                accuracy_border.setBounds(500, 450, 250, 150);
                accuracy_border.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
                // wait for tae input in accuracy_test
                String accuracy_test = "10000";
                JLabel accuracy = new JLabel(Utils.toHTML("<p style='font-size:20px; text-align:center;'>Accuracy<br />"
                                + accuracy_test + "</p>"));

                accuracy_border.add(accuracy);
                main_game_page.add(accuracy_border);
        }
}
