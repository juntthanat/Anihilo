package cmdVersion;

import Frontend.GUI;
import Frontend.Main_GUI;
import cmdVersion.game.Game;
import cmdVersion.game.GameFactory;
import connection.ConnectionError;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class cmdApp {
    public static void main(String[] args){

        cmdApp.cmdAttempt();

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
//            q = questionMaker.makeQuestion("easy", "startDate");
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
//            System.out.println("Anime 1 has attribute of " + q.getLeftAnime().get_start_date());
//            System.out.println("Anime 2 has attribute of " + q.getRightAnime().get_start_date());
//
//        }
        // 2021 Oct 11
//        QuestionControl questionControl = new StageQuestionControl();
//        ScoreControl scoreControl = new StageScoreControl();
//        LifeControl lifeControl = new StageLifeControl();
//        Game game = new Game(questionControl, lifeControl, scoreControl);
//        game.run();


//        Anime anime1 = new Anime();
//        System.out.println(anime1.get_name());
//        System.out.println(anime1.get_start_date());
//        System.out.println(anime1.get_end_date());

//        String strDate1 = "2017-07-25";
//        String strDate2 = "2018-01-01";
//        LocalDate date1 = LocalDate.parse(strDate1, DateTimeFormatter.ISO_DATE);
//        LocalDate date2 = LocalDate.parse(strDate2, DateTimeFormatter.ISO_DATE);
//        System.out.println(date2.compareTo(date1));
        // END OF MAIN
    }

    public static void cmdAttempt(){
        GUI gui = null;
        Game game = null;
        try {
            gui = GUI.getInstance();
            game = GameFactory.createGame(GameFactory.gameModes[0]);
            game.initializeGame();
        } catch (Exception e){
            System.out.println(e);
        }

        Scanner input = new Scanner(System.in);
        int userInput = -1;
        while(userInput != 0){
            System.out.println("Enter your options: ");
            System.out.println("1. Click leftAnimeButton");
            System.out.println("2. Click rightAnimeButton");
            System.out.println("3. Click nextQuestionButton");
            System.out.println("4. Click resetGameButton");
            System.out.println("5. Click previousPageButton");
            System.out.println("0. Exit");
            System.out.print("Select your option: ");

            try{
                userInput = Integer.parseInt(input.nextLine());
            } catch (Exception e){
                System.out.println("Error input please try again");
            }



            switch(userInput){
                case 1 -> game.clickButtonLeftAnimeImg();
                case 2 -> game.clickButtonRightAnimeImg();
                case 3 -> game.clickButtonNextQuestion();
                case 4 -> game.clickButtonResetGame();
                case 5 -> game.clickButtonBackToPreviousPage();
                case 0 -> System.out.println("About to exit experiment");
            }
        }
    }

}
