package org.sachira.game;

import org.sachira.enums.Mark;

public class Board {
    private final Mark[][] board;
    private static final int SIZE = 3;

    public Board() {
        board = new Mark[SIZE][SIZE];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = Mark.EMPTY;
            }
        }
    }

    public boolean isCellEmpty(int row, int col) {
        validateCell(row, col);
        return board[row][col] == Mark.EMPTY;
    }

    public void placeMark(int row, int col, Mark mark) {
        validateCell(row, col);
        if (board[row][col] != Mark.EMPTY) {
            throw new IllegalArgumentException("Cell is already occupied");
        }
        board[row][col] = mark;
    }

    private void validateCell(int row, int col) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            throw new IndexOutOfBoundsException("Cell indices out of bounds");
        }
    }

    public boolean checkWin(Mark mark) {
        // Check rows and columns
        for (int i = 0; i < SIZE; i++) {
            if ((board[i][0] == mark && board[i][1] == mark && board[i][2] == mark) ||
                    (board[0][i] == mark && board[1][i] == mark && board[2][i] == mark)) {
                return true;
            }
        }
        // Check diagonals
        return (board[0][0] == mark && board[1][1] == mark && board[2][2] == mark) ||
                (board[0][2] == mark && board[1][1] == mark && board[2][0] == mark);
    }

    public boolean isBoardFull() {
        for (Mark[] row : board) {
            for (Mark cell : row) {
                if (cell == Mark.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public void displayBoard() {
        System.out.println("Current Board:");
        for (Mark[] row : board) {
            for (Mark cell : row) {
                char symbol = cell == Mark.EMPTY ? '-' : cell.toString().charAt(0);
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }
}