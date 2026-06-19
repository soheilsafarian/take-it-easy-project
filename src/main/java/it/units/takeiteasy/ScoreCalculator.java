package it.units.takeiteasy;

import java.util.function.Function;

public class ScoreCalculator {

    private static final int[][] HORIZONTAL_LINES = {
            {0, 1, 2},
            {3, 4, 5, 6},
            {7, 8, 9, 10, 11},
            {12, 13, 14, 15},
            {16, 17, 18}
    };

    private static final int[][] DIAGONAL_LEFT_LINES = {
            {0, 3, 7},
            {1, 4, 8, 12},
            {2, 5, 9, 13, 16},
            {6, 10, 14, 17},
            {11, 15, 18}
    };

    private static final int[][] DIAGONAL_RIGHT_LINES = {
            {2, 6, 11},
            {1, 5, 10, 15},
            {0, 4, 9, 14, 18},
            {3, 8, 13, 17},
            {7, 12, 16}
    };

    public int calculate(Board board) {

        int score = 0;

        for (int[] line : HORIZONTAL_LINES) {
            score += scoreLine(board, line, Tile::getHorizontal);
        }

        for (int[] line : DIAGONAL_LEFT_LINES) {
            score += scoreLine(board, line, Tile::getDiagonalLeft);
        }

        for (int[] line : DIAGONAL_RIGHT_LINES) {
            score += scoreLine(board, line, Tile::getDiagonalRight);
        }

        return score;
    }

    private int scoreLine(Board board,
                          int[] positions,
                          Function<Tile, Integer> valueExtractor) {

        Tile first = board.getTile(positions[0]);

        if (first == null) {
            return 0;
        }

        int value = valueExtractor.apply(first);

        for (int pos : positions) {

            Tile tile = board.getTile(pos);

            if (tile == null) {
                return 0;
            }

            if (!valueExtractor.apply(tile).equals(value)) {
                return 0;
            }
        }

        return value * positions.length;
    }
}