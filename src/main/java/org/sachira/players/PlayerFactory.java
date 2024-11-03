package org.sachira.players;

import org.sachira.enums.Mark;

public class PlayerFactory {
    public static Player createPlayer(String type, Mark mark) {
        if ("human".equalsIgnoreCase(type)) {
            return new HumanPlayer(mark);
        }
        // Future implementation for AIPlayer can be added here :)
        throw new IllegalArgumentException("Unknown player type: " + type);
    }
}