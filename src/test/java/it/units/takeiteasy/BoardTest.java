package it.units.takeiteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void canPlaceTileInEmptyCell() {
        Board board = new Board();
        Tile tile = new Tile(5, 1, 9);

        assertTrue(board.placeTile(0, tile));
        assertEquals(tile, board.getTile(0));
    }

    @Test
    void cannotPlaceTileInOccupiedCell() {
        Board board = new Board();
        Tile tile1 = new Tile(5, 1, 9);
        Tile tile2 = new Tile(3, 2, 7);

        assertTrue(board.placeTile(0, tile1));
        assertFalse(board.placeTile(0, tile2));
    }

    @Test
    void boardIsNotFullAtStart() {
        Board board = new Board();
        assertFalse(board.isFull());
    }
}