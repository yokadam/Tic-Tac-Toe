package com.game.validation;

import com.game.enums.GameConfig;
import java.util.Properties;

/**
 * Validator Class to validate config params read from config properties file.
 *
 * @author yogesh.kadam
 */
public class ConfigValidation {

    private static final String PLAYFIELD_SIZE = GameConfig.PLAYFIELD_SIZE.getValue();
    private static final String FIRST_PLAYER = GameConfig.FIRST_PLAYER.getValue();
    private static final String SECOND_PLAYER = GameConfig.SECOND_PLAYER.getValue();
    private static final String THIRD_PLAYER = GameConfig.THIRD_PLAYER.getValue();
    private static final String FIRST_PLAYER_SIGN = GameConfig.FIRST_PLAYER_SIGN.getValue();
    private static final String SECOND_PLAYER_SIGN = GameConfig.SECOND_PLAYER_SIGN.getValue();
    private static final String THIRD_PLAYER_SIGN = GameConfig.THIRD_PLAYER_SIGN.getValue();
    private static final String COMPUTER = "computer";

    /**
     * This is main method which validates different validation
     * possibilities of the config properties.
     *
     * @param prop
     * @return boolean value for validation result
     */
    public static boolean validate(Properties prop) {

        return validateMissingPropertyKeyOrValue(prop)
                && validatePlayFieldSize(prop)
                && validateFirstPlayer(prop)
                && validateSecondPlayer(prop)
                && validateThirdPlayer(prop)
                && validateOnePlayerIsComputer(prop);
    }

    /**
     * Validates if any config param key or value is missing in
     * config properties file.
     *
     * @param prop
     * @return boolean value for validation result
     */
    private static boolean validateMissingPropertyKeyOrValue(Properties prop) {

        return validatePropertyByKey(prop, PLAYFIELD_SIZE)
                && validatePropertyByKey(prop, FIRST_PLAYER)
                && validatePropertyByKey(prop, SECOND_PLAYER)
                && validatePropertyByKey(prop, THIRD_PLAYER)
                && validatePropertyByKey(prop, FIRST_PLAYER_SIGN)
                && validatePropertyByKey(prop, SECOND_PLAYER_SIGN)
                && validatePropertyByKey(prop, THIRD_PLAYER_SIGN);
    }

    /**
     * validates property 'playfieldsize' from the config properties file
     * for below conditions.
     * </p>
     * Condition-1: 'playfieldsize' should be an integer.
     * </p>
     * Condition-2: if 'playfieldsize' is integer then value should be between
     *              3 and 10 only.
     *
     * @param prop
     * @return boolean value for validation result
     */
    private static boolean validatePlayFieldSize(Properties prop) {

        String playFieldSize = prop.getProperty(PLAYFIELD_SIZE);
        if (playFieldSize.matches("[0-9]+")) {
            int size = Integer.valueOf(playFieldSize);
            if (size >= 3 && size <= 10) {
                return true;
            } else {
                System.out.println(" Please provide a valid number for PlayField size between 3 to 10 !");
                return false;
            }
        } else {
            System.out.println(" PlayField size is not a number, Please provide a valid number !");
        }
        return false;
    }

    /**
     * Validates property 'firstplayer' from the config properties file.
     *
     * @param prop
     * @return boolean value for validation result
     */
    private static boolean validateFirstPlayer(Properties prop) {

        return validatePlayerParameters(FIRST_PLAYER, FIRST_PLAYER_SIGN, prop);
    }

    /**
     * Validates property 'secondplayer' from the config properties file.
     *
     * @param prop
     * @return boolean value for validation result
     */
    private static boolean validateSecondPlayer(Properties prop) {

        return validatePlayerParameters(SECOND_PLAYER, SECOND_PLAYER_SIGN, prop);
    }

    /**
     * Validates property 'thirdplayer' from the config properties file.
     *
     * @param prop
     * @return boolean value for validation result
     */
    private static boolean validateThirdPlayer(Properties prop) {

        return validatePlayerParameters(THIRD_PLAYER, THIRD_PLAYER_SIGN, prop);
    }

    /**
     * Validates player sign for below condition.
     * </p>
     * Condition: Player sign should be a single character only.
     *
     * @param playerNameKey
     * @param playerSignKey
     * @param prop
     * @return boolean value for validation result
     */
    private static boolean validatePlayerParameters(String playerNameKey, String playerSignKey, Properties prop) {

        String playerSign = prop.getProperty(playerSignKey);
        if (!(playerSign.length() == 1)) {

            System.out.println(playerNameKey + " sign should be a single character only");
            return false;
        }
        return true;
    }

    /**
     * validates if config file contains at least one player as 'computer' or not.
     *
     * @param prop
     * @return boolean value for validation result
     */
    private static boolean validateOnePlayerIsComputer(Properties prop) {
        String player1 = prop.getProperty(FIRST_PLAYER);
        String player2 = prop.getProperty(SECOND_PLAYER);
        String player3 = prop.getProperty(THIRD_PLAYER);

        if (!(player1.toLowerCase().equals(COMPUTER)
                || player2.toLowerCase().equals(COMPUTER)
                || player3.toLowerCase().equals(COMPUTER))) {
            System.out.println(" At least one player should be computer");
            return false;
        }
        return true;
    }

    /**
     * validates whether player key or its value is missing in the config file or not.
     *
     * @param prop
     * @param key
     * @return boolean value for validation result
     */
    private static boolean validatePropertyByKey(Properties prop, String key) {
        if (!prop.containsKey(key) || prop.getProperty(key).equals("")) {
            System.out.println("Missing valid property: " + key + " in the config file");
            return false;
        }

        return true;
    }
}
