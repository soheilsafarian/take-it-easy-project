package it.units.takeiteasy;

import java.util.Scanner;

public class Game {

    private final Board board;
    private final Deck deck;
    private final BoardPrinter printer;
    private final ScoreCalculator calculator;
    private final Scanner scanner;

    public Game() {
        this(new Scanner(System.in));
    }

    public Game(Scanner scanner) {
        this.board = new Board();
        this.deck = new Deck();
        this.printer = new BoardPrinter();
        this.calculator = new ScoreCalculator();
        this.scanner = scanner;
    }

    public void start() {

        System.out.println("=== Welcome to Take It Easy ===");

        while (!board.isFull() && !deck.isEmpty()) {

            Tile currentTile = deck.drawTile();

            boolean placed = false;

            while (!placed) {

                System.out.println("\nYour tile is: " + currentTile);

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

        System.out.println("\n=== GAME OVER ===");

        if (board.isFull()) {
            System.out.println("Board is full!");
        } else {
            System.out.println("No more tiles available!");
        }

        printer.print(board);

        int finalScore = calculator.calculate(board);

        System.out.println("\n🎯 Final Score: " + finalScore);
        System.out.println("Thanks for playing!");
    }

    private int askPosition() {

        while (true) {

            System.out.print("Choose position (0-18): ");

            if (!scanner.hasNextInt()) {
                System.out.println("❌ Please enter a number!");
                scanner.next();
                continue;
            }

            int pos = scanner.nextInt();

            if (pos < 0 || pos >= Board.BOARD_SIZE) {
                System.out.println("❌ Position must be between 0 and 18.");
                continue;
            }

            return pos;
        }
    }
}