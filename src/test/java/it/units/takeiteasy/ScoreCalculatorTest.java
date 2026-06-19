package it.units.takeiteasy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreCalculatorTest {

    static Stream<TestCase> scoringCases() {
        return Stream.of(

                new TestCase(board -> {
                    board.placeTile(0, new Tile(5, 1, 9));
                    board.placeTile(1, new Tile(5, 2, 7));
                    board.placeTile(2, new Tile(5, 6, 8));
                }, 15),

                new TestCase(board -> {
                    board.placeTile(0, new Tile(5, 9, 1));
                    board.placeTile(3, new Tile(2, 9, 7));
                    board.placeTile(7, new Tile(4, 9, 8));
                }, 27),

                new TestCase(board -> {
                    board.placeTile(2, new Tile(5, 1, 7));
                    board.placeTile(6, new Tile(3, 2, 7));
                    board.placeTile(11, new Tile(9, 6, 7));
                }, 21)
        );
    }

    @ParameterizedTest
    @MethodSource("scoringCases")
    void completedLinesGiveCorrectScore(TestCase testCase) {

        Board board = new Board();

        testCase.setup.accept(board);

        ScoreCalculator calc = new ScoreCalculator();

        assertEquals(testCase.expectedScore, calc.calculate(board));
    }

    @Test
    void incompleteLineGivesZeroPoints() {

        Board board = new Board();

        board.placeTile(0, new Tile(5, 1, 9));
        board.placeTile(1, new Tile(5, 2, 7));

        ScoreCalculator calc = new ScoreCalculator();

        assertEquals(0, calc.calculate(board));
    }

    private record TestCase(
            java.util.function.Consumer<Board> setup,
            int expectedScore
    ) {}
}