package Frontend.utility;

import java.awt.CardLayout;
import javax.swing.JPanel;

public class Page_Changer {
    static String num_page;

    /**
    * Changes the page
    *
    * @param main_page The main page
    * @param page      The page to be changed to
    */
    public static void Change(JPanel main_page, CardLayout page) {
        page.show(main_page, num_page);
    }

    /**
    * Sets the page number to be changed to
    *
    * @param page The page number as a String
    */
    public static void set_page(String page) {
        num_page = page;
    }
}
