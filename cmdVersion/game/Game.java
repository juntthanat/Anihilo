package cmdVersion.game;

import cmdVersion.game.lifeControl.LifeControl;
import cmdVersion.game.questionControl.QuestionControl;
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

    /**
    * The class constructor which receives all options
    *
    * @param questionControl The question factory
    * @param lifeControl     A lifeControl object that updates the status of the player
    * @param scoreControl    A scoreContorl object that updates the score of the user
    *
    * @throws ConnectionError
    */
    public Game(QuestionControl questionControl, LifeControl lifeControl, ScoreControl scoreControl) throws ConnectionError {
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
}
