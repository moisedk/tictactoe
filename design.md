# Design
## Main classes:
### Grid class
* Represent the game grid. 
* Capable of handling click event, knowing click position (coordinates)
* Capable of changing its background and its line separation (borders)
* Capable of drawing player-specific mark on the surface: X and O 
### Game logic class
* Represents the game logic.
* Knows how to initialize a grid.
* Knows players and how to choose a starter.
* Knows how to end the game and determine the result of the game. 
### Main 
* Represent the entry point of the game.
* Know how to enter and exit the game loop. 