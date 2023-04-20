/* Developed By: Arya Faghihy
 * Date: Mar 18, 2022
 * Version     : 1.0 */

import java.util.Scanner;

public class TictactoeMain
{   
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      Tictactoe t = new Tictactoe();
      
      boolean gameover = false;
      boolean isSuccess = false;
      int row, col;
      char activePlayer;
      
      do 
      {
         // Asks who wants to start first
         System.out.print("Who starts first? (X/O): ");
         activePlayer = input.next().charAt(0);
         if( activePlayer == 'X' || activePlayer == 'x' )
         {
            t.SetActivePlayer(Tictactoe.PLAYER_X);
         }
         else if ( activePlayer == 'O' || activePlayer == 'o' )
         {
            t.SetActivePlayer(Tictactoe.PLAYER_O);
         }
         else
         {
            System.out.println("Invalid input. Type again.");
         }
      }while(activePlayer != 'X' && activePlayer != 'x' && activePlayer != 'O' && activePlayer != 'o' );
      
      // Start the game
      while(!gameover)
      {
         t.DisplayGrid();
         
         do
         {
            System.out.println(t.GetActivePlayerName());
            System.out.print("Select row: ");
            row = input.nextInt();
            System.out.print("Select column: ");
            col = input.nextInt();
            // Check if the entered row and column is valid. If not, then it will repeat.
            isSuccess = t.SetPlayerOnGrid(row, col, t.GetActivePlayer());
            if( !isSuccess ) 
            {
               System.out.println("row " + row + " column " + col + " is occupied or unavailable. Select again.");
            }
         } while( !isSuccess );
         
         // Selected the block to place the Player's mark. Then check if the player wins
         if( t.IsPlayerWin() )
         {
            break;
         }
         
         // Switch to next player
         t.SwitchPlayer();
      }
      
      // Displays the winner
      t.DisplayGrid();
      System.out.println("Winner is " + t.GetActivePlayerName() );
      
      input.close();
   }
}