package it.units.takeiteasy;

public class Tile {

    private final int horizontal;
    private final int diagonalLeft;
    private final int diagonalRight;

    public Tile(int horizontal, int diagonalLeft, int diagonalRight) {
        this.horizontal = horizontal;
        this.diagonalLeft = diagonalLeft;
        this.diagonalRight = diagonalRight;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public int getDiagonalLeft() {
        return diagonalLeft;
    }

    public int getDiagonalRight() {
        return diagonalRight;
    }

    @Override
    public String toString() {
        return "[" + horizontal + "|" + diagonalLeft + "|" + diagonalRight + "]";
    }
}