package it.units.takeiteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void deckStartsWith27Tiles() {

        Deck deck = new Deck();

        assertEquals(27, deck.size());
    }

    @Test
    void drawingTileReducesDeckSize() {

        Deck deck = new Deck();

        Tile tile = deck.drawTile();

        assertNotNull(tile);
        assertEquals(26, deck.size());
    }

    @Test
    void deckBecomesEmptyAfter27Draws() {

        Deck deck = new Deck();

        for (int i = 0; i < 27; i++) {
            deck.drawTile();
        }

        assertTrue(deck.isEmpty());
    }
}