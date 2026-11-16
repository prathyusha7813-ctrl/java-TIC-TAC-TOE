/** The 3x3 game board. */
public class Board {
    private final char[][] cells = new char[3][3];

    public Board() {
        reset();
    }

    /** Fill every cell with a space (empty). */
    public void reset() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                cells[r][c] = ' ';
            }
        }
    }

    /** Positions are numbered 1-9, left to right, top to bottom. */
    public boolean isCellEmpty(int position) {
        if (position < 1 || position > 9) return false;
        return cells[(position - 1) / 3][(position - 1) % 3] == ' ';
    }

    public void place(int position, char symbol) {
        cells[(position - 1) / 3][(position - 1) % 3] = symbol;
    }

    public boolean isFull() {
        for (int p = 1; p <= 9; p++) {
            if (isCellEmpty(p)) return false;
        }
        return true;
    }

    /** True if the given symbol has three in a row, column or diagonal. */
    public boolean hasWon(char s) {
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] == s && cells[i][1] == s && cells[i][2] == s) return true;  // row
            if (cells[0][i] == s && cells[1][i] == s && cells[2][i] == s) return true;  // column
        }
        if (cells[0][0] == s && cells[1][1] == s && cells[2][2] == s) return true;      // diagonal
        return cells[0][2] == s && cells[1][1] == s && cells[2][0] == s;                // diagonal
    }

    public void display() {
        System.out.println();
        for (int r = 0; r < 3; r++) {
            System.out.println(" " + cells[r][0] + " | " + cells[r][1] + " | " + cells[r][2]);
            if (r < 2) System.out.println("---+---+---");
        }
        System.out.println();
    }

    /** Show the numbers 1-9 so players know which cell is which. */
    public static void displayGuide() {
        System.out.println(" 1 | 2 | 3");
        System.out.println("---+---+---");
        System.out.println(" 4 | 5 | 6");
        System.out.println("---+---+---");
        System.out.println(" 7 | 8 | 9");
    }
}
