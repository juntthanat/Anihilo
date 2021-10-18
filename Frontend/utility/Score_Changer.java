package Frontend.utility;

import javax.swing.JLabel;

public class Score_Changer {
    static String score_text = "0";
    static String accuracy_text = "0";
    static String guess_text = "0";
    static JLabel score;
    static JLabel accuracy;
    static JLabel guess;

    public Score_Changer(JLabel score_label, JLabel guess_label, JLabel accuracy_label) {
        score = score_label;
        accuracy = accuracy_label;
        guess = guess_label;
    }

    public static void change_scoreBoard() {
        score.setText(Utils.toHTML("<p style='font-size:20px; text-align:center;'>Score<br />" + score_text + "</p>"));
        accuracy.setText(
                Utils.toHTML("<p style='font-size:20px; text-align:center;'>Accuracy<br />" + accuracy_text + "</p>"));
        guess.setText(Utils.toHTML("<p style='font-size:20px; text-align:center;'>Guess<br />" + guess_text + "</p>"));

    }

    public static void set_score(String s) {
        score_text = s;
    }

    public static void set_accuracy(String a) {
        accuracy_text = a;
    }

    public static void set_guess(String g) {
        guess_text = g;
    }
}
