package com.game.controller;

import com.game.component.Board;
import com.game.component.Player;
import com.game.component.PlayerFactory;
import com.game.enums.GameConfig;
import com.game.validation.ConfigValidation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

/**
 * Game controller class.
 *
 * @author yogesh.kadam
 */
public class GameController {

    private Scanner sc = new Scanner(System.in);
    private Properties prop = new Properties();
    private Board boardInstance = Board.getInstance();

    /**
     * First execution point and actual game processing.
     */
    public void play() {

        if (loadAndValidateGameConfiguration()) {

            // read configurations from config file
            int boardSize = Integer.valueOf(readConfigPropertyByKey(GameConfig.PLAYFIELD_SIZE.getValue()));
            String firstPlayer = readConfigPropertyByKey(GameConfig.FIRST_PLAYER.getValue());
            String secondPlayer = readConfigPropertyByKey(GameConfig.SECOND_PLAYER.getValue());
            String thirdPlayer = readConfigPropertyByKey(GameConfig.THIRD_PLAYER.getValue());
            String firstPlayerSign = readConfigPropertyByKey(GameConfig.FIRST_PLAYER_SIGN.getValue());
            String secondPlayerSign = readConfigPropertyByKey(GameConfig.SECOND_PLAYER_SIGN.getValue());
            String thirdPlayerSign = readConfigPropertyByKey(GameConfig.THIRD_PLAYER_SIGN.getValue());

            Player player1 = getPlayerUsingConfigParams(firstPlayer, firstPlayerSign);
            Player player2 = getPlayerUsingConfigParams(secondPlayer, secondPlayerSign);
            Player player3 = getPlayerUsingConfigParams(thirdPlayer, thirdPlayerSign);

            displayGameConsoleWithInfo();

            initializeBoardWithEmptyCells(boardSize);

            displayBoardOnGameConsole();

            startGame(player1, player2, player3);
        }
    }

    /**
     * read config property by key from config file.
     *
     * @param key
     * @return property value from config file
     */
    private String readConfigPropertyByKey(String key) {
        return prop.getProperty(key);
    }

    /**
     * get Player object constructed from provided config key-values.
     *
     * @param playerName
     * @param playerSign
     * @return Player Object
     */
    private Player getPlayerUsingConfigParams(String playerName, String playerSign) {

        PlayerFactory playerFactory = new PlayerFactory();

        Player player = playerFactory.getPlayer(playerName);
        player.setName(playerName);
        player.setSign(playerSign);

        return player;
    }

    /**
     * display board with latest updates/changes.
     */
    private void displayBoardOnGameConsole() {
        boardInstance.displayBoard();
    }

    /**
     * This method starts players move one by one until
     * it results in game draw or any one player wins the game.
     *
     * @param player1
     * @param player2
     * @param player3
     */
    private void startGame(Player player1, Player player2, Player player3) {

        while (true) {

            player1.makeMove(sc);
            displayBoardOnGameConsole();
            if (checkForWin(player1.getName()) || checkForDraw()) {
                break;
            }

            player2.makeMove(sc);
            displayBoardOnGameConsole();
            if (checkForWin(player2.getName()) || checkForDraw()) {
                break;
            }

            player3.makeMove(sc);
            displayBoardOnGameConsole();
            if (checkForWin(player3.getName()) || checkForDraw()) {
                break;
            }
        }
    }

    /**
     * This method checks whether game results in 'draw' status.
     * </p>
     * true if all cells of the board are filled with players signs.
     * </p>
     * false if there is still empty cell on the board.
     *
     * @return boolean value of the result
     */
    private boolean checkForDraw() {
        if (boardInstance.checkForDraw()) {
            System.out.print("Game draw");
            System.out.print("");
            return true;
        }
        return false;
    }

    /**
     * This method checks whether any player has won the game or not.
     * </p>
     * Also prints the name of the player to game console.
     *
     * @param name
     * @return boolean value of validation result
     */
    private boolean checkForWin(String name) {
        if (boardInstance.checkForWin()) {
            System.out.println();
            System.out.println("Congratulations!!! " + name + " has won.");
            return true;
        }
        return false;
    }

    /**
     * display game initialization info content details.
     */
    private void displayGameConsoleWithInfo() {
        System.out.println();
        System.out.println("============================================");
        System.out.println("|    WELCOME TO TIC-TAC-TOE GAME CONSOLE   |");
        System.out.println("============================================");

        System.out.println("General Info/Rules:                        |");
        System.out.println("1) Its 3 player game (human player-1 vs human player-2 vs computer)");
        System.out.println("2) Move position should be entered as comma " +
                "separated numbers referring to empty cell" +
                " for ex. 1,1");
        System.out.println("============================================");
    }

    /**
     * initializes board with no. of rows and columns equals to 'size' param
     * and also all cells are set to empty initially.
     * </p>
     * for ex. if size = 3 then board size will 3x3 (3 rows and 3 columns)
     *
     * @param size
     */
    private void initializeBoardWithEmptyCells(int size) {
        boardInstance.initializeBoard(size);
    }

    /**
     * load the configuration from config properties file as well as
     * validates all the configurations.
     *
     * @return boolean value of validation result.
     */
    public boolean loadAndValidateGameConfiguration() {

        InputStream input = null;

        try {
            input = new FileInputStream("src/main/resources/config.properties");

            // load a properties file
            prop.load(input);

        } catch (IOException e) {
            System.out.println("Problem in loading config property file: ");
            System.out.println("Exception: " + e);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    System.out.println("Unexpected error occurred: " + e);
                }
            }
        }
        return ConfigValidation.validate(prop);
    }
}