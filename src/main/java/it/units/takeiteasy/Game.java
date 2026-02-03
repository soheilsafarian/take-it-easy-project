package it.units.takeiteasy;

import java.util.Scanner;

public class Game {

    private final Board board;
    private final Deck deck;
    private final BoardPrinter printer;
    private final ScoreCalculator calculator;
    private final Scanner scanner;

    public Game() {
        board = new Board();
        deck = new Deck();
        printer = new BoardPrinter();
        calculator = new ScoreCalculator();
        scanner = new Scanner(System.in);
    }

    public void start() {

        System.out.println("=== Welcome to Take It Easy ===");

        // Game loop
        while (!board.isFull() && !deck.isEmpty()) {

            // Draw ONE tile
            Tile currentTile = deck.drawTile();

            boolean placed = false;

            // Keep asking until the tile is placed correctly
            while (!placed) {

                System.out.println("\nYour tile is: " + currentTile);

                System.out.println("Current Board:");
                printer.print(board);

                int position = askPosition();

                if (board.placeTile(position, currentTile)) {
                    System.out.println("✅ Tile placed successfully!");
                    placed = true;
                } else {
                    System.out.println("❌ That position is occupied. Try again.");
                }
            }
        }

        // GAME OVER
        System.out.println("\n=== GAME OVER ===");
        System.out.println("Board is full!");

        printer.print(board);

        int finalScore = calculator.calculate(board);

        System.out.println("\n🎯 Final Score: " + finalScore);
        System.out.println("Thanks for playing!");
    }

    // Ask user for a valid position
    private int askPosition() {

        while (true) {

            System.out.print("Choose position (0-18): ");

            if (!scanner.hasNextInt()) {
                System.out.println("❌ Please enter a number!");
                scanner.next();
                continue;
            }

            int pos = scanner.nextInt();

            if (pos < 0 || pos > 18) {
                System.out.println("❌ Position must be between 0 and 18.");
                continue;
            }

            return pos;
        }
    }
}