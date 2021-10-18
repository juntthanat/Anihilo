package Frontend.main_menu;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import Frontend.utility.Page_Changer;

public class Main_Menu_Page {
    /**
    * Constructs the main menu
    *
    * @param main_page The main page
    * @param page      The page to be switched to
    *
    * @return JPanel The main menu
    */
    public static JPanel Main_Menu(JPanel main_page, CardLayout page, JFrame main) {

        JPanel menu = new JPanel();

        menu.setLayout(null);
        menu.setBounds(0, 0, 750, 600);

        // Put the icon in the Main_menu
        ImageIcon icon = new ImageIcon("Frontend/main_menu/Higher_Lower_Icon.png");
        JLabel icon_space = new JLabel(icon);
        icon_space.setBounds(165, 40, 420, 170);

        menu.add(icon_space);

        // Create a Button
        JButton start_game = new JButton("Start");
        start_game.setBounds(225, 230, 300, 30);
        start_game.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Page_Changer.set_page("page2");
                Page_Changer.Change(main_page, page);
            }
        });

        JButton quit_game = new JButton("Quit");
        quit_game.setBounds(225, 300, 300, 30);
        quit_game.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menu.add(start_game);
        menu.add(quit_game);

        main_page.add(menu);

        menu.setVisible(true);
        return menu;
    }
}
