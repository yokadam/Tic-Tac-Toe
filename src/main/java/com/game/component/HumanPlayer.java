package com.game.component;

import com.game.util.RegexUtil;

import java.util.Scanner;

/**
 * Human Player class
 *
 * @author yogesh.kadam
 */
public class HumanPlayer extends Player {

    /**
     * execution of player's move.
     *
     * @param sc
     */
    @Override
    public void makeMove(Scanner sc) {
        Board instance = Board.getInstance();
        Character[][] board = instance.getBoard();

        enterAndValidatePlayerMove(sc, board);
    }

    /**
     * prompt player to enter valid move,
     * Also validates the entered move is valid(comma separated numbers only)
     * If validation succeeds then updates the board as well.
     *
     * @param sc
     * @param board
     * @return entered valid Move
     */
    private String enterAndValidatePlayerMove(Scanner sc, Character[][] board) {
        String input;
        int row;
        int column;

        do {
            do {
                System.out.print(this.getName() + ": Please enter valid move -> ");
                input = sc.next();
            } while (!RegexUtil.matchCommaSeparatedDigits(input));

            String[] positions = input.trim().split(",");

            // array indexes are zero based so subtracting one from input positions to match.
            row = Integer.valueOf(positions[0]) - 1;
            column = Integer.valueOf(positions[1]) - 1;
        } while (invalidBoardParams(board, row, column));

        board[row][column] = this.getSign().charAt(0);
        return input;
    }

    /**
     * validates whether input rows and columns are within limits of the board size or not
     * and
     * also validates input row and column representing board cell is empty or not.
     *
     * @param board
     * @param row
     * @param column
     * @return boolean value of the validation result
     */
    private boolean invalidBoardParams(Character[][] board, int row, int column) {
        boolean flag = row < 0 || column < 0 || !(row < board.length
                && column < board.length) || board[row][column] != ' ';
        if (flag) {
            System.out.println("Wrong Input !!!");
            return flag;
        }
        return false;
    }
}
