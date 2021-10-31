package Frontend.utility;

import javax.swing.JLabel;

public class Instruction_Changer {
    static String instruction = "";
    static String diff = "";
    static JLabel instruction_text;
    static JLabel diff_text;

    public Instruction_Changer(JLabel instructionText, JLabel diffText) {
        instruction_text = instructionText;
        diff_text = diffText;
    }

    // will change the instruction text once the button is click (already implement)
    public static void change_instruction() {
        instruction = LineBreaker.breaker(instruction, 40);
        instruction_text
                .setText("<html><p{text-alignment: center;} style=\"font-size:18px\">" + instruction + "</p></html>");
    }

    // will change the diff text once the button is click (already implement)
    public static void change_diff() {
        diff = LineBreaker.breaker(diff, 30);
        diff_text.setText("<html><p{text-alignment: center;} style=\"font-size:18px\">" + diff + "</p></html>");
    }

    // set the instruction text
    public static void set_instruction(String instruction_text) {
        instruction = instruction_text;
    }

    // set the diff text
    public static void set_diff(String diff_text) {
        diff = diff_text;
    }
}