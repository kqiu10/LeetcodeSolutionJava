/**
 * Date: 11/29/20
 * Question Description
 According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

 Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

 Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 Any live cell with two or three live neighbors lives on to the next generation.
 Any live cell with more than three live neighbors dies, as if by over-population..
 Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
 */

/**
 * Description: TODO
 * Time complexity:O(m * n);
 * Space complexity: O(1);

 */
public class _289_GameofLife {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = count(board, i, j);
                if (board[i][j] == 1) {
                    if (live == 2 || live == 3) {
                        board[i][j] += 2;
                    }
                } else if (live == 3) {
                    board[i][j] += 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
        return;
    }

    private int count(int[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        for (int row = Math.max(0, i - 1); row <= Math.min(i + 1, m - 1); row++) {
            for (int col = Math.max(0, j - 1); col <= Math.min(j + 1, n - 1); col++) {
                if (row == i && col == j) continue;
                if ((board[row][col] & 1) == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
