package cmdVersion.game;

import cmdVersion.game.lifeControl.LifeControl;
import cmdVersion.game.questionControl.QuestionControl;
import cmdVersion.game.questionFactory.Question;
import cmdVersion.game.scoreControl.ScoreControl;
import cmdVersion.game.stats.GameStats;
import cmdVersion.game.questionFactory.QuestionMaker;
import connection.ConnectionError;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Game {
    QuestionMaker questionMaker;
    GameStats gameStats;
    QuestionControl questionControl;
    LifeControl lifeControl;
    ScoreControl scoreControl;

    public static final Integer GAME_STATE_WAITING = 0; // User waiting for algorithm to update
    public static final Integer GAME_STATE_ANSWERING = 1; // User is trying to answer the question
    public static final Integer GAME_STATE_LOOK_AT_RESULT = 2; // User is looking at the result of the answer
    public static final Integer GAME_STATE_OVER = 3; // User has lose the game
    Integer currentGameState = GAME_STATE_WAITING;

    /**
    * The class constructor which receives all options
    *
    * @param questionControl The question factory
    * @param lifeControl     A lifeControl object that updates the status of the player
    * @param scoreControl    A scoreContorl object that updates the score of the user
    *
    * @throws ConnectionError
    */
    public Game(QuestionControl questionControl, LifeControl lifeControl, ScoreControl scoreControl){
        this.questionControl = questionControl;
        this.lifeControl = lifeControl;
        this.scoreControl = scoreControl;

        // Default creation
        this.questionMaker = new QuestionMaker();
        this.gameStats = new GameStats();
    }

    /**
    * The class constructor which creates this object based on
    * another Game object
    *
    * @param another The Game object to base this object on
    *
    * @throws ConnectionError
    */
    public Game(Game another) throws ConnectionError{
        this(another.questionControl, another.lifeControl, another.scoreControl);
    }

    /**
    * Updates the status of the player
    */
    @Deprecated
    public void update(){
        this.questionControl.update(this.gameStats);
        this.lifeControl.update(this.gameStats);
        this.scoreControl.update(this.gameStats);
    }

    /**
    * Returns the information string
    *
    * @return String An information String
    */
    @Override
    public String toString() {
        return "Game\n" +
                "questionMaker\n" + questionMaker.toString() + "\n" +
                ", gameStats\n" + gameStats.toString() + "\n" +
                ", questionControl\n" + questionControl.toString() +  "\n" +
                ", lifeControl\n" + lifeControl.toString() +  "\n" +
                ", scoreControl\n" + scoreControl.toString() +  "\n"
             ;
    }

    /**
    * Runs the game
    */
    @Deprecated
    public void run(){
        Scanner input = new Scanner(System.in);
        Integer userAnswer = -5;

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,700);
        frame.setLayout(new GridLayout(1,2));

        // Defining label
        JLabel labelLeft = new JLabel();
        JLabel labelRight = new JLabel();

        // Adding component to JFrame
        frame.add(labelLeft);
        frame.add(labelRight);

        frame.setVisible(true);

        while(lifeControl.isAlive()){
            String questionDifficulty = questionControl.getQuestionDifficulty();
            String questionType = questionControl.getQuestionType();

            // Making sure there is no connection problem
            boolean questionIsGenerated = false;
            while(! questionIsGenerated){
                try {
                    gameStats.setQuestion(this.questionMaker.makeQuestion(questionDifficulty, questionType));
                    questionIsGenerated = true;
                } catch (ConnectionError e){
                    System.out.println("Error: Connection problem at game.run()");
                    System.out.println("Please reconnect your internet and press 1 to cotinue: ");
                    String stopper = input.nextLine();
                }

            }



            // Updating view
            ImageIcon imageLeft = new ImageIcon(gameStats.getQuestion().getLeftAnimeImgPath());
            ImageIcon imageRight = new ImageIcon(gameStats.getQuestion().getRightAnimeImgPath());

            labelLeft.setIcon(imageLeft);
            labelRight.setIcon(imageRight);

            frame.repaint();

            System.out.println(gameStats.getQuestion().getPrompt());
            System.out.println("Anime 1: " + gameStats.getQuestion().getLeftAnime().get_name());
            System.out.println("Anime 2: " + gameStats.getQuestion().getRightAnime().get_name());

            System.out.print("\n Type -1 for Anime 1, and 1 for Anime 2: ");
            userAnswer = Integer.parseInt(input.nextLine());

            if(gameStats.getQuestion().checkAnswer(userAnswer)){
                System.out.println("Correct!");
                this.gameStats.answeredCorrect();
            } else {
                System.out.println("Wrong");
                this.gameStats.answeredWrong();
            }

            this.update();
            System.out.println("Anime 1 " + gameStats.getQuestion().getLeftAnimeQuestionRelevantData());
            System.out.println("Anime 2 " + gameStats.getQuestion().getRightAnimeQuestionRelevantData());
            System.out.println("\nPress enter 1 to continue:\n");

            Integer pressToContinue  = Integer.parseInt(input.nextLine());

            System.out.println(this.toString());

        }
        System.out.println("End of game.run()");
        frame.dispose();
    }

    // Generate question inside the game stats
    private void generateQuestion(){
        Scanner input = new Scanner(System.in);
        String questionDifficulty = questionControl.getQuestionDifficulty();
        String questionType = questionControl.getQuestionType();

        boolean questionIsGenerated = false;
        while(! questionIsGenerated){
            try {
                gameStats.setQuestion(this.questionMaker.makeQuestion(questionDifficulty, questionType));
                questionIsGenerated = true;
            } catch (ConnectionError e){
                displayConnectionErrorPopUp();
            }
        }
        System.out.println("generateQuestion() generated a question");
    }

    // Update the control object based on the game stats
    private void updateControlObject(){
        this.questionControl.update(this.gameStats);
        this.lifeControl.update(this.gameStats);
        this.scoreControl.update(this.gameStats);
    }

    // Reset the game back to the initial state
    private void resetGame(){
        lifeControl.reset();
        questionControl.reset();
        scoreControl.reset();
        gameStats.reset();
    }

    // Answer the question,update control object, tell user the answer, update current game state
    private void answerQuestion(Integer userAnswer){
        if(! currentGameState.equals(GAME_STATE_ANSWERING)){
            System.out.println("User press buttonAnimeImg at wrong game state; currentGameState(IntCode): " + currentGameState + " answer(IntCode): " + userAnswer);
            return;
        }

        currentGameState = GAME_STATE_WAITING;

        if(gameStats.getQuestion().checkAnswer(userAnswer)){
            this.gameStats.answeredCorrect();
        } else {
            this.gameStats.answeredWrong();
        }

        this.updateControlObject();
        this.displayUserAnswerCorrectOrWrong();
        this.displayAnswer();

        currentGameState = GAME_STATE_LOOK_AT_RESULT;
    }

    // This function would have its print statement replaced the by GUI function like GUI.setLeftAnimeImage()
    private void displayQuestion(){
        Question currentQuestion = gameStats.getQuestion();
        System.out.println("Update prompt to: " + currentQuestion.getPrompt());
        System.out.println("Update the leftAnimeImgButton to: " + currentQuestion.getLeftAnimeImgPath());
        System.out.println("Update the rightAnimeImgButton to: " + currentQuestion.getRightAnimeImgPath());
        System.out.println("Update the leftAnimeTitle to: " + currentQuestion.getLeftAnime().get_name());
        System.out.println("Update the rightAnimeTitle to: " + currentQuestion.getRightAnime().get_name());
        System.out.println("Update GUI questionDifficultyTextBox to: " + currentQuestion.getDifficulty());
        System.out.println("Update GUI questionControlTypeTextBox to: " + currentQuestion.getType());
    }

    // This function would have its print statement replaced by the GUI function like GUI.setAccuracy()
    private void displayStats(){
        System.out.println("Update guess to: " + gameStats.getGuessAmount());
        System.out.println("Update accuracy to: " + gameStats.getGuessAccuracy());
        System.out.println("Update score to: " + scoreControl.calculateScore());
    }

    // This function would have its print statement replaced by the GUI function like GUI.setGameBackGround(Color.RED)
    private void displayUserAnswerCorrectOrWrong(){
        if(gameStats.isLatestQuestionAnsweredCorrect()){
            System.out.println("Update gameBackground color: Green");
        } else {
            System.out.println("Update gameBackground color: Red");
        }
    }

    private void displayConnectionErrorPopUp(){
        System.out.println("Update GUI to show a message box telling user there is internet problem");
        System.out.println("Pop waiting for user to click OK after to fix internet problem (Press 1 and enter to continue): ");
        Scanner clickToProceed = new Scanner(System.in);
        clickToProceed.nextLine();
    }

    private void displayGameOver(){
        System.out.println("GUI updates the prompt to: GAME OVER!");
        System.out.println("GUI updates the leftAnimeImgButton to: imgLeftGameOver.png");
        System.out.println("GUI updates the rightAnimeImgButton to: imgRightGameOver.png");
        System.out.println("GUI updates the leftAnimeTitle to: To play again press the reset button");
        System.out.println("GUI updates the rightAnimeTitle to: To play again press the reset button");
    }

    // This will update the GUI with info relevant question for the anime
    // Ex: If Qn ask about which anime came out first, this will update with leftAnime 2001-02-03 and rightAnime 2005-07-16
    private void displayAnswer(){
        System.out.println("GUI update the leftAnimeQuestionRelevantInfo: " + gameStats.getQuestion().getLeftAnimeQuestionRelevantData());
        System.out.println("GUI update the rightAnimeQuestionRelevantInfo: " + gameStats.getQuestion().getRightAnimeQuestionRelevantData());
    }

    // Display the lifeControl system which show the user how far they are from reaching game over
    // Basically it show the stats relating when will the user lose, but we have many different implementation
    private void displayLifeControl(){
        System.out.println("Update GUI lifeControlTextBox to: " + lifeControl.toString());
    }

    // Interact-able methods or buttons

    public void initializeGame(){
        System.out.println("About to initialize the game");
        this.generateQuestion();

        this.displayQuestion();
        this.displayStats();
        this.displayLifeControl();
        currentGameState = GAME_STATE_ANSWERING;
    }

    public void clickButtonLeftAnimeImg(){
        this.answerQuestion(Question.ANSWER_LEFT);
    }

    public void clickButtonRightAnimeImg(){
        this.answerQuestion(Question.ANSWER_RIGHT);
    }

    // This is the pause in between question
    // To allow user to see whether they answer correctly
    public void clickButtonNextQuestion(){
        if(! currentGameState.equals(GAME_STATE_LOOK_AT_RESULT)){
            System.out.println("User clicked buttonNextQuestion at wrong game state GameState(IntCode): " + currentGameState);
        } else if (! lifeControl.isAlive()){ // Player has met the losing condition
            currentGameState = GAME_STATE_OVER;
            this.displayGameOver();
        }else { // Player keep playing
            currentGameState = GAME_STATE_WAITING;
            System.out.println("GUI set background color: White/Grey");
            this.generateQuestion();

            this.displayQuestion();
            this.displayStats();
            this.displayLifeControl();
            currentGameState = GAME_STATE_ANSWERING;
        }
    }

    // Clicked the button
    public void clickButtonBackToPreviousPage(){

    }

    public void clickButtonResetGame(){
        currentGameState = GAME_STATE_WAITING;
        this.resetGame();
        this.initializeGame();
    }
}
