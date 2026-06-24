package it.units.takeiteasy;

import java.io.PrintStream;
import java.util.Scanner;

public class Game {

    private final Board board;
    private final Deck deck;
    private final BoardPrinter printer;
    private final ScoreCalculator calculator;
    private final Scanner scanner;
    private final PrintStream output;

    public Game() {
        this(new Scanner(System.in), System.out);
    }

    public Game(Scanner scanner, PrintStream output) {
        this.board = new Board();
        this.deck = new Deck();
        this.printer = new BoardPrinter();
        this.calculator = new ScoreCalculator();
        this.scanner = scanner;
        this.output = output;
    }

    public void start() {

        output.println("=== Welcome to Take It Easy ===");

        while (!board.isFull() && !deck.isEmpty()) {

            Tile currentTile = deck.drawTile();

            boolean placed = false;

            while (!placed) {

                output.println("\nYour tile is: " + currentTile);

                output.println(printer.buildBoard(board));

                int position = askPosition();

                if (board.placeTile(position, currentTile)) {
                    output.println("✅ Tile placed successfully!");
                    placed = true;
                } else {
                    output.println("❌ That position is occupied. Try again.");
                }
            }
        }

        output.println("\n=== GAME FINISHED ===");

        if (board.isFull()) {
            output.println("Board is full!");
        } else {
            output.println("No more tiles available!");
        }

        output.println(printer.buildBoard(board));

        int finalScore = calculator.calculate(board);

        output.println("\n🎯 Final Score: " + finalScore);
        output.println("Thanks for playing!");
    }

    private int askPosition() {

        while (true) {

            output.print("Choose position (0-18): ");

            if (!scanner.hasNextInt()) {
                output.println("❌ Please enter a number!");
                scanner.next();
                continue;
            }

            int pos = scanner.nextInt();

            if (pos < 0 || pos >= Board.BOARD_SIZE) {
                output.println("❌ Position must be between 0 and 18.");
                continue;
            }

            return pos;
        }
    }
}