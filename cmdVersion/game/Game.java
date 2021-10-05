package cmdVersion.game;

import cmdVersion.game.lifeControl.LifeControl;
import cmdVersion.game.questionControl.QuestionControl;
import cmdVersion.game.scoreControl.ScoreControl;
import cmdVersion.game.stats.GameStats;
import cmdVersion.questionFactory.Question;
import cmdVersion.questionFactory.QuestionMaker;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Game {
    QuestionMaker questionMaker = new QuestionMaker();
    GameStats gameStats = new GameStats();
    QuestionControl questionControl;
    LifeControl lifeControl;
    ScoreControl scoreControl;

    public Game(QuestionControl questionControl, LifeControl lifeControl, ScoreControl scoreControl) {
        this.questionControl = questionControl;
        this.lifeControl = lifeControl;
        this.scoreControl = scoreControl;
    }

    public void update(){
        this.questionControl.update(this.gameStats);
        this.lifeControl.update(this.gameStats);
        this.scoreControl.update(this.gameStats);
    }

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
            gameStats.setQuestion(this.questionMaker.makeQuestion(questionDifficulty, questionType));

            // Updating view
            ImageIcon imageLeft = new ImageIcon(gameStats.getQuestion().getLeftAnimeImgPath());
            ImageIcon imageRight = new ImageIcon(gameStats.getQuestion().getRightAnimeImgPath());

            labelLeft.setIcon(imageLeft);
            labelRight.setIcon(imageRight);

            frame.repaint();


            System.out.println("Anime 1: " + gameStats.getQuestion().getLeftAnime().get_name());
            System.out.println("Anime 2: " + gameStats.getQuestion().getRightAnime().get_name());

            System.out.print("\n Type -1 for Anime 1, and 1 for Anime 2: ");
            userAnswer = input.nextInt();

            if(gameStats.getQuestion().checkAnswer(userAnswer)){
                System.out.println("Correct!");
                this.gameStats.answeredCorrect();
            } else {
                System.out.println("Wrong");
                this.gameStats.answeredWrong();
            }

            this.update();
            System.out.println("Anime 1 has rating rank of " + gameStats.getQuestion().getLeftAnime().get_rating_rank());
            System.out.println("Anime 2 has rating rank of " + gameStats.getQuestion().getRightAnime().get_rating_rank());
            System.out.println("\nPress enter 1 to continue:\n");

            Integer pressToContinue  = input.nextInt();

            System.out.println(this.toString());

        }
        System.out.println("Game over");
    }
}
