package problem_solving.backtracking;

public class NQueenProblem {

    public static void main(String[] args) {

        int board[][] = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};

        boolean b = solveNQueenProblem(board, 0);
        if (b) {
            printBoard(board);
        }

    }

    private static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean solveNQueenProblem(int[][] board, int col) {
        if (col == board.length) {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            if (isValid(board, i, col)) {
                board[i][col] = 1;
                if (solveNQueenProblem(board, col + 1)) {
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }

    private static boolean isValid(int[][] board, int row, int col) {
        int len = board.length;
        for (int i = 0; i < len; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i < len && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

}
