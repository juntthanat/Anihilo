package Frontend.utility;

import javax.swing.JLabel;

public class Score_Changer {
    static String score_text = "0";
    static String accuracy_text = "0";
    static String guess_text = "0";
    static String streak_text = "0";
    static JLabel score;
    static JLabel accuracy;
    static JLabel guess;
    static JLabel streak;

    /**
     * The class constructor
     *
     * @param score_label    The label which displays the score of the player
     * @param guess_label    The label which displays the number of guesses of the
     *                       player
     * @param accuracy_label The label which displays the accuracy of the player
     * @param streak_label   The label which displays the streak of the player
     */
    public Score_Changer(JLabel score_label, JLabel guess_label, JLabel accuracy_label, JLabel streak_label) {
        score = score_label;
        accuracy = accuracy_label;
        guess = guess_label;
        streak = streak_label;
    }

    /**
     * Changes the text of the score, accuracy and guess labels
     */
    public static void change_scoreBoard() {
        if (accuracy_text.length() > 3)
            accuracy_text = accuracy_text.substring(0, 4);
        score.setText(Utils.toHTML("<p style='font-size:20px; text-align:center;'>Score<br />" + score_text + "</p>"));
        accuracy.setText(
                Utils.toHTML("<p style='font-size:20px; text-align:center;'>Accuracy<br />" + accuracy_text + "</p>"));
        guess.setText(Utils.toHTML("<p style='font-size:20px; text-align:center;'>Guess<br />" + guess_text + "</p>"));
        streak.setText(
                Utils.toHTML("<p style='font-size:10px; text-align:center;'>Streak <br />" + streak_text + "</p>"));

    }

    /**
     * Sets the score String
     *
     * @param s The score string
     */
    public static void set_score(String s) {
        score_text = s;
    }

    /**
     * Sets the accuracy String
     *
     * @param a The accuracy String
     */
    public static void set_accuracy(String a) {
        accuracy_text = a;
    }

    /**
     * Sets the guess String
     *
     * @param g The guess String
     */
    public static void set_guess(String g) {
        guess_text = g;
    }

    /**
     * Sets the streak String
     *
     * @param s The streak String
     */
    public static void set_streak(String s) {
        streak_text = s;
    }
}
