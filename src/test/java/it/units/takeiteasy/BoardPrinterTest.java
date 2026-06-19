package it.units.takeiteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardPrinterTest {

    @Test
    void emptyBoardShowsPositions() {

        Board board = new Board();
        BoardPrinter printer = new BoardPrinter();

        String output = printer.buildBoard(board);

        assertTrue(output.contains("[ 00 ]"));
        assertTrue(output.contains("[ 18 ]"));
    }

    @Test
    void placedTileIsDisplayed() {

        Board board = new Board();

        board.placeTile(0, new Tile(5, 6, 7));

        BoardPrinter printer = new BoardPrinter();

        String output = printer.buildBoard(board);

        assertTrue(output.contains("[5|6|7]"));
    }
}