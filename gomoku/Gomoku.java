/**
 *@author Zakery Clarke
 *CS251-002
 *This is my Gomoku Lab for CS 251 at UNM
 *Passing a command line argument of Computer will let you play against a computer
 */
import cs251.lab2.GomokuGUI;
import cs251.lab2.GomokuModel;
import java.util.Random;
/**
 * The main class for Gomoku
 *@return null
 */
public class Gomoku implements GomokuModel {
    String[][] board = new String[getNumRows()][getNumCols()];//creates board array
    int turn = 0;//sets who's turn it is
    boolean computerplayer = false;//sets computer player

    @Override
    /**
     * getBoardString
     * translates 2d array into a string for gui
     * @return a string representation of the board
     */
    public String getBoardString() {
        String output = "";
        int i = 0;
        while (i < getNumRows()) {
            int j = 0;
            while (j < getNumCols()) {
                if (board[i][j] != null) {
                    output = output + board[i][j];
                } else {
                    output = output + "-";
                }
                j++;
            }
            output = output + "\n";
            i++;
        }
        return output;
    }
    /**
     * getNumCols
     * @return the number of columns
     */
    @Override
    public int getNumCols() {
        return GomokuModel.DEFAULT_NUM_COLS;
    }
    /**
     * getNumInLineForWin
     * @return the number needed to win
     */
    @Override
    public int getNumInLineForWin() {
        return GomokuModel.SQUARES_IN_LINE_FOR_WIN;
    }

    /**
     * getNumRows
     * @return the number of rows
     */
    @Override
    public int getNumRows() {
        return GomokuModel.DEFAULT_NUM_ROWS;
    }
    /**
     * handleHumanPlayAt
     * @param x user input
     * @param y user input
     * @return the board game state
     */
    @Override
    public Outcome handleHumanPlayAt(int x, int y) {
        if (board[x][y] == null || board[x][y] == "-") {
            if (turn == 0) {
                board[x][y] = "X";
                turn = 1;
            } else {
                board[x][y] = "O";
                turn = 0;
            }
            //check for a win
            if (gamestate(x, y) == 1) {
                return GomokuModel.Outcome.CROSS_WINS;
            } else {
                if (gamestate(x, y) == 3) {
                    return GomokuModel.Outcome.DRAW;
                }
            }
            //computer player
            if (computerplayer) {
                if (x - 1 < 0 || y - 1 < 0 || board[x - 1][y - 1] == "X" || board[x - 1][y - 1] == "O") { //move random if top left spot taken
                    Random generator = new Random();
                    x = generator.nextInt(getNumRows());
                    y = generator.nextInt(getNumCols());
                    while (board[x][y] == "X" || board[x][y] == "O") {
                        x = generator.nextInt(getNumRows());
                        y = generator.nextInt(getNumCols());
                    }
                    board[x][y] = "O";
                } else {
                    if (board[x - 1][y - 1] == "-" || board[x - 1][y - 1] == null) {
                        x = x - 1;
                        y = y - 1;
                        board[x][y] = "O";
                    }
                }
                turn = turn + 1;
                if (turn > 1) {
                    turn = 0;
                }
            }
            //check for a win	
            if (gamestate(x, y) == 2) {
                return GomokuModel.Outcome.RING_WINS;
            } else {
                if (gamestate(x, y) == 3) {
                    return GomokuModel.Outcome.DRAW;
                } else {
                    return GomokuModel.Outcome.GAME_NOT_OVER;
                }
            }
        } else {
            return GomokuModel.Outcome.GAME_NOT_OVER;
        }
    }
    /**
     * setComputerPlayer
     * sets computer player
     * @param command line string
     */
    @Override
    public void setComputerPlayer(String opponent) {
    	String temp="COMPUTER";
    	if(opponent.equals(temp)){ //sets computer play
            computerplayer=true;
        }else {
        	computerplayer=false;
        }
       
    }

    @Override
    public void startNewGame() { //clears board
        int i = 0;
        turn = 0;
        while (i < getNumRows()) {
            int j = 0;
            while (j < getNumCols()) {
                board[i][j] = "-";
                j++;
            }
            i++;
        }
    }
    /**
     * gamestate
     * @param x value to test
     * @param y value to test
     * @return 0=game not over 1=cross wins 2=rings wins 3=draw
     */
    private int gamestate(int x, int y) { //0=game not over 1=cross wins 2=rings wins 3=draw
        //test for a draw
        int i = 0;
        int c = 0;
        while (i < getNumRows()) {
            int j = 0;
            while (j < getNumCols()) {
                if (board[i][j] == "X" || board[i][j] == "O") {
                    c++; //counts number of filled spaces
                }
                j++;
            }
            i++;
        }
        if (c >= getNumRows() * getNumCols()) { //if all spaces are filled
            return 3; //return draw
        } else {
            //test for a win in all directions
            if (testwin(x, y, 1, 0) != 0) {
                return testwin(x, y, 1, 0);
            } else {
                if (testwin(x, y, 0, 1) != 0) {
                    return testwin(x, y, 0, 1);
                } else {
                    if (testwin(x, y, 1, 1) != 0) {
                        return testwin(x, y, 1, 1);
                    } else {
                        if (testwin(x, y, 1, -1) != 0) {
                            return testwin(x, y, 1, -1);
                        } else {
                            return 0;
                        }
                    }
                }
            }
            //end test
        }

    }
    /**
     * testwin
     * @param x value to be tested
     * @param y value to be tested
     * @param xoffset direction to test
     * @param yoffset direction to test
     * @return 0=no wins 1=cross wins 2=rings win
     */
    private int testwin(int x, int y, int xoffset, int yoffset) { //returns 0=no wins 1=cross wins 2=rings win
        int z = 0;
        String testsymbol = board[x][y];
        x = (x) - xoffset * getNumInLineForWin();
        y = (y) - yoffset * getNumInLineForWin();
        int c = 0;
        x = x + xoffset;
        y = y + yoffset;
        while (c < 2 * getNumInLineForWin() - 1 && z < getNumInLineForWin()) { //tests for consecutive symbols
            if (x >= 0 && x < getNumRows() && y >= 0 && y < getNumCols()) {
                if (board[x][y] == testsymbol) {
                    z++;
                } else {
                    z = 0;
                }
            }
            x = x + xoffset;
            y = y + yoffset;
            c++;
        }
        if (z >= getNumInLineForWin()) { //tests how many symbols were in a row
            if (testsymbol == "X") {
                return 1;
            } else {
                return 2;
            }
        } else {
            return 0;
        }
    }
    /**
     * Main
     * @param args takes command line arguments for computer player
     */
    public static void main(String[] args) {
        Gomoku game = new Gomoku();
        if (args.length > 0) {
            game.setComputerPlayer(args[0]);  
        }
        GomokuGUI.showGUI(game);
    }

}