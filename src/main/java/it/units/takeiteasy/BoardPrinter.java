package it.units.takeiteasy;

public class BoardPrinter {

    public void print(Board board) {
        System.out.println("Current Board:");

        for (int i = 0; i < 19; i++) {
            Tile tile = board.getTile(i);

            if (tile == null) {
                System.out.print("[   ] ");
            } else {
                System.out.print(tile + " ");
            }

            if (i == 2 || i == 6 || i == 11 || i == 15) {
                System.out.println();
            }
        }

        System.out.println();
    }
}