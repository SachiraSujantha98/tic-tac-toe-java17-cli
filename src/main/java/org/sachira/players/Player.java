package org.sachira.players;

import org.sachira.enums.Mark;
import org.sachira.game.Board;
import org.sachira.moves.Move;

public interface Player {
    Move makeMove(Board board);
    Mark getMark();
}
