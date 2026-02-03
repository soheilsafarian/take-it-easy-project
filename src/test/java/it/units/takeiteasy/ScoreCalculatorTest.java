package it.units.takeiteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreCalculatorTest {

    @Test
    void completeHorizontalLineGivesPoints() {

        Board board = new Board();

        // خط افقی اول کامل: {0,1,2}
        board.placeTile(0, new Tile(5, 1, 9));
        board.placeTile(1, new Tile(5, 2, 7));
        board.placeTile(2, new Tile(5, 6, 8));

        ScoreCalculator calc = new ScoreCalculator();

        // امتیاز = 5 * 3 = 15
        assertEquals(15, calc.calculate(board));
    }

    @Test
    void incompleteLineGivesZeroPoints() {

        Board board = new Board();

        board.placeTile(0, new Tile(5, 1, 9));
        board.placeTile(1, new Tile(5, 2, 7));
        // خانه 2 خالی

        ScoreCalculator calc = new ScoreCalculator();

        assertEquals(0, calc.calculate(board));
    }

    @Test
    void completeDiagonalLeftLineGivesPoints() {

        Board board = new Board();

        // خط مورب چپ اول: {0,3,7}
        board.placeTile(0, new Tile(5, 9, 1));
        board.placeTile(3, new Tile(2, 9, 7));
        board.placeTile(7, new Tile(4, 9, 8));

        ScoreCalculator calc = new ScoreCalculator();

        // امتیاز = 9 * 3 = 27
        assertEquals(27, calc.calculate(board));
    }
    @Test
    void completeDiagonalRightLineGivesPoints() {

        Board board = new Board();

        // خط مورب راست اول: {2,6,11}
        board.placeTile(2, new Tile(5, 1, 7));
        board.placeTile(6, new Tile(3, 2, 7));
        board.placeTile(11, new Tile(9, 6, 7));

        ScoreCalculator calc = new ScoreCalculator();

        // امتیاز = 7 * 3 = 21
        assertEquals(21, calc.calculate(board));
    }
}
