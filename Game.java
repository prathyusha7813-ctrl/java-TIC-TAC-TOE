/** Runs one round of Tic-Tac-Toe between two players. */
public class Game {
    private final Board board = new Board();
    private final Player player1;
    private final Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void playRound() {
        board.reset();
        Player current = player1;
        Board.displayGuide();

        while (true) {
            int move = current.chooseMove(board);
            board.place(move, current.getSymbol());
            board.display();

            if (board.hasWon(current.getSymbol())) {
                System.out.println(current.getName() + " wins!");
                current.addWin();
                return;
            }
            if (board.isFull()) {
                System.out.println("It's a draw!");
                return;
            }
            current = (current == player1) ? player2 : player1;   // switch turns
        }
    }

    public void printScore() {
        System.out.println("Score -> " + player1.getName() + ": " + player1.getWins()
                + " | " + player2.getName() + ": " + player2.getWins());
    }
}
