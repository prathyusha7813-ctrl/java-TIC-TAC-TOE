import java.util.Scanner;

/** A player who types the move on the keyboard. */
public class HumanPlayer extends Player {
    private final Scanner scanner;

    public HumanPlayer(String name, char symbol, Scanner scanner) {
        super(name, symbol);
        this.scanner = scanner;
    }

    @Override
    public int chooseMove(Board board) {
        while (true) {
            System.out.print(getName() + " (" + getSymbol() + "), enter position 1-9: ");
            String input = scanner.next();
            try {
                int position = Integer.parseInt(input);
                if (board.isCellEmpty(position)) {
                    return position;
                }
                System.out.println("That cell is not available. Try again.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number from 1 to 9.");
            }
        }
    }
}
