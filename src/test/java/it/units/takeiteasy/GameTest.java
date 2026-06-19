package it.units.takeiteasy;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void gameCanBeCreatedWithDefaultConstructor() {

        Game game = new Game();

        assertNotNull(game);
    }

    @Test
    void gameCanBeCreatedWithCustomScanner() {

        Scanner scanner = new Scanner("0\n");

        Game game = new Game(scanner);

        assertNotNull(game);
    }
}