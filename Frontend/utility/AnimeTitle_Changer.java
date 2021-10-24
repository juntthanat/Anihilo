package Frontend.utility;

import javax.swing.JLabel;

public class AnimeTitle_Changer {
    static String animeTitle_L = "";
    static String animeTitle_R = "";
    static String resultText = "";
    static JLabel aniL;
    static JLabel aniR;
    static JLabel result;

    /**
     * The class constructor
     *
     * @param aniL_text   The label for the left anime
     * @param aniR_text   The label for the right anime
     * @param result_text the label for the result of the answer
     */
    public AnimeTitle_Changer(JLabel aniL_text, JLabel aniR_text, JLabel result_text) {
        aniL = aniL_text;
        aniR = aniR_text;
        result = result_text;
    }

    /**
     * Changes the text of each label to match the title of the anime
     */
    public static void changeAnimeTitle() {
        animeTitle_L = LineBreaker.breaker(animeTitle_L, 25);
        aniL.setText("<html><p{text-alignment: center;} style=\"font-size:12px\">" + animeTitle_L + "</p></html>");
        animeTitle_R = LineBreaker.breaker(animeTitle_R, 25);
        aniR.setText("<html><p{text-alignment: center;} style=\"font-size:12px\">" + animeTitle_R + "</p></html>");
        result.setText("<html><p{text-alignment: center;} style=\"font-size:12px\">" + resultText + "</p></html>");
    }

    /**
     * Changes the text of the left anime's label
     *
     * @param animeTitle The title of the left anime
     */
    public static void setAnimeTitle_L(String animeTitle) {
        animeTitle_L = animeTitle;
    }

    /**
     * Changes the text of the right anime's label
     *
     * @param animeTitle The title of the right anime
     */
    public static void setAnimeTitle_R(String animeTitle) {
        animeTitle_R = animeTitle;
    }

    /**
     * Changes the text of the result's label
     *
     * @param resultTitle The title of the result
     */
    public static void setResult(String resultTitle) {
        resultText = resultTitle;
    }
}
