package com.game.enums;

/**
 * Enum to hold the config file keys as constants.
 *
 * @author yogesh.kadam
 */
public enum GameConfig {

    PLAYFIELD_SIZE("playfieldsize"),
    FIRST_PLAYER("firstplayer"),
    SECOND_PLAYER("secondplayer"),
    THIRD_PLAYER("thirdplayer"),
    FIRST_PLAYER_SIGN("firstplayersign"),
    SECOND_PLAYER_SIGN("secondplayersign"),
    THIRD_PLAYER_SIGN("thirdplayersign");

    String value;

    GameConfig(String value) {
        this.value = value;
    }

    /**
     * returns Enum constant
     *
     * @return Constant String
     */
    public String getValue() {
        return value;
    }
}
