package jack;

import java.util.Scanner;

public class Prompter {

    private GameLogic gameLogic;


    public Prompter(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    public boolean promptForGuess() {
        Boolean isHit = false;
        Scanner scanner = new Scanner(System.in);
        Boolean isAcceptable = false;

        do {
            System.out.println("Enter a letter:  ");
            String guessInput = scanner.nextLine();

            try {
                isHit = gameLogic.applyGuess(guessInput);
                isAcceptable = true;
            } catch (IllegalArgumentException iae) {
                System.out.printf("%s, Please try again. %n",
                        iae.getMessage());
            }
        } while (!isAcceptable);
        return isHit;
    }

    public void displayProgress() {
        System.out.printf("You have %d tries left to solve %s %n",
                gameLogic.getRemainingTries(),
                gameLogic.getCurrentProgress());

    }

    public void displayOutcome(){
        if (gameLogic.isWon()){
            System.out.println("CONGRATS!! YOU WON");
        }else {
            System.out.printf("Sorry you have run out of guesses, the answer was %s",
                    gameLogic.getAnswer());
        }
    }

}
