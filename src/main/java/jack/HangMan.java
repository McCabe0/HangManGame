package jack;

import java.sql.SQLOutput;
import java.util.Scanner;

public class HangMan {
    public static void main(String[] args) {
        GameLogic game = new GameLogic("Hello");
        Prompter prompter = new Prompter(game);
        prompter.displayProgress();
        while (game.getRemainingTries() > 0 && !game.isWon()) {
            prompter.promptForGuess();
            prompter.displayProgress();
        }
        prompter.displayOutcome();
    }
}
