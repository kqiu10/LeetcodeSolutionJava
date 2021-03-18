package src; /**
 * Date: 11/16/20
 * Question Description
 Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 Example:

 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X
 Explanation:

 Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.


 */

/**
 * Description: TODO
 * Time complexity:O(m * n);
 * Space complexity: O(1);

 */
public class _130_SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length - 1;
        int n = board[0].length - 1;
        for (int i = 0; i <= m; i++) {
            if (board[i][0] == 'O' || board[i][n] == 'O') {
                helper(board, i, 0);
            }
            if (board[i][n] == 'O') {
                helper(board, i, n);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                helper(board, 0, i);
            }
            if (board[m][i] == 'O') {
                helper(board, m, i);
            }
        }
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
        return;

    }
    private void helper(char[][] board, int row, int col) {
        int m = board.length - 1;
        int n = board[0].length - 1;
        if (row < 0 || row > m || col < 0 || col > n || board[row][col] != 'O') return;
        board[row][col] = '1';
        helper(board, row - 1, col);
        helper(board, row + 1, col);
        helper(board, row, col - 1);
        helper(board, row, col + 1);
    }
}
