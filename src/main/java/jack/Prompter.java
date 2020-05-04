package jack;

import java.util.Scanner;

public class Prompter {

    private GameLogic gameLogic;


    public Prompter(GameLogic gameLogic){
        this.gameLogic = gameLogic;
    }

    public boolean promptForGuess(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a letter:  ");
        String guessInput = scanner.nextLine();
        char guess = guessInput.charAt(0);
        Boolean isHit = false;
        try {
            isHit = gameLogic.applyGuess(guess);
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
        return isHit;
    }

    public void displayProgress(){
        System.out.printf("You have %d tries left to solve %s %n",
                gameLogic.getRemainingTries(),
                gameLogic.getCurrentProgress());

    }

}
