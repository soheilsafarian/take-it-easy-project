package it.units.takeiteasy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private final List<Tile> tiles;

    public Deck() {
        tiles = new ArrayList<>();
        generateAllTiles();
        shuffle();
    }

    private void generateAllTiles() {

        int[] horizontals = {1, 5, 9};
        int[] diagonalLefts = {2, 6, 10};
        int[] diagonalRights = {3, 7, 11};

        for (int h : horizontals) {
            for (int dl : diagonalLefts) {
                for (int dr : diagonalRights) {

                    tiles.add(new Tile(h, dl, dr));
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