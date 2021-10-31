package Frontend.utility;

import javax.swing.JLabel;

public class Popularity_Changer {

    static String leftAnimePopularity = "0";
    static String rightAnimePopularity = "0";
    static JLabel leftAnimePopularityLabel;
    static JLabel rightAnimePopularityLabel;

    /**
     * The class constructor
     *
     * @param leftAnimePopularityLabel  The label which displays the popularity of
     *                                  the left anime
     * @param rightAnimePopularityLabel The label which displays the popularity of
     *                                  the right anime
     */
    public Popularity_Changer(JLabel leftAnimePopularityLabel, JLabel rightAnimePopularityLabel) {
        this.leftAnimePopularityLabel = leftAnimePopularityLabel;
        this.rightAnimePopularityLabel = rightAnimePopularityLabel;
    }

    /**
     * Changes the text of the both popularity
     */
    public static void change_scoreBoard() {
        leftAnimePopularityLabel.setText(Utils.toHTML("<p style='font-size:10px; text-align:center;'>Popularity<br />"
                + leftAnimePopularity + "<br /> -></p>"));
        rightAnimePopularityLabel.setText(Utils.toHTML("<p style='font-size:10px; text-align:center;'>Popularity<br />"
                + rightAnimePopularity + "<br /> <-</p>"));
    }

    /**
     * Sets the leftAnimePopularity String
     *
     * @param s The leftAnimePopularity string
     */
    public void setLeftAnimePopularity(String s) {
        leftAnimePopularity = s;
    }

    /**
     * Sets the rightAnimePopularity String
     *
     * @param s The rightAnimePopularity string
     */
    public void setRightAnimePopularity(String s) {
        rightAnimePopularity = s;
    }
}
