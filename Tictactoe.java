/* Developed By: Arya Faghihy
 * Date: Mar 18, 2022
 * Version     : 1.0 */

public class Tictactoe 
{
   // Constant variables. Used by the whole program.
   public final static int EMPTY = 0;
   public final static int PLAYER_X = 1;
   public final static int PLAYER_O = 2;
   
   private int grid[][];       // The Tic-Tac-Toe grid
   private int activePlayer;   /* Keeps track of the current active player. 
                                * Either 1 or 2. 1 is Player X and 2 is Player 2 */
   
   public Tictactoe()
   {
      this.grid = new int[3][3];
      
      for( int i = 0; i < this.grid.length; i++ )
      {
         for( int j = 0; j < this.grid.length; j++ )
         {
            this.grid[i][j] = Tictactoe.EMPTY;
         }
      }
      
      this.activePlayer = Tictactoe.PLAYER_X;
   }
  
   //================== PUBLIC METHOD ===================//
   public void DisplayGrid()
   {
      System.out.println("         COLUMN   ");
      System.out.println("       1   2   3");
      System.out.println("     -------------");
      for( int row = 0; row < this.grid.length; row++ )
      {
         if( row == 1 )
         {
            System.out.print("ROW " + (row + 1));
         }
         else
         {
            System.out.print("    " + (row + 1) );
         }
         
         System.out.print("|");
         for( int col = 0; col < this.grid.length; col++ )
         {
            System.out.print(" ");
            if( this.grid[row][col] == Tictactoe.EMPTY ) 
            {
               System.out.print(" ");
            }
            else if( this.grid[row][col] == Tictactoe.PLAYER_X )
            {
               System.out.print("X");
            }
            else if( this.grid[row][col] == Tictactoe.PLAYER_O )
            {
               System.out.print("O");
            }    
            
            System.out.print(" ");
            System.out.print("|");
         }
         System.out.println("");
         System.out.println("     -------------");
      }      
   }
   
   /* Checks if it is empty at (row, col) and if it is empty,
    * it will assign player x to (row, col)
    * 
    * @param row - The row that the players want to assign the X to
    * @param col - the column that the player wants to assign the X to */
   public boolean SetPlayerX(int row, int col)
   {
      if( this.grid[row][col] == Tictactoe.EMPTY )
      {
         this.grid[row][col] = Tictactoe.PLAYER_X;
         return true;
      }
      else
      {
         return false;
      }
   }
   
   /* Checks if it is empty at (row, col) and if it is empty,
    * it will assign player to (row, col)
    * 
    * @param row - The row that the players want to assign the X or O to
    * @param col - the column that the player wants to assign the X or O to 
    * @return    - return true if the block is empty. Else return false */
   public boolean SetPlayerOnGrid(int row, int col, int player)
   {
      if( (row >= 1 && row <= 3) && (col >= 1 && col <= 3) )
      {
         if( this.grid[row - 1][col - 1] == Tictactoe.EMPTY )
         {
            this.grid[row - 1][col - 1] = player;
            return true;
         }
      }
      
      return false;
   } 
   
   /* Switch the active player */
   public void SwitchPlayer()
   {
      if( this.activePlayer == Tictactoe.PLAYER_X )
      {
         this.activePlayer = Tictactoe.PLAYER_O;
      }
      else
      {
         this.activePlayer = Tictactoe.PLAYER_X;
      }
   }
   
   /* Get the current active player who is selecting
    * in the grid
    * 
    * @return - 1 if it is Player X or 2 if it is Player O */
   public int GetActivePlayer()
   {
      return this.activePlayer;
   }
   
   /* Get the current active player name
    * 
    @return - The String name of the current active player */
   public String GetActivePlayerName()
   {
      if( this.activePlayer == Tictactoe.PLAYER_X )
      {
         return "Player X";
      }
      else
      {
         return "Player O";
      }  
   }   
   
   /* Set the current active player. Either 1 or 2.
    * 
    * @param activePlayer - The value that represents the player.
    *                       1 is Player X and 2 is Player O */
   public void SetActivePlayer(int activePlayer)
   {
      if( activePlayer == Tictactoe.PLAYER_X || activePlayer == Tictactoe.PLAYER_O )
      {
         this.activePlayer = activePlayer;
      }
   }
   
   /* Checks the grid and see if there's a winner.
    * 
    * @return - return true if there's a winner, or else return false */
   public boolean IsPlayerWin()
   {
      boolean haveWinner = false;
      
      // Check all rows
      for( int row = 0; row < this.grid.length; row++ )
      {
         if( this.grid[row][0] == this.grid[row][1] && this.grid[row][1] == this.grid[row][2] && 
            this.grid[row][0] != Tictactoe.EMPTY )
         {
            haveWinner = true;
            break;
         }
      }
      
      // Check all columns
      for( int col = 0; col < this.grid.length; col++ )
      {
         if( this.grid[0][col] == this.grid[1][col] && this.grid[1][col] == this.grid[2][col] &&
            this.grid[0][col] != Tictactoe.EMPTY)
         {
            haveWinner = true;
            break;
         }
      }  
      
      // Check diagonal
      if( this.grid[0][0] == this.grid[1][1] && this.grid[1][1] == this.grid[2][2] &&
         this.grid[0][0] != Tictactoe.EMPTY)
      {
         haveWinner = true;
      }
      
      if( this.grid[2][0] == this.grid[1][1] && this.grid[1][1] == this.grid[0][2] &&
         this.grid[2][0] != Tictactoe.EMPTY)
      {
         haveWinner = true;
      }
          
      
      return haveWinner;
   }
}