# Tic-Tac-Toe (Java)

A console Tic-Tac-Toe game built with **Object-Oriented Programming** in Java. Play with a friend or against a simple computer player.

## Features
- Two-player mode and play-against-computer mode
- Computer wins when it can, blocks your winning move, otherwise plays randomly
- Input validation (rejects letters, numbers outside 1-9 and taken cells)
- Detects win and draw, keeps a score across rounds
- Play again option

## OOP concepts used
| Concept | Where |
|---|---|
| Abstract class | `Player` |
| Inheritance | `HumanPlayer`, `ComputerPlayer` extend `Player` |
| Polymorphism | `chooseMove()` works differently for each player type |
| Encapsulation | private fields with getters in `Board` and `Player` |
| Static method | `Board.displayGuide()` |
| Exception handling | `NumberFormatException` in `HumanPlayer` |

## Project structure
```
Board.java           (3x3 grid, win and draw checks)
Player.java          (abstract base class)
HumanPlayer.java     (reads moves from the keyboard)
ComputerPlayer.java  (automatic moves)
Game.java            (one round, turn switching, score)
Main.java            (menu and game loop)
```

## How to run
```bash
javac *.java
java Main
```

## Sample output
```
 1 | 2 | 3
---+---+---
 4 | 5 | 6
---+---+---
 7 | 8 | 9
Player 1 (X), enter position 1-9: 5

   |   |
---+---+---
   | X |
---+---+---
   |   |
```

## Future improvements
- Add an unbeatable computer using the Minimax algorithm
- Let players choose a larger board (4x4)
- Add a Swing GUI
