package Frontend.main_game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

import Frontend.utility.Image_Changer;
import Frontend.utility.Instruction_Changer;
import Frontend.utility.AnimeTitle_Changer;
import Frontend.utility.Score_Changer;
import Frontend.utility.Popularity_Changer;

import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import java.awt.Dimension;

import java.awt.Color;

import Frontend.utility.Utils;

public class Game_Part {
    JPanel center_panel, center_top_panel, center_top_center_panel, center_bot_panel, center_bot_empty_panel,
            aniPanel_L, aniPanel_R, resultPanel, rightAnimePopularityPanel, leftAnimePopularityPanel;
    JLabel rightAnimePopularity, leftAnimePopularity, aniL_text, aniR_text, result;
    JButton button_L, button_R;

    Image_Changer img;
    AnimeTitle_Changer titleChanger;
    Popularity_Changer popularityChanger;

    /**
     * Creates buttons and image panels
     *
     * @param main_game_page The main game page
     * @param main_page      The main page
     * @param page           A page to be switched to
     */
    public Game_Part(JPanel main_game_page, JPanel main_page, CardLayout page) {
        // * Create a Panel for the Game_part (Center Part)
        center_panel = new JPanel(new BorderLayout());
        //// * Create a panel for the top part of the Game_part
        center_top_panel = new JPanel(new BorderLayout());

        ////// * Create a panel for popularity both side
        leftAnimePopularityPanel = new JPanel();
        leftAnimePopularityPanel.setPreferredSize(new Dimension(100, 100));
        leftAnimePopularity = new JLabel();

        rightAnimePopularityPanel = new JPanel();
        rightAnimePopularityPanel.setPreferredSize(new Dimension(100, 100));
        rightAnimePopularity = new JLabel();

        // leftAnimePopularityPanel.setBounds(10, 168, 100, 100);
        // rightAnimePopularityPanel.setBounds(640, 168, 100, 100);

        leftAnimePopularityPanel.add(leftAnimePopularity);
        rightAnimePopularityPanel.add(rightAnimePopularity);

        ////// * Create Panel in the center
        center_top_center_panel = new JPanel(new BorderLayout());
        //////// * Create a button

        ////////// * Goto Utility Image_Changer for more info
        img = new Image_Changer();

        button_L = new JButton(img.getImage_L());
        button_L.setPreferredSize(new Dimension(195, 277));
        button_R = new JButton(img.getImage_R());
        button_R.setPreferredSize(new Dimension(195, 277));

        // button_L.setBounds(120, 80, 195, 277);
        // button_R.setBounds(435, 80, 195, 277);

        /*
         * button_L.addActionListener(new ActionListener() { public void
         * actionPerformed(ActionEvent e) { button_L.setIcon(img.getImage_L());
         * Instruction_Changer.change_instruction();
         * AnimeTitle_Changer.changeAnimeTitle(); Score_Changer.change_scoreBoard(); }
         * });
         */
        /*
         * button_R.addActionListener(new ActionListener() { public void
         * actionPerformed(ActionEvent e) { button_R.setIcon(img.getImage_R());
         * Instruction_Changer.change_instruction();
         * AnimeTitle_Changer.changeAnimeTitle(); Score_Changer.change_scoreBoard(); }
         * });
         */

        //////// * Create a Result Panel
        resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        resultPanel.setPreferredSize(new Dimension(90, 277));
        resultPanel.setBorder(BorderFactory.createEmptyBorder(123, 0, 123, 0));
        // resultPanel.setBounds(330, 205, 90, 30);

        result = new JLabel("<html><p{text-alignment: center;} style=\"font-size:12px\"> or </p></html>");
        resultPanel.add(result);

        center_top_center_panel.add(button_L, BorderLayout.WEST);
        center_top_center_panel.add(button_R, BorderLayout.EAST);
        center_top_center_panel.add(resultPanel, BorderLayout.CENTER);

        center_top_panel.add(leftAnimePopularityPanel, BorderLayout.WEST);
        center_top_panel.add(rightAnimePopularityPanel, BorderLayout.EAST);
        center_top_panel.add(center_top_center_panel, BorderLayout.CENTER);

        //// * Create a panel in the bottom part of the game_part
        center_bot_panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        center_bot_panel.setPreferredSize(new Dimension(0, 63));
        // center_bot_panel.setBorder(BorderFactory.createEmptyBorder(0, 80, 0, 80));
        //// * Anime title
        aniPanel_L = new JPanel();
        aniPanel_L.setPreferredSize(new Dimension(235, 63));
        // aniPanel_L.setBounds(100, 357, 235, 63);
        aniPanel_R = new JPanel();
        aniPanel_R.setPreferredSize(new Dimension(235, 63));
        // aniPanel_R.setBounds(415, 357, 235, 63);
        center_bot_empty_panel = new JPanel();
        center_bot_empty_panel.setPreferredSize(new Dimension(105, 0));

        aniL_text = new JLabel();
        aniPanel_L.add(aniL_text);
        aniR_text = new JLabel();
        aniPanel_R.add(aniR_text);

        center_bot_panel.add(aniPanel_L);
        center_bot_panel.add(center_bot_empty_panel);
        center_bot_panel.add(aniPanel_R);

        center_panel.add(center_top_panel, BorderLayout.NORTH);
        center_panel.add(center_bot_panel, BorderLayout.SOUTH);

        main_game_page.add(center_panel, BorderLayout.CENTER);

        titleChanger = new AnimeTitle_Changer(aniL_text, aniR_text, result);
        popularityChanger = new Popularity_Changer(leftAnimePopularity, rightAnimePopularity);
        Instruction_Changer.change_instruction();
        // AnimeTitle_Changer.changeAnimeTitle();
    }

    public JButton getLeftButton() {
        return button_L;
    }

    public JButton getRightButton() {
        return button_R;
    }

    public Image_Changer getImageChanger() {
        return img;
    }

    public AnimeTitle_Changer getTitleChanger() {
        return titleChanger;
    }

    public Popularity_Changer getPopularityChanger() {
        return popularityChanger;
    }
}
