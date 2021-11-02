package Frontend.main_game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Frontend.utility.Page_Changer;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;

import Frontend.utility.Instruction_Changer;

public class Instruction {
    // Instruction_Changer instructionChanger;
    // JButton reset_button;

    JPanel instruction_panel, button_panel, instruction_text_panel, diff_panel;
    JLabel instruction_text, diff_text;
    JButton back_button, reset_button;
    Instruction_Changer instructionChanger;

    /**
     * Shows the instruction
     *
     * @param main_game_page The main game page
     * @param main_page      The main page
     * @param page           A page to be switched to
     */
    public Instruction(JPanel main_game_page, JPanel main_page, CardLayout page) {

        // * Create Panel for Instruction
        instruction_panel = new JPanel(new BorderLayout());
        instruction_panel.setPreferredSize(new Dimension(0, 80));

        //// * Create Back Button
        button_panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 10));
        button_panel.setPreferredSize(new Dimension(120, 0));

        back_button = new JButton("Main Menu");
        back_button.setPreferredSize(new Dimension(100, 20));
        back_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Page_Changer.set_page("page1");
                Page_Changer.Change(main_page, page);
            }
        });
        //// * Create Reset Button
        reset_button = new JButton("Reset");
        reset_button.setPreferredSize(new Dimension(100, 20));

        button_panel.add(back_button);
        button_panel.add(reset_button);

        // * Create Label for instruction
        //// * Text for Instruction
        instruction_text_panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        instruction_text = new JLabel();
        instruction_text_panel.add(instruction_text);
        instruction_panel.add(instruction_text_panel);

        // * Create Difficulty Text Area
        diff_panel = new JPanel();
        diff_panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        diff_panel.setPreferredSize(new Dimension(120, 0));

        diff_text = new JLabel("");
        diff_panel.add(diff_text);

        instruction_panel.add(diff_panel, BorderLayout.EAST);
        instruction_panel.add(button_panel, BorderLayout.WEST);
        instruction_panel.add(instruction_text_panel, BorderLayout.CENTER);

        main_game_page.add(instruction_panel, BorderLayout.NORTH);

        instructionChanger = new Instruction_Changer(instruction_text, diff_text);
    }

    public Instruction_Changer getInstructionChanger() {
        return instructionChanger;
    }

    public JButton getResetButton() {
        return reset_button;
    }
}
