import java.util.Scanner;

/** Starts the game: choose two players or play against the computer. */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Tic-Tac-Toe ===");
        System.out.println("1. Two players");
        System.out.println("2. Play against computer");
        System.out.print("Choice: ");
        String mode = sc.next();

        Player p1 = new HumanPlayer("Player 1", 'X', sc);
        Player p2;
        if (mode.equals("2")) {
            p2 = new ComputerPlayer("Computer", 'O');
        } else {
            p2 = new HumanPlayer("Player 2", 'O', sc);
        }

        Game game = new Game(p1, p2);
        String again;
        do {
            game.playRound();
            game.printScore();
            System.out.print("Play again? (y/n): ");
            again = sc.next();
        } while (again.equalsIgnoreCase("y"));

        System.out.println("Thanks for playing!");
        sc.close();
    }
}
