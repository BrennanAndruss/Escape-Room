/*
* Problem 1: Escape Room
* 
* V1.0
* 10/10/2019
* Copyright(c) 2019 PLTW to present. All rights reserved
*/
import java.util.Scanner;

/**
 * Create an escape room game where the player must navigate
 * to the other side of the screen in the fewest steps, while
 * avoiding obstacles and collecting prizes.
 */
public class EscapeRoom
{

      // describe the game with brief welcome message
      // determine the size (length and width) a player must move to stay within the grid markings
      // Allow game commands:
      //    right, left, up, down: if you try to go off grid or bump into wall, score decreases
      //    jump over 1 space: you cannot jump over walls
      //    if you land on a trap, spring a trap to increase score: you must first check if there is a trap, if none exists, penalty
      //    pick up prize: score increases, if there is no prize, penalty
      //    help: display all possible commands
      //    end: reach the far right wall, score increase, game ends, if game ended without reaching far right wall, penalty
      //    replay: shows number of player steps and resets the board, you or another player can play the same board
      // Note that you must adjust the score with any method that returns a score
      // Optional: create a custom image for your player use the file player.png on disk
    
      /**** provided code:
      // set up the game
      boolean play = true;
      while (play)
      {
        // get user input and call game methods to play 
        play = false;
      }
      */

  public static void main(String[] args) 
  {      
    // welcome message
    System.out.println("Welcome to EscapeRoom!");
    System.out.println("Get to the other side of the room, avoiding walls and invisible traps,");
    System.out.println("pick up all the prizes.\n");
    
    GameGUI game = new GameGUI();
    game.createBoard();

    // size of move
    int m = 60; 
    // individual player moves
    int px = 0;
    int py = 0; 
    
    int score = 0;

    Scanner in = new Scanner(System.in);
    String[] validCommands = { "right", "left", "up", "down", "r", "l", "u", "d",
    "jumpright", "jr", "jumpleft", "jl", "jumpup", "ju", "jumpdown", "jd",
    "pickup", "p", "quit", "q", "replay", "help", "?"};
  
    // set up game
    boolean play = true;
    UserInput ui = new UserInput();
    while (play)
    {
      /* TODO: get all the commands working */
	    /* Your code here */
      
      String cmd = ui.getValidInput(validCommands);

      // Move commands
      if(cmd.equals(validCommands[0]) || cmd.equals(validCommands[4]))
      {
        // move right
        game.movePlayer(60, 0);
      }
      else if (cmd.equals(validCommands[1]) || cmd.equals(validCommands[5]))
      {
        // move left
        game.movePlayer(-60, 0);
      }
      else if (cmd.equals(validCommands[2]) || cmd.equals(validCommands[6]))
      {
        // move up
        game.movePlayer(0, -60);
      }
      else if (cmd.equals(validCommands[3]) || cmd.equals(validCommands[7]))
      {
        // move down
        game.movePlayer(0, 60);
      }
      else if(cmd.equals(validCommands[8]) || cmd.equals(validCommands[9]))
      {
        // jump right
        game.movePlayer(120, 0);
      }
      else if (cmd.equals(validCommands[10]) || cmd.equals(validCommands[11]))
      {
        // jump left
        game.movePlayer(-120, 0);
      }
      else if (cmd.equals(validCommands[12]) || cmd.equals(validCommands[13]))
      {
        // jump up
        game.movePlayer(0, -120);
      }
      else if (cmd.equals(validCommands[14]) || cmd.equals(validCommands[15]))
      {
        // jump down
        game.movePlayer(0, 120);
      }
      
      // Score fuctions
      if(cmd.equals(validCommands[16]) || cmd.equals(validCommands[17]))
      {
        score += game.pickupPrize();
      }
    }

  

    score += game.endGame();

    System.out.println("score=" + score);
    System.out.println("steps=" + game.getSteps());
  }
}

        