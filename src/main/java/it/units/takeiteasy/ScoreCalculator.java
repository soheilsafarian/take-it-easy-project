package it.units.takeiteasy;

public class ScoreCalculator {

    // خطوط افقی
    private static final int[][] HORIZONTAL_LINES = {
            {0, 1, 2},
            {3, 4, 5, 6},
            {7, 8, 9, 10, 11},
            {12, 13, 14, 15},
            {16, 17, 18}
    };

    // خطوط مورب چپ ↙
    private static final int[][] DIAGONAL_LEFT_LINES = {
            {0, 3, 7},
            {1, 4, 8, 12},
            {2, 5, 9, 13, 16},
            {6, 10, 14, 17},
            {11, 15, 18}
    };

    // خطوط مورب راست ↘
    private static final int[][] DIAGONAL_RIGHT_LINES = {
            {2, 6, 11},
            {1, 5, 10, 15},
            {0, 4, 9, 14, 18},
            {3, 8, 13, 17},
            {7, 12, 16}
    };

    public int calculate(Board board) {

        int score = 0;

        // امتیاز افقی
        for (int[] line : HORIZONTAL_LINES) {
            score += scoreHorizontalLine(board, line);
        }

        // امتیاز مورب چپ
        for (int[] line : DIAGONAL_LEFT_LINES) {
            score += scoreDiagonalLeftLine(board, line);
        }

        // امتیاز مورب راست
        for (int[] line : DIAGONAL_RIGHT_LINES) {
            score += scoreDiagonalRightLine(board, line);
        }

        return score;
    }

    // -----------------------------
    // Horizontal scoring
    private int scoreHorizontalLine(Board board, int[] positions) {

        Tile first = board.getTile(positions[0]);
        if (first == null) return 0;

        int value = first.getHorizontal();

        for (int pos : positions) {
            Tile tile = board.getTile(pos);

            if (tile == null) return 0;
            if (tile.getHorizontal() != value) return 0;
        }

        return value * positions.length;
    }

    // -----------------------------
    // Diagonal Left scoring
    private int scoreDiagonalLeftLine(Board board, int[] positions) {

        Tile first = board.getTile(positions[0]);
        if (first == null) return 0;

        int value = first.getDiagonalLeft();

        for (int pos : positions) {
            Tile tile = board.getTile(pos);

            if (tile == null) return 0;
            if (tile.getDiagonalLeft() != value) return 0;
        }

        return value * positions.length;
    }

    // -----------------------------
    // Diagonal Right scoring
    private int scoreDiagonalRightLine(Board board, int[] positions) {

        Tile first = board.getTile(positions[0]);
        if (first == null) return 0;

        int value = first.getDiagonalRight();

        for (int pos : positions) {
            Tile tile = board.getTile(pos);

            if (tile == null) return 0;
            if (tile.getDiagonalRight() != value) return 0;
        }

        return value * positions.length;
    }
}