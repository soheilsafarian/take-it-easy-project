package it.units.takeiteasy;

public class Board {

    private final Tile[] cells;

    public Board() {
        this.cells = new Tile[19];
    }

    public boolean placeTile(int position, Tile tile) {
        if (position < 0 || position >= 19) {
            return false;
        }
        if (cells[position] != null) {
            return false;
        }
        cells[position] = tile;
        return true;
    }

    public Tile getTile(int position) {
        return cells[position];
    }

    public boolean isFull() {
        for (Tile t : cells) {
            if (t == null) return false;
        }
        return true;
    }
}