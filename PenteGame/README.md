# Java
This repository will store java projects, functions, etc...
In the Pente game it is similar to 3 in a row, only a little more complex. In which a 10x10 board will be created up to 19X19, both included.
And we will have to configure the number of capture chips that we want to win, ranging from 5 to 10 chips.

Players can capture opponent's tiles by placing their own tiles on either side of a pair of opponent's tiles (exactly two tiles). For example, if the checkers are placed in the position 'X O O _' and it is X's turn and he places his checker so that it is 'X O O X', both player O's checkers would be captured: 'X _ _ X'. This can occur in any direction on the board. In addition, in the same roll, more than two pieces could be captured if we achieve simultaneous captures in various directions on the board.

The game ends in one of the following circumstances:

- When a player gets 5 tiles in a row (horizontal, vertical or diagonal) they win the game.
- When a player captures a number of the opponent's tiles, they win the game.
- When there are no more free cells, it is a tie.
