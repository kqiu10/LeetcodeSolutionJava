package ArrayList数组.特殊;
/**
 * Package Name : 数组.特殊;
 * File name : SudokuSolver37;
 * Creator: Kane;
 * Date: 8/12/20
 */

/**
 * Time complexity:O(9^(m * n));
 * Space complexity: O(m*n);
 * Description: TODO
 */
public class SudokuSolver37 {
    public static void solveSudoku(char[][] board) {
        if (board.length == 0 || board == null) return;
        solve(board);
    }
    public static boolean solve(char[][]board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isvalid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isvalid(char[][]board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) return false;
            if (board[row][i] != '.' && board[row][i] == c) return false;
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        solveSudoku(new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','1','9','5','.','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        });
    }
}
