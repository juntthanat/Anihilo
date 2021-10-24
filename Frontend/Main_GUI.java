package Frontend;

import Frontend.main_game.Main_Game_Page;
import Frontend.main_menu.Main_Menu_Page;
import Frontend.main_game.Game_Part;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main_GUI {
    JFrame main_page;
    JPanel page1, page2;
    CardLayout page;
    JPanel deck;
    Main_Menu_Page main_menu;
    Main_Game_Page main_game;

    Main_GUI() throws Exception {
        // JFrame main_page = new JFrame();
        main_page = new JFrame();

        // * Setting Frame Size and etc
        main_page.setSize(750, 600);
        main_page.setResizable(false);
        main_page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_page.setLayout(null);

        // * set Title
        main_page.setTitle("Higher or Lower");

        // * Instruction
        page = new CardLayout();
        deck = new JPanel();
        deck.setBounds(0, 0, 750, 600);
        deck.setLayout(page);

        // * create and add JPanel to deck
        main_menu = new Main_Menu_Page(deck, page, main_page);
        page1 = main_menu.getMainMenu();
        deck.add(page1, "page1");

        main_game = new Main_Game_Page(deck, page);
        page2 = main_game.getMainGame();
        deck.add(page2, "page2");

        main_page.add(deck);

    }

    // public static void main(String[] args) throws Exception {
    public void start() throws Exception {
        // * make JFrame visible (need to be put last)
        main_page.setVisible(true);
    }

    public Main_Game_Page getMainGamePage() {
        return main_game;
    }

    public Main_Menu_Page getMainMenuPage() {
        return main_menu;
    }

    public JPanel getDeck() {
        return deck;
    }

    public CardLayout getCardLayoutPage() {
        return page;
    }
}
