package com.game.component;

import java.util.Random;
import java.util.Scanner;

/**
 * Computer player class.
 *
 * @author yogesh.kadam
 */
public class ComputerPlayer extends Player {

    Random generator = new Random();

    /**
     * Automatic computer's move to fill any random and empty cell of the board.
     *
     * @param sc
     */
    @Override
    public void makeMove(Scanner sc) {

        System.out.println(this.getName() + "'s move -> ");
        Board instance = Board.getInstance();
        Character[][] board = instance.getBoard();
        int size = instance.getBoard().length;

        int row;
        int column;

        do {
            row = generator.nextInt(size);
            column = generator.nextInt(size);
        } while (board[row][column] != ' ');

        board[row][column] = this.getSign().charAt(0);
    }
}
