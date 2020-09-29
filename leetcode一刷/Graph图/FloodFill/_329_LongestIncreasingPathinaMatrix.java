package leetcode.Graph图.FloodFill;
/**
 * Date: 9/25/20
 * Question Description
 * Given an integer matrix, find the length of the longest increasing path.
 *
 * From each cell, you can either move to four directions: left, right, up or down. You may NOT
 * move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 *
 * Example 1:
 *
 * Input: nums =
 * [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 * Example 2:
 *
 * Input: nums =
 * [
 *   [3,4,5],
 *   [3,2,6],
 *   [2,2,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 *
 */

/**
 * Description: TODO
 * Time complexity:O(row * col);
 * Space complexity: O(row * col);

 */
public class _329_LongestIncreasingPathinaMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int res = 0;
        int row = matrix.length, col = matrix[0].length;
        int[][] cache = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int max = dfs(matrix, Integer.MIN_VALUE, i, j, row, col,cache);
                res = Math.max(res, max);
            }
        }
        return res;

    }

    private int dfs(int[][] matrix, int cur, int i, int j, int row, int col, int[][] cache) {
        if (i < 0 || i >= row || j < 0 || j >= col || matrix[i][j] <= cur) return 0;
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        cur = matrix[i][j];
        int a = dfs(matrix, cur, i - 1, j, row, col, cache) + 1;
        int b = dfs(matrix, cur, i + 1, j, row, col, cache) + 1;
        int c = dfs(matrix, cur, i, j - 1, row, col, cache) + 1;
        int d = dfs(matrix, cur, i, j + 1, row, col, cache) + 1;
        int max = Math.max(a, Math.max(b, Math.max(c, d)));
        cache[i][j] = max;

        return max;

    }
}
