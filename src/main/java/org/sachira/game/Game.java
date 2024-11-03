package org.sachira.game;

import org.sachira.moves.Move;
import org.sachira.players.Player;

public class Game {
    private final Board board;
    private final Player playerX;
    private final Player playerO;
    private Player currentPlayer;

    public Game(Player playerX, Player playerO) {
        this.board = new Board();
        this.playerX = playerX;
        this.playerO = playerO;
        this.currentPlayer = playerX;
    }

    public void start() {
        board.displayBoard();
        while (true) {
            Move move = currentPlayer.makeMove(board);
            board.placeMark(move.getRow(), move.getCol(), currentPlayer.getMark());
            board.displayBoard();
            if (board.checkWin(currentPlayer.getMark())) {
                System.out.println("Player " + currentPlayer.getMark() + " wins!");
                break;
            }
            if (board.isBoardFull()) {
                System.out.println("It's a draw!");
                break;
            }
            switchPlayer();
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }
}
