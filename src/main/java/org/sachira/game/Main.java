package org.sachira.game;

import org.sachira.enums.Mark;
import org.sachira.players.Player;
import org.sachira.players.PlayerFactory;

public class Main {
    public static void main(String[] args) {
        Player playerX = PlayerFactory.createPlayer("human", Mark.X);
        Player playerO = PlayerFactory.createPlayer("human", Mark.O);

        Game game = new Game(playerX, playerO);
        game.start();
    }
}

