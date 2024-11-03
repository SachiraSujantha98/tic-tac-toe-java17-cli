package org.sachira.players;

import org.sachira.enums.Mark;
import org.sachira.game.Board;
import org.sachira.moves.Move;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Mark mark;
    private final Scanner scanner;

    public HumanPlayer(Mark mark) {
        this.mark = mark;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Move makeMove(Board board) {
        int row, col;
        while (true) {
            System.out.println("Player " + mark + ", enter your move (row and column): ");
            String input = scanner.nextLine();
            String[] tokens = input.trim().split("\\s+");
            if (tokens.length != 2) {
                System.out.println("Invalid input. Please enter two numbers separated by space.");
                continue;
            }
            try {
                row = Integer.parseInt(tokens[0]);
                col = Integer.parseInt(tokens[1]);
                if (board.isCellEmpty(row, col)) {
                    return new Move(row, col);
                } else {
                    System.out.println("Cell is not empty. Choose another cell.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid numbers. Please enter valid integers.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid cell. Please enter values between 0 and 2.");
            }
        }
    }

    @Override
    public Mark getMark() {
        return mark;
    }
}
