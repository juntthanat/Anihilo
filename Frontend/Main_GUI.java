package Frontend;

import Frontend.main_game.Main_Game_Page;
import Frontend.main_menu.Main_Menu_Page;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main_GUI {
    public static void main(String[] args) throws Exception {
        JFrame main_page = new JFrame();

        // * Setting Frame Size and etc
        main_page.setSize(750, 600);
        main_page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_page.setLayout(null);

        // * set Title
        main_page.setTitle("Higher or Lower");

        // * Instruction
        CardLayout page = new CardLayout();
        JPanel deck = new JPanel();
        deck.setBounds(0, 0, 750, 600);
        deck.setLayout(page);

        // * create and add JPanel to deck
        JPanel page1 = Main_Menu_Page.Main_Menu(deck, page);
        deck.add(page1, "page1");
        JPanel page2 = Main_Game_Page.Main_Game(deck, page);
        deck.add(page2, "page2");

        main_page.add(deck);

        // * make JFrame visible (need to be put last)
        main_page.setVisible(true);
    }
}
