package cmdVersion.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Player implements ActionListener {
    String name;

    // Stats
    double accuracy = 0;
    int totalGuess = 0;
    int correctGuess = 0;
    int correctStreak = 1;

    // Lives
    int livesRemaining;
    int nextLifeGuess;


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
