package Frontend;

import Frontend.Main_GUI;
import Frontend.main_game.Game_Part;
import Frontend.main_game.Main_Game_Page;
import Frontend.main_menu.Main_Menu_Page;
import Frontend.utility.Image_Changer;
import Frontend.utility.AnimeTitle_Changer;
import Frontend.utility.Score_Changer;
import Frontend.utility.Instruction_Changer;
import Frontend.utility.Page_Changer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends Main_GUI {
    private static GUI instance;
    Main_Menu_Page mainMenu;
    Main_Game_Page mainGame;
    Game_Part gamePart;
    Image_Changer img;
    Score_Changer scoreChanger;
    Instruction_Changer instructionChanger;
    JButton leftButton, rightButton;
    AnimeTitle_Changer titleChanger;

    private GUI() throws Exception {
        super();
        mainGame = getMainGamePage();
        mainMenu = getMainMenuPage();
        instructionChanger = mainGame.getInstructionChanger();
        scoreChanger = mainGame.getScoreChanger();
        gamePart = mainGame.getGamePart();
        img = gamePart.getImageChanger();
        leftButton = gamePart.getLeftButton();
        rightButton = gamePart.getRightButton();
        titleChanger = gamePart.getTitleChanger();
    }

    public static GUI getInstance() throws Exception {
        if (instance == null) {
            instance = new GUI();
        }
        return instance;
    }

    /**
     * Sets the callback function of the left anime's button
     *
     * @param callback The callback function.
     */
    public void setLeftAnimeButtonCallback(ActionListener callback) {
        leftButton.addActionListener(callback);
    }

    /**
     * Sets the callback function of the right anime's button
     *
     * @param callback The callback function.
     */
    public void setRightAnimeButtonCallback(ActionListener callback) {
        rightButton.addActionListener(callback);
    }

    /**
     * ONLY USE THIS FUNCTION IN TEST ENVIRONMENT
     */
    public void useDefaultButtonBehavior() {
        setLeftAnimeButtonCallback(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateButtonImages();
                updateInstructionText();
                updateScoreboard();
                updateAnimeTitle();
            }
        });

        setRightAnimeButtonCallback(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateButtonImages();
                updateInstructionText();
                updateScoreboard();
                updateAnimeTitle();
            }
        });

        useDefaultStartButton();
    }

    /**
     * Uses the default behavior of the start button
     */
    public void useDefaultStartButton() {
        setStartGameButtonCallback(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Page_Changer.set_page("page2");
                Page_Changer.Change(getDeck(), getCardLayoutPage());
            }
        });
    }

    /**
     * Sets the path to left button's image WITHOUT updating the button's image.
     *
     * @param path The path to the image.
     */
    public void setLeftButtonImagePath(String path) {
        img.setImage_L(path);
    }

    /**
     * Sets the path to right button's image WITHOUT updating the button's image.
     *
     * @param path The path to the image.
     */
    public void setRightButtonImagePath(String path) {
        img.setImage_R(path);
    }

    /**
     * Updates left button's image from the path set earlier using
     * setLeftButtonImagePath(String)
     */
    private void updateLeftButtonImage() {
        leftButton.setIcon(img.getImage_L());
    }

    /**
     * Updates right button's image from the path set earlier using
     * setRightButtonImagePath(String)
     */
    private void updateRightButtonImage() {
        rightButton.setIcon(img.getImage_R());
    }

    /**
     * Updates both buttons' images
     */
    public void updateButtonImages() {
        updateLeftButtonImage();
        updateRightButtonImage();
    }

    /**
     * Sets and updates the image of the left button
     *
     * @param path The path to the image
     */
    private void setLeftImage(String path) {
        img.setImage_L(path);
        leftButton.setIcon(img.getImage_L());
    }

    /**
     * Sets and updates the image of the right button
     *
     * @param path The path to the image
     */
    private void setRightImage(String path) {
        img.setImage_R(path);
        rightButton.setIcon(img.getImage_R());
    }

    /**
     * Sets and updates the images of the buttons
     *
     * @param left_path  The path to left anime's image.
     * @param right_path The path to right anime's image.
     */
    public void setButtonImages(String left_path, String right_path) {
        setLeftImage(left_path);
        setRightImage(right_path);
    }

    /**
     * Sets the left anime's title WITHOUT updating it in the GUI.
     *
     * @param title The anime's title
     */
    public void setLeftAnimeTitle(String title) {
        titleChanger.setAnimeTitle_L(title);
    }

    /**
     * Sets the right anime's title WITHOUT updating it in the GUI.
     *
     * @param title The anime's title
     */
    public void setRightAnimeTitle(String title) {
        titleChanger.setAnimeTitle_R(title);
    }

    /**
     * Sets both anime's title WITHOUT updating it in the GUI
     *
     * @param left_title  The left anime's title
     * @param right_title The right anime's title
     */
    public void setAnimeTitle(String left_title, String right_title) {
        setLeftAnimeTitle(left_title);
        setRightAnimeTitle(right_title);
    }

    /**
     * Updates both animes title in the GUI
     */
    public void updateAnimeTitle() {
        titleChanger.changeAnimeTitle();
    }

    /**
     * Sets and updates the Anime Titles
     *
     * @param left_title  The title of the left anime.
     * @param right_title The title of the right anime.
     */
    public void setAndUpdateAnimeTitles(String left_title, String right_title) {
        titleChanger.setAnimeTitle_L(left_title);
        titleChanger.setAnimeTitle_R(right_title);
        titleChanger.changeAnimeTitle();
    }

    /**
     * Sets the result text without changing the GUI
     *
     * @param resultText The result text
     */
    public void setResultText(String resultText) {
        titleChanger.setResult(resultText);
    }

    /**
     * Updates the result text in the GUI
     */
    public void updateResultText() {
        titleChanger.updateResultText();
    }

    /**
     * Sets the callback function for the start game button in the main menu page.
     *
     * @param callback The callback function
     */
    public void setStartGameButtonCallback(ActionListener callback) {
        mainMenu.getStartGameButton().addActionListener(callback);
    }

    /**
     * Sets the score without updating the scoreboard. Seeี updateScoreboard(String,
     * String, String) for changing the score + updating the scoreboard or
     * updateScoreboard() for just updating the scoreboard.
     *
     * @param s The score of the player
     */
    public void setScore(String s) {
        scoreChanger.set_score(s);
    }

    /**
     * Sets the accuracy without updating the scoreboard. See
     * updateScoreboard(String, String, String) for changing the accuracy + updating
     * the scoreboard or updateScoreboard() for just updating the scoreboard.
     *
     * @param s The accuracy of the player
     */
    public void setAccuracy(String s) {
        scoreChanger.set_accuracy(s);
    }

    /**
     * Sets the guess without updating the scoreboard. See updateScoreboard(String,
     * String, String) for changing the guess + updating the scoreboard or
     * updateScoreboard() for just updating the scoreboard.
     *
     * @param s The guess of the player
     */
    public void setGuess(String s) {
        scoreChanger.set_guess(s);
    }

    /**
     * Updates the scoreboard
     */
    public void updateScoreboard() {
        scoreChanger.change_scoreBoard();
    }

    /**
     * Setting the values of score, accuracy, and guess of the player and updates
     * the scoreboard.
     *
     * @param score    The score of the player.
     * @param accuracy The accuracy of the player.
     * @param guess    The guess of the player.
     */
    public void updateScoreboard(String score, String accuracy, String guess) {
        setScore(score);
        setAccuracy(accuracy);
        setGuess(guess);
        updateScoreboard();
    }

    /**
     * Sets and updates the instruction text.
     *
     * @param instruction The instruction text.
     */
    public void setAndUpdateInstructionText(String instruction) {
        instructionChanger.set_instruction(instruction);
        instructionChanger.change_instruction();
    }

    /**
     * Changes the instruction text without updating the instruction text in the
     * GUI.
     */
    public void setInstructionText(String instruction) {
        instructionChanger.set_instruction(instruction);
    }

    /**
     * Updates the instruction text in the GUI.
     */
    public void updateInstructionText() {
        instructionChanger.change_instruction();
    }

    /**
     * Sets and updates the difficulty text.
     *
     * @param difficultyText The difficulty text.
     */
    public void setDifficultyText(String difficultyText) {
        instructionChanger.set_diff(difficultyText);
        instructionChanger.change_diff();
    }

    public JFrame getMainPage() {
        return this.main_page;
    }
}
