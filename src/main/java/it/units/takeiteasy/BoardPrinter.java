package it.units.takeiteasy;

public class BoardPrinter {

    private static final int[][] BOARD_LAYOUT = {
            {0, 1, 2},
            {3, 4, 5, 6},
            {7, 8, 9, 10, 11},
            {12, 13, 14, 15},
            {16, 17, 18}
    };

    private static final int MAX_COLUMNS = 5;
    private static final String CELL_SPACING = "  ";

    public void print(Board board) {
        System.out.println(buildBoard(board));
    }

    public String buildBoard(Board board) {

        StringBuilder sb = new StringBuilder();

        sb.append("Current Board:\n\n");

        for (int[] row : BOARD_LAYOUT) {

            int missingCells = MAX_COLUMNS - row.length;

            sb.append(" ".repeat(missingCells * 4));

            for (int position : row) {

                Tile tile = board.getTile(position);

                if (tile == null) {
                    sb.append(String.format("[ %02d ]", position));
                } else {
                    sb.append(tile);
                }

                sb.append(CELL_SPACING);
            }

            sb.append("\n\n");
        }

        return sb.toString();
    }
}