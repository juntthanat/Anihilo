package Frontend.main_menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;

public class Main_Menu_Page {
    JButton start_game, quit_game;
    JLabel icon_space;
    JPanel menu, mainMenu;
    ImageIcon icon;

    public Main_Menu_Page(JPanel main_page, CardLayout page, JFrame main) {
        mainMenu = Main_Menu(main_page, page, main);
    }

    /**
     * Constructs the main menu
     *
     * @param main_page The main page
     * @param page      The page to be switched to
     *
     * @return JPanel The main menu
     */
    public JPanel Main_Menu(JPanel main_page, CardLayout page, JFrame main) {

        menu = new JPanel();

        menu.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 50));
        menu.setPreferredSize(new Dimension(750, 600));
        // Put the icon in the Main_menu
        icon = new ImageIcon("Frontend/main_menu/Higher_Lower_Icon.png");
        icon_space = new JLabel(icon);
        icon_space.setPreferredSize(new Dimension(420, 170));

        // Create a Button
        start_game = new JButton("Start Game");
        start_game.setPreferredSize(new Dimension(300, 30));
        /*
         * start_game.addActionListener(new ActionListener() { public void
         * actionPerformed(ActionEvent e) { Page_Changer.set_page("page2");
         * Page_Changer.Change(main_page, page); } });
         */
        quit_game = new JButton("Quit Game");
        quit_game.setPreferredSize(new Dimension(300, 30));
        quit_game.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menu.add(icon_space);
        menu.add(start_game);
        menu.add(quit_game);

        main_page.add(menu, BorderLayout.CENTER);

        menu.setVisible(true);
        return menu;
    }

    public JPanel getMainMenu() {
        return mainMenu;
    }

    public JButton getStartGameButton() {
        return start_game;
    }
}
