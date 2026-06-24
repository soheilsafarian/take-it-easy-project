package it.units.takeiteasy;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {

    @Test
    void gameFinishesWhenAllBoardPositionsAreFilled() {
        String output = runGame(
                "0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18"
        );

        assertTrue(output.contains("=== Welcome to Take It Easy ==="));
        assertTrue(output.contains("=== GAME FINISHED ==="));
        assertTrue(output.contains("Board is full!"));
        assertTrue(output.contains("Final Score:"));
        assertTrue(output.contains("Thanks for playing!"));
    }

    @Test
    void gameRejectsInvalidAndOccupiedPositionsThenContinues() {
        String output = runGame(
                "hello -1 19 0 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18"
        );

        assertTrue(output.contains("Please enter a number!"));
        assertTrue(output.contains("Position must be between 0 and 18."));
        assertTrue(output.contains("That position is occupied. Try again."));
        assertTrue(output.contains("Board is full!"));
    }

    private String runGame(String input) {
        ByteArrayOutputStream capturedOutput = new ByteArrayOutputStream();
        PrintStream testOutput =
                new PrintStream(capturedOutput, true, StandardCharsets.UTF_8);
        Game game = new Game(new Scanner(input), testOutput);

        game.start();

        return capturedOutput.toString(StandardCharsets.UTF_8);
    }
}