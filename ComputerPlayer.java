import java.util.Random;

/** A simple computer player: wins if it can, blocks if it must, otherwise picks randomly. */
public class ComputerPlayer extends Player {
    private final Random random = new Random();

    public ComputerPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public int chooseMove(Board board) {
        char opponent = (getSymbol() == 'X') ? 'O' : 'X';

        // 1. Can I win with one move?
        int move = findWinningMove(board, getSymbol());
        if (move != -1) return report(move);

        // 2. Must I block the opponent?
        move = findWinningMove(board, opponent);
        if (move != -1) return report(move);

        // 3. Otherwise pick a random empty cell
        do {
            move = random.nextInt(9) + 1;
        } while (!board.isCellEmpty(move));
        return report(move);
    }

    /** Try every empty cell and see whether placing 'symbol' there wins. */
    private int findWinningMove(Board board, char symbol) {
        for (int p = 1; p <= 9; p++) {
            if (board.isCellEmpty(p)) {
                board.place(p, symbol);          // try it
                boolean wins = board.hasWon(symbol);
                board.place(p, ' ');             // undo it
                if (wins) return p;
            }
        }
        return -1;
    }

    private int report(int move) {
        System.out.println(getName() + " plays " + move);
        return move;
    }
}
