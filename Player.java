/** Base class for any player (abstract: each kind of player picks moves differently). */
public abstract class Player {
    private final String name;
    private final char symbol;
    private int wins = 0;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName()  { return name; }
    public char getSymbol()  { return symbol; }
    public int getWins()     { return wins; }
    public void addWin()     { wins++; }

    /** Returns a position from 1 to 9 that is empty on the board. */
    public abstract int chooseMove(Board board);
}
