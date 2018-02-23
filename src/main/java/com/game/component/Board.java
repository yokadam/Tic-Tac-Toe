package com.game.component;

/**
 * Singleton Board class
 *
 * @author yogesh.kadam
 */
public class Board {

    private static final Character EmptyCell = ' ';
    private Character[][] board;

    private static Board instance;

    /**
     * private constructor
     */
    private Board() {
    }

    /**
     * Always provide one and only one instance of the Board class
     *
     * @return Board object
     */
    public static Board getInstance() {

        if (instance == null) {
            instance = new Board();
        }

        return instance;
    }

    /**
     * return character array of board-cells representation.
     *
     * @return character array of board cells
     */
    public Character[][] getBoard() {
        return board;
    }

    /**
     * populate board with character array representation.
     *
     * @param board
     */
    public void setBoard(Character[][] board) {
        this.board = board;
    }

    /**
     * initializes all cells of Board with empty values.
     *
     * @param size
     */
    public void initializeBoard(int size) {
        board = new Character[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                board[i][j] = EmptyCell;
            }

        }
    }

    /**
     * print board to game console.
     */
    public void displayBoard() {

        for (int i = 0; i < board.length; i++) {
            System.out.println("");
            System.out.print("          ");
            for (int j = 0; j < board.length; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j < board.length - 1)
                    System.out.print("|");
            }
            System.out.println();

            if (i < board.length - 1) {
                System.out.print("          ");
                for (int k = 0; k < board.length; k++) {
                    System.out.print("----");
                }
            }
        }
        System.out.println();
    }

    /**
     * This method returns true
     * if any row of the board filled with same player's sign/move
     * or
     * if any column of the board filled with same player's sign/move
     * or
     * if top-left to bottom-right diagonal of the board filled with same player's sign/move
     * or
     * if top-right to bottom-left diagonal of the board filled with same player's sign/move
     * </p>
     * else returns false
     *
     * @return boolean value of the result
     */
    public boolean checkForWin() {

        return checkRowsForWin() || checkColumnsForWin()
                || checkTopLeftToBottomRightDiagonalForWin()
                || checkTopRightToBottomLeftDiagonalForWin();
    }

    /**
     * This method returns true if any row of the board
     * filled with same player's sign/move
     * </p>
     * else returns false
     *
     * @return boolean value of the result
     */
    private boolean checkRowsForWin() {

        for (int i = 0; i < board.length; i++) {
            int count = 1;
            for (int j = 0; j < board.length - 1; j++) {
                if (!(board[i][j] == Board.EmptyCell) && board[i][j].equals(board[i][j + 1])) {
                    count++;
                } else {
                    break;
                }
                if (count == board.length)
                    return true;
            }
        }
        return false;
    }

    /**
     * This method returns true if any column of the board
     * filled with same player's sign/move
     * </p>
     * else returns false
     *
     * @return boolean value of the result
     */
    private boolean checkColumnsForWin() {

        for (int j = 0; j < board.length; j++) {
            int count = 1;
            for (int i = 0; i < board.length - 1; i++) {

                if (!(board[i][j] == Board.EmptyCell) && board[i][j].equals(board[i + 1][j])) {
                    count++;
                } else {
                    break;
                }
                if (count == board.length)
                    return true;
            }
        }

        return false;
    }

    /**
     * This method returns true if top-left to bottom-right diagonal of the board
     * filled with same player's sign/move
     * </p>
     * else returns false
     *
     * @return boolean value of the result
     */
    private boolean checkTopLeftToBottomRightDiagonalForWin() {

        for (int i = 0; i < board.length - 1; i++) {
            for (int j = 0; j < board.length - 1; j++) {
                if (i == j) {
                    if (!(board[i][j] == Board.EmptyCell) && board[i][j].equals(board[i + 1][j + 1])) {
                        break;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * This method returns true if top-right to bottom-left diagonal of the board
     * filled with same player's sign/move
     * </p>
     * else returns false
     *
     * @return boolean value of the result
     */
    private boolean checkTopRightToBottomLeftDiagonalForWin() {
        int count = 1;

        for (int i = 0, j = board.length - 1; i < board.length - 1 && j > 0; i++, j--) {

            if (!(board[i][j] == Board.EmptyCell) && board[i][j].equals(board[i + 1][j - 1])) {
                count++;
            } else {
                return false;
            }
        }
        return (count == board.length);
    }

    /**
     * This method checks whether game results in 'draw' status.
     * </p>
     * returns true, if all cells of the board are filled with players signs.
     * </p>
     * returns false, if there is still empty cell on the board.
     *
     * @return boolean value of the result
     */
    public boolean checkForDraw() {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == Board.EmptyCell) {
                    return false;
                }
            }

        }
        return true;
    }
}
