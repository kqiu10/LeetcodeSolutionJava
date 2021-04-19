package com.google.src;
/**
 * Date: 4/19/21
 * Question Description:
 * Given an m x n matrix board containing 'X' and 'O', capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 *
 * <p>
 * Examples:
 * Example 1:
 *
 *
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * Explanation: Surrounded regions should not be on the border, which means that any 'O' on the
 * border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not
 * connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are
 * adjacent cells connected horizontally or vertically.
 * Example 2:
 *
 * Input: board = [["X"]]
 * Output: [["X"]]
 */

/**
 * Time Complexity: O()
 * Space Complexity: O()
 */
public class _130_SurroundedRegions {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                bfs(board, i, n - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                bfs(board, 0, i);
            }
            if (board[m - 1][i] == 'O') {
                bfs(board, m - 1, i);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void bfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') return;
        board[i][j] = '1';
        bfs(board, i - 1, j);
        bfs(board, i + 1, j);
        bfs(board, i, j - 1);
        bfs(board, i, j + 1);
    }
}
