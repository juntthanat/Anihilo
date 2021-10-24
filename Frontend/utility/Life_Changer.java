package Frontend.utility;

import javax.swing.JLabel;

public class Life_Changer {
    static String life_text = "0";
    static JLabel life;

    /**
     * The class constructor
     *
     * @param life_label The label which displays the life of the player
     */
    public Life_Changer(JLabel life_label) {
        life = life_label;
    }

    /**
     * Changes the text of the life label
     */
    public static void change_scoreBoard() {
        life.setText(Utils.toHTML("<p style='font-size:10px; text-align:center;'>Life " + life_text + "</p>"));
    }

    /**
     * Sets the life String
     *
     * @param l The life string
     */
    public static void set_life(String l) {
        life_text = l;
    }
}
