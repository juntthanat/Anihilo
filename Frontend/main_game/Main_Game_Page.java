package Frontend.main_game;

import Frontend.utility.Score_Changer;
import Frontend.utility.Instruction_Changer;
import Frontend.utility.Life_Changer;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class Main_Game_Page {
    private Instruction instruction;
    private Game_Part game_part;
    private Score_Part score_part;
    private JPanel main_game, menu;

    public Main_Game_Page(JPanel main_page, CardLayout page) {
        main_game = main_Game(main_page, page);
    }

    /**
     * Constructs a page for the main game
     *
     * @param main_page The main page
     * @param page      A page to be switched to
     *
     * @return JPanel The main game page
     */
    public JPanel main_Game(JPanel main_page, CardLayout page) {
        menu = new JPanel();
        menu.setPreferredSize(new Dimension(750, 600));
        // menu.setBounds(0, 0, 750, 600);
        menu.setLayout(new BorderLayout());

        // * create panel.
        instruction = new Instruction(menu, main_page, page);
        score_part = new Score_Part(menu, main_page, page);
        game_part = new Game_Part(menu, main_page, page);

        main_page.add(menu);

        menu.setVisible(true);
        return menu;
    }

    public Instruction getInstruction() {
        return this.instruction;
    }

    public Game_Part getGamePart() {
        return this.game_part;
    }

    public Score_Part getScorePart() {
        return this.score_part;
    }

    public JPanel getMainGame() {
        return this.main_game;
    }

    public Score_Changer getScoreChanger() {
        return score_part.getScoreChanger();
    }

    public Life_Changer getLifeChanger() {
        return score_part.getLifeChanger();
    }

    public Instruction_Changer getInstructionChanger() {
        return instruction.getInstructionChanger();
    }

    public JButton getResetButton() {
        return instruction.getResetButton();
    }
}
