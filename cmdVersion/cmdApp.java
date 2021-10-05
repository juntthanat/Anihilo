package cmdVersion;

import cmdVersion.game.Game;
import cmdVersion.game.lifeControl.LifeControl;
import cmdVersion.game.lifeControl.StageLifeControl;
import cmdVersion.game.questionControl.QuestionControl;
import cmdVersion.game.questionControl.StageQuestionControl;
import cmdVersion.game.scoreControl.ScoreControl;
import cmdVersion.game.scoreControl.StageScoreControl;
import cmdVersion.questionFactory.Question;
import cmdVersion.questionFactory.QuestionMaker;
import connection.Anime;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import javax.swing.*;

public class cmdApp {
    public static void main(String[] args){
//
//        // Simple demo
//        QuestionMaker questionMaker = new QuestionMaker();
//        Question q;
//        Scanner input = new Scanner(System.in);
//
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(700,700);
//        frame.setLayout(new GridLayout(1,2));
//
//        // Defining label
//        JLabel labelLeft = new JLabel();
//        JLabel labelRight = new JLabel();
//
//        // Adding component to JFrame
//        frame.add(labelLeft);
//        frame.add(labelRight);
//
//        frame.setVisible(true);
//
//        int userAnswer;
//
//        for(int i = 0; i < 5; i++){
//            q = questionMaker.makeQuestion("easy", "ratingRank");
//            System.out.println(q.getPrompt() + "\n");
//
//            // Updating view
//            ImageIcon imageLeft = new ImageIcon(q.getLeftAnimeImgPath());
//            ImageIcon imageRight = new ImageIcon(q.getRightAnimeImgPath());
//
//            labelLeft.setIcon(imageLeft);
//            labelRight.setIcon(imageRight);
//
//            frame.repaint();
//
//            System.out.println("Anime 1: " + q.getLeftAnime().get_name());
//            System.out.println("Anime 2: " + q.getRightAnime().get_name());
//
//            System.out.print("\n Type -1 for Anime 1, and 1 for Anime 2: ");
//            userAnswer = input.nextInt();
//
//            if(q.checkAnswer(userAnswer)){
//                System.out.println("Correct!");
//            } else {
//                System.out.println("Wrong");
//            }
//
//            System.out.println("Anime 1 has rating rank of " + q.getLeftAnime().get_rating_rank());
//            System.out.println("Anime 2 has rating rank of " + q.getRightAnime().get_rating_rank());
//
//        }

        QuestionControl questionControl = new StageQuestionControl();
        ScoreControl scoreControl = new StageScoreControl();
        LifeControl lifeControl = new StageLifeControl();
        Game game = new Game(questionControl, lifeControl, scoreControl);
        game.run();
        // END OF MAIN
    }
}
