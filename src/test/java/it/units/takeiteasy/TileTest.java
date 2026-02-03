package it.units.takeiteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {

    @Test
    void tileStoresValuesCorrectly() {
        Tile tile = new Tile(5, 1, 9);

        assertEquals(5, tile.getHorizontal());
        assertEquals(1, tile.getDiagonalLeft());
        assertEquals(9, tile.getDiagonalRight());
    }

    @Test
    void tileToStringIsReadable() {
        Tile tile = new Tile(5, 1, 9);

        assertEquals("[5|1|9]", tile.toString());
    }
}