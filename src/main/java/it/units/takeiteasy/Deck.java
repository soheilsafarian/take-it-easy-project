package it.units.takeiteasy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private static final int[] HORIZONTAL_VALUES = {1, 5, 9};
    private static final int[] DIAGONAL_LEFT_VALUES = {2, 6, 7};
    private static final int[] DIAGONAL_RIGHT_VALUES = {3, 4, 8};

    private final List<Tile> tiles;

    public Deck() {
        tiles = new ArrayList<>();
        generateAllTiles();
        shuffle();
    }

    private void generateAllTiles() {

        for (int v : HORIZONTAL_VALUES) {
            for (int dl : DIAGONAL_LEFT_VALUES) {
                for (int dr : DIAGONAL_RIGHT_VALUES) {

                    tiles.add(new Tile(v, dl, dr));
                }
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(tiles);
    }

    public boolean isEmpty() {
        return tiles.isEmpty();
    }

    public Tile drawTile() {

        if (tiles.isEmpty()) {
            return null;
        }

        return tiles.remove(0);
    }

    public int size() {
        return tiles.size();
    }
}