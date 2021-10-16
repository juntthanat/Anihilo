package Frontend.main_game;

import java.awt.CardLayout;
import javax.swing.JPanel;

public class Main_Game_Page {
        public static JPanel Main_Game(JPanel main_page, CardLayout page) {
                JPanel menu = new JPanel();
                menu.setBounds(0, 0, 750, 600);
                menu.setLayout(null);

                // * create panel.
                new Instruction(menu, main_page, page);
                new Game_Part(menu, main_page, page);
                new Score_Part(menu, main_page, page);

                main_page.add(menu);

                menu.setVisible(true);
                return menu;
        }
}