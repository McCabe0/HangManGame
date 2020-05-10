package jack;



import com.sun.xml.internal.bind.v2.TODO;

import java.sql.SQLOutput;
import java.util.Scanner;

public class HangMan {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter The word you'll like to use: ");
        //Need to change so the string only allows letters
        String word = keyboard.nextLine();
        GameLogic game = new GameLogic(word);
        Prompter prompter = new Prompter(game);
        prompter.displayProgress();
        while (game.getRemainingTries() > 0 && !game.isWon()) {
            prompter.promptForGuess();
            prompter.displayProgress();
        }
        prompter.displayOutcome();
    }
}
