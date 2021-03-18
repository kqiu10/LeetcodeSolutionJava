package src; /**
 * Date: 11/4/20
 * Question Description
 */

/**
 * Description: TODO
 * Time complexity:O(9^(m * n));
 * Space complexity: O(m*n);

 */
public class _37_SudukuSolver {
    public void solveSudoku(char[][] board) {
        valid(board);

    }
    private boolean valid(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (valid(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(char[][] board, int row, int col, char c) {
       for (int i = 0; i < 9; i++) {
           if (board[row][i] == c) return false;
           if (board[i][col] == c) return false;
           if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
       }
       return true;

    }
}
