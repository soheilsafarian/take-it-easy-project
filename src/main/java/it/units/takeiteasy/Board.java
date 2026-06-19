package it.units.takeiteasy;

public class Board {

    public static final int BOARD_SIZE = 19;

    private final Tile[] cells;

    public Board() {
        this.cells = new Tile[BOARD_SIZE];
    }

    private boolean isValidPosition(int position) {
        return position >= 0 && position < BOARD_SIZE;
    }

    public boolean placeTile(int position, Tile tile) {

        if (!isValidPosition(position)) {
            return false;
        }

        if (cells[position] != null) {
            return false;
        }

        cells[position] = tile;
        return true;
    }

    public Tile getTile(int position) {

        if (!isValidPosition(position)) {
            return null;
        }

        return cells[position];
    }

    public boolean isFull() {

        for (Tile tile : cells) {
            if (tile == null) {
                return false;
            }
        }

        return true;
    }
}