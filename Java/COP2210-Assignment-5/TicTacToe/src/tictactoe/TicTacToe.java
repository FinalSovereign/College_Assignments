//******************************************************************************
// STUDENT NAME:  Carlos A. Rivera
// FIU EMAIL: crive161@fiu.edu
// CLASS: COP 2210 – Fall 2017
// ASSIGNMENT # 5
// DATE: 9 December 2017
//
// I hereby swear and affirm that this work is solely my own, and not the work 
// or the derivative of the work of someone else, except as outlined in the 
// assignment instructions.
//******************************************************************************

package tictactoe;

//import java.awt.Color;
import java.util.Arrays;
import javax.swing.JOptionPane;
import java.util.Random;

/**
 * This class holds various methods independent of the board GUI. Any method
 * that requires the uses of jButtons or jLabels are in the TicTacToeBoard
 * class.
 * 
 * @author Carlos A. Rivera
 */

public class TicTacToe {

    static Random rand = new Random();
    
    private final static int[][] winCon = new int[][] {
                            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                            {0, 4, 8}, {2, 4, 6}
                        };
    private static String[][] board = new String[3][3];
    private static boolean[] buttons = new boolean[9];
    
    private static boolean isCom = false;
    private static String playerName = "Happy Shaq";
    private static String playerTurn = "X";
    //private static String comTurn = "0";
    //private Color playerColor = Color.red;
    
    private static String player1 = "";
    private static String player2 = "";
    
    public TicTacToe() {
        for (String[] row : board) {
            Arrays.fill(row, " ");
        }
        Arrays.fill(buttons, true);
    }
    
    /**
     * A simple calling method to prompt the user for their name. Could be
     * inserted into the code normally but it can have purposes outside of the
     * beginning of the program.
     */
    
    public void detName() {
        playerName = JOptionPane.showInputDialog(null,
                      "Enter your name:" , "Set Name",
                      JOptionPane.DEFAULT_OPTION);
    }
    
    /*
    public void detToken() {
        String[] options = {"X", "O"};
        
        playerTurn = options[JOptionPane.showOptionDialog(null,
                     "Select your token, " + playerName, "Set Token",
                     JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                     null, options, null)];
        
        
        if(playerTurn.equalsIgnoreCase("X")) {
            comTurn = "O";
        }
        else {
            comTurn = "X";
        }
        
    }
    */
    
    /**
     * Rolls for who goes first, the player or the computer.
     * A simple 50-50 chance using the Random class.
     */
    
    public void detTurn() {
        int i = rand.nextInt(2);
        
        if(i == 0) {
            isCom = true;
        }
    }
    
    /**
     * This method will systematically check win conditions for a certain player
     * token when activated. The conditions themselves are up top defined under
     * the array name, winCon.
     */
    
    public boolean detWin(String token) {
        boolean win = false;
        String[] check = new String[3];
        int i = 0;
        
        do{
            check[0] = board[winCon[i][0] / 3][winCon[i][0] % 3];
            check[1] = board[winCon[i][1] / 3][winCon[i][1] % 3];
            check[2] = board[winCon[i][2] / 3][winCon[i][2] % 3];
            
            for(int j = 0; j < 3; j++) {
                if(check[j].equals(token)) {
                    if(j == 2) {
                        win = true;
                    }
                }
                else {
                    j = 3;
                }
            }
            
            if(win) {
                return win;
            }
            
            i++;
        }while(i < winCon.length);
        
        return win;
    }
    
    /*
    public void comTurn() {
        boolean key = false;
        int i = 0;
        
        JOptionPane.showMessageDialog(null, "COM, choose a spot.");
        
        do {
            i = rand.nextInt(9);
            
            if(buttons[i]) {
                buttons[i] = false;
                key = true;
            }
        } while(!key);
        
        //this.changeTurn();
        isCom = false;
        
        JOptionPane.showMessageDialog(null, playerName + ", choose a spot."
                + "(Move over to refresh selectable spots)");
    }
    */
    
    /**
     * This method changes the player token, symbolizing the changing of player
     * turns. By default, Player 1 is X while Player 2 is O. This can be changed
     * around but this is more simple to work with.
     */
    
    public void changeTurn() {
        if(playerTurn.equalsIgnoreCase("X")) {
            playerTurn = "O";
            //isCom = true;
            //this.playerColor = Color.blue;
        }
        else {
            playerTurn = "X";
            //isCom = true;
            //this.playerColor = Color.red;
        }
    }
    
    /**
     * Various setter and getter methods for the various private instance
     * variables in this class. Only setBoardButton() is special since it is a
     * setting of which buttons were pressed and which token it has.
     */
    
    public void setName(String name) {
        playerName = name;
    }
    
    public void setPlayer1(String player) {
        player1 = player;
    }
    
    public void setPlayer2(String player) {
        player2 = player;
    }
    
    public void setTurn(String turn) {
        playerTurn = turn;
    }
    
    public void setBoardButton(String token, int index) {
        board[index / 3][index % 3] = token;
        buttons[index] = false;
    }
    
    public String getName() {
        return playerName;
    }
    
    public String getPlayer1() {
        return player1;
    }
    
    public String getPlayer2() {
        return player2;
    }
    
    public String getPlayerTurn() {
        return playerTurn;
    }
    
    /*
    public String getComTurn() {
        return comTurn;
    }
    */
    
    public boolean getCom() {
        return isCom;
    }
    
    public Boolean getButton(int index) {
        return buttons[index];
    }
    
    /*
    public Color getColor() {
        return this.playerColor;
    }
    */
    
}
