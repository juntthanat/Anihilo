package Frontend.main_game;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Frontend.utility.Page_Changer;

import Frontend.utility.Instruction_Changer;

public class Instruction {
    Instruction_Changer instructionChanger;
    JButton reset_button;

    /**
     * Shows the instruction
     *
     * @param main_game_page The main game page
     * @param main_page      The main page
     * @param page           A page to be switched to
     */
    public Instruction(JPanel main_game_page, JPanel main_page, CardLayout page) {

        //// * (button for back)
        JButton back_button = new JButton("Main Menu");
        back_button.setBounds(10, 10, 100, 20);
        back_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Page_Changer.set_page("page1");
                Page_Changer.Change(main_page, page);
            }
        });
        main_game_page.add(back_button);

        // * Create Text Area
        //// * Text for Instruction
        JPanel instruction_panel = new JPanel();
        instruction_panel.setBounds(125, 0, 500, 80);

        JLabel instruction_text = new JLabel("");
        instruction_panel.add(instruction_text);
        main_game_page.add(instruction_panel);

        // * Create Difficulty Text Area
        JPanel diff_panel = new JPanel();
        diff_panel.setBounds(630, 5, 100, 40);

        JLabel diff_text = new JLabel("");
        instruction_panel.add(instruction_text);
        diff_panel.add(diff_text);
        main_game_page.add(diff_panel);

        // * Create Reset Button
        reset_button = new JButton("Reset");
        reset_button.setBounds(10, 40, 100, 20);
        main_game_page.add(reset_button);

        instructionChanger = new Instruction_Changer(instruction_text, diff_text);
    }

    public Instruction_Changer getInstructionChanger() {
        return instructionChanger;
    }

    public JButton getResetButton() {
        return reset_button;
    }
}
