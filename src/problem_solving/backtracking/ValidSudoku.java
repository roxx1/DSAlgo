package problem_solving.backtracking;

public class ValidSudoku {

    public static void main(String[] args) {

        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        boolean b = isValidSudoku(board);
        System.out.println(b);
    }

    public static boolean isValidSudoku(char[][] board) {
        return checkSudoko(board, 0, 0, board.length);
    }

    public static boolean checkSudoko(char[][] board, int i, int j, int n) {

        if (j == n && i !=n) {
            return checkSudoko(board, i + 1, 0, n);
        }

        if (i == n) {
            return true;
        }

        if (board[i][j] != '.') {
            return checkSudoko(board,i,j+1,n);
        }

        for (int no = 1; no <= n; no++) {
            if (isValid(board, i, j, no, n)) {
                board[i][j] = (char) (no + '0');
                boolean b = checkSudoko(board, i, j + 1, n);
                if (b) {
                    return true;
                }
                board[i][j] = '.';
            }
        }

        return false;
    }


    public static boolean isValid(char[][] board, int i, int j, int no, int n) {

        //if (i < 0 || i >= n || j < 0 || j >= n || board[i][j] != '.') return false;

        char c = (char) (no + '0');

        for (int x = 0; x < n; x++) {
            if (board[i][x] == c) {
                return false;
            }
        }

        for (int x = 0; x < n; x++) {
            if (board[x][j] == c) {
                return false;
            }
        }

        // check if sub square has no present or not
        int n1 = (int) (Math.sqrt(n));

        int boxStartX = (i / n1) * n1;
        int boxStartY = (j / n1) * n1;

        for (int x = 0; x < n1; x++) {
            for (int y = 0; y < n1; y++) {
                if (board[boxStartX + x][boxStartY + y] == c) {
                    return false;
                }
            }
        }


        return true;
    }



}

