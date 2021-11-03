package Frontend.main_game;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Frontend.utility.Life_Changer;
import Frontend.utility.Score_Changer;
import Frontend.utility.Utils;

import java.awt.CardLayout;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.border.MatteBorder;
import java.awt.Dimension;

public class Score_Part {
        JPanel score_part_panel, streak_border, score_top_part, life_border, score_bot_part, score_border, guess_border,
                        accuracy_border;
        JLabel streak, life, score, guess, accuracy;

        Score_Changer scoreChanger;
        Life_Changer lifeChanger;

        /**
         * Constructs a section that shows the score of the player
         *
         * @param main_game_page The main game page
         * @param main_page      The main page
         * @param page           The page to be switched to
         */
        public Score_Part(JPanel main_game_page, JPanel main_page, CardLayout page) {

                // * Create Panel for the Score_Part (Bottom Part)
                score_part_panel = new JPanel(new BorderLayout());
                score_part_panel.setPreferredSize(new Dimension(0, 140));

                //// * Panel for Top part of Score_Part
                score_top_part = new JPanel(new BorderLayout());
                score_top_part.setPreferredSize(new Dimension(0, 50));

                ////// * Panel for life
                life_border = new JPanel(new BorderLayout());
                life_border.setPreferredSize(new Dimension(250, 50));
                life_border.setBorder(new MatteBorder(1, 1, 0, 1, Color.black));

                life = new JLabel(Utils.toHTML("<p style='font-size:10px; text-align:west;'>Life 0</p>"));
                life.setPreferredSize(new Dimension(250, 50));
                life.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));

                life_border.add(life, BorderLayout.NORTH);
                score_top_part.add(life_border, BorderLayout.WEST);

                //// * Panel for streak

                streak_border = new JPanel(new BorderLayout());
                streak_border.setPreferredSize(new Dimension(250, 50));
                streak_border.setBorder(new MatteBorder(1, 1, 0, 1, Color.black));

                streak = new JLabel(Utils.toHTML("<p style='font-size:10px; text-align:center;'>Streak 0</p>"));
                streak.setPreferredSize(new Dimension(250, 50));
                streak.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));

                streak_border.add(streak, BorderLayout.NORTH);
                score_top_part.add(streak_border, BorderLayout.EAST);

                //// * Panel for bottom part of Score_Part
                score_bot_part = new JPanel(new BorderLayout());
                score_bot_part.setPreferredSize(new Dimension(0, 90));

                ////// * Panel for score
                score_border = new JPanel();
                score_border.setPreferredSize(new Dimension(250, 90));
                score_border.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));

                score = new JLabel(Utils.toHTML("<p style='font-size:20px; text-align:center;'>Score<br />0</p>"));

                score_border.add(score);
                score_bot_part.add(score_border, BorderLayout.WEST);

                ////// * Panel for Guess
                guess_border = new JPanel();
                guess_border.setPreferredSize(new Dimension(250, 90));
                guess_border.setBorder(new MatteBorder(1, 0, 1, 0, Color.black));

                guess = new JLabel(Utils.toHTML("<p style='font-size:20px; text-align:center;'>Guess<br />0</p>"));

                guess_border.add(guess);
                score_bot_part.add(guess_border, BorderLayout.CENTER);

                ////// * Panel for accuracy
                accuracy_border = new JPanel();
                accuracy_border.setPreferredSize(new Dimension(250, 90));
                accuracy_border.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));

                accuracy = new JLabel(
                                Utils.toHTML("<p style='font-size:20px; text-align:center; '>Accuracy<br />0</p>"));

                accuracy_border.add(accuracy);
                score_bot_part.add(accuracy_border, BorderLayout.EAST);

                //// * Panel for streak
                // streak_border = new JPanel();
                // streak_border.setBounds(325, 235, 100, 60);
                // streak = new JLabel(Utils.toHTML("<p style='font-size:10px;
                //// text-align:center;'>Streak <br />0</p>"));
                // streak_border.add(streak);
                // main_game_page.add(streak_border);

                score_part_panel.add(score_top_part, BorderLayout.NORTH);
                score_part_panel.add(score_bot_part, BorderLayout.SOUTH);

                main_game_page.add(score_part_panel, BorderLayout.SOUTH);

                scoreChanger = new Score_Changer(score, guess, accuracy, streak);
                lifeChanger = new Life_Changer(life);
        }

        public Score_Changer getScoreChanger() {
                return scoreChanger;
        }

        public Life_Changer getLifeChanger() {
                return lifeChanger;
        }
}
