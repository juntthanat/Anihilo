package cmdVersion.userInterface;

import cmdVersion.game.Game;
import cmdVersion.game.GameFactory;
import connection.ConnectionError;

import java.util.Scanner;


public class Menu {
    public static final int EXIT = 0;

    /**
    * Displays the main menu
    */
    @Deprecated
    public void showMainMenu() {
        Scanner input = new Scanner(System.in);
        Integer userInput = -1;


        while(userInput != EXIT) {
            System.out.println("Main menu page (Show the main menu page)"); // Here like GUI.showMainMenuPage()
            System.out.println("0. Exit");
            System.out.println("1. Play");
            System.out.println("Select your option: (At this point the algorithm is waiting for a user to press button)");
            userInput = Integer.parseInt(input.nextLine()); // Here like GUI.getUserInputMainMenuPage()


            switch (userInput) {
                case 0 -> {
                    System.out.println("User have selected option 0: Exit");
                    System.out.println("Prepare to move the exit page");
                }
                case 1 -> {
                    System.out.println("User have selected option 1: Play");
                    System.out.println("Prepare to move to play page");
                    showSelectGameMode(); // GUI.showSelectGameModePage()
                }
            }
        }
        System.out.println("Exit the program by clicking exit button");

    } // END OF showMainMenu()

    /**
    * Lets the user select the game mode
    */
    @Deprecated
    public void showSelectGameMode(){
        Scanner input = new Scanner(System.in);
        boolean isGameGenerated = false;
        int userInput = -1;
        String gameModeChoice = "";
        Game game = null;

        while(userInput != EXIT) {
            System.out.println("Select game mode page");
            System.out.println("0. Exit");
            System.out.println("1. " + GameFactory.gameModes[0]);
//            System.out.println("2. Suddent Death");
//            System.out.println("3. RNG");
//            System.out.println("4. Practice");
            System.out.println("Select your option: ");
            userInput = Integer.parseInt(input.nextLine()); // GUI.getUserInputSelectGameMode()


            switch (userInput) {
                case 0 -> {
                    System.out.println("User has selected option 0: Exit");
                    System.out.println("Prepare to move back a page/exit program");
                }
                case 1 -> {
                    System.out.println("User have selected option 1: Classic");
                    System.out.println("Prepare to move to game age with classic game");
                    gameModeChoice = GameFactory.gameModes[0];
                }
//                case 2 -> {
//                    System.out.println("User have selected option 2: Sudden death");
//                    System.out.println("Prepare to move the game page with sudden death game");
//                }
//                case 3 -> {
//                    System.out.println("User have selection option 3: RNG");
//                    System.out.println("Prepare to move to game page with RNG game");
//                }
//                case 4 -> {
//                    System.out.println("User have selected option 4: Practice");
//                    System.out.println("Prepare to move to game page with practice game");
//                }
            }

            if(userInput == EXIT){
                break;
            }


            game = GameFactory.createGame(gameModeChoice);
            showGamePage(game);
        }
        System.out.println("End of showSelectGameMode() in menu()");
        // Go back to the selection game mode page
    } // END OF selectionGameMode()

    /**
    * Handles the launching and ending of the game
    */
    @Deprecated
    public void showGamePage(Game inGame) {
        Scanner input = new Scanner(System.in);

        System.out.println("Game is about to begin");
        inGame.run();
        System.out.println("GAME OVER! (Show game over page");
        System.out.println("End of showGamePage()");
    }// END OF showGamePage
}
