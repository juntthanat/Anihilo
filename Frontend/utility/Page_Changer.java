package Frontend.utility;

import java.awt.CardLayout;
import javax.swing.JPanel;

public class Page_Changer {
    static String num_page;

    public static void Change(JPanel main_page, CardLayout page) {
        page.show(main_page, num_page);
    }

    public static void set_page(String page) {
        num_page = page;
    }
}
