package jack;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class GameLogicTest {

    private GameLogic gameLogic;


    @Before
    public void setUp() throws Exception {
        gameLogic = new GameLogic("Jack");
    }

    @Test
    public void applyingGuess() throws Exception{
        gameLogic.applyGuess("a");

        String answer = gameLogic.getCurrentProgress();

        assertEquals(gameLogic.getCurrentProgress().contains("-"), answer.contains("-"));

    }

    @Test
    public void guessingWrongToCheckIfNumberOfTriesGoesDown() throws Exception {
        gameLogic.applyGuess("i");

        int remainingTries = gameLogic.getRemainingTries();

        assertEquals(6,remainingTries);
    }



    @Test(expected = IllegalArgumentException.class)
    public void whenUserDoesntApplyGuessItReturnExpection() throws Exception {
        gameLogic.applyGuess("");

    }

    @Test
    public void displayIfTheUserHasWon() throws Exception {
        gameLogic.applyGuess("Jack");

        boolean isWon = gameLogic.isWon();

        assertEquals(gameLogic.isWon(), isWon);
    }
}