package Frontend.utility;

import javax.swing.JLabel;

public class AnimeTitle_Changer {
    static String animeTitle_L = "";
    static String animeTitle_R = "";
    static JLabel aniL;
    static JLabel aniR;

    public AnimeTitle_Changer(JLabel aniL_text, JLabel aniR_text) {
        aniL = aniL_text;
        aniR = aniR_text;
    }

    // will change both anime title once the button is click (already implement)
    public static void changeAnimeTitle() {
        animeTitle_L = LineBreaker.breaker(animeTitle_L, 25);
        aniL.setText("<html><p{text-alignment: center;} style=\"font-size:12px\">" + animeTitle_L + "</p></html>");
        animeTitle_R = LineBreaker.breaker(animeTitle_R, 25);
        aniR.setText("<html><p{text-alignment: center;} style=\"font-size:12px\">" + animeTitle_R + "</p></html>");
    }

    // set anime title left side
    public static void setAnimeTitle_L(String animeTitle) {
        animeTitle_L = animeTitle;
    }

    // set anime title right side
    public static void setAnimeTitle_R(String animeTitle) {
        animeTitle_R = animeTitle;
    }
}
