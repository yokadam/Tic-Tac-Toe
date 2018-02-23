package com.game.component;

/**
 * Factory class to provide concrete objects of type Player.
 *
 * @author yogesh.kadam
 */
public class PlayerFactory {

    /**
     * Factory pattern method to provide concrete Player object
     * as per provided input.
     *
     * @param PlayerType
     * @return Player instance
     */
    public Player getPlayer(String PlayerType) {

        if (PlayerType == null) {
            return null;
        }
        if (PlayerType.equalsIgnoreCase("computer")) {
            return new ComputerPlayer();

        } else {
            return new HumanPlayer();
        }
    }
}
