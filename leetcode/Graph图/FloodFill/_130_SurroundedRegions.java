package leetcode.Graph图.FloodFill;
/**
 * Date: 9/24/20
 * Question Description
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 *
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the
 * board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an
 * 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells
 * connected horizontally or vertically.
 *
 */

/**
 * Description:
 * Example:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * Time complexity:O(m * n);
 * Space complexity: O(n);

 */
public class _130_SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][col - 1] == 'O') {
                dfs(board, i, col - 1);
            }
        }
        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[row - 1][j] == 'O') {
                dfs(board, row - 1, j);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    private  void dfs(char[][] board, int r, int c) {
        int row = board.length;
        int col = board[0].length;
        if (r < 0 || r >= row || c < 0 || c >= col || board[r][c] != 'O') return;
        board[r][c] = '1';
        dfs(board, r - 1, c);
        dfs(board, r + 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}
