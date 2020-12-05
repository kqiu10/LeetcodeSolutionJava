/**
 * Date: 12/4/20
 * Question Description
 Given an integer matrix, find the length of the longest increasing path.

 From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

 Example 1:

 Input: nums =
 [
 [9,9,4],
 [6,6,8],
 [2,1,1]
 ]
 Output: 4
 Explanation: The longest increasing path is [1, 2, 6, 9].
 Example 2:

 Input: nums =
 [
 [3,4,5],
 [3,2,6],
 [2,2,1]
 ]
 Output: 4
 Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

 */

/**
 * Description: TODO
 * Time complexity:O(m^2 * n^2);
 * Space complexity: O(m * n);

 */
public class _329_LongestIncreasingPathinaMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cur = dfs(matrix, Integer.MIN_VALUE, i, j, m, n, cache);
                res = Math.max(res, cur);
            }
        }
        return res;
    }
    private int dfs(int[][] matrix, int min, int i, int j, int m, int n, int[][] cache) {
        if (i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] <= min) return 0;
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        min = matrix[i][j];
        int a = dfs(matrix, min, i + 1, j, m, n, cache) + 1;
        int b = dfs(matrix, min, i - 1, j, m, n, cache) + 1;
        int c = dfs(matrix, min, i, j - 1, m, n, cache) + 1;
        int d = dfs(matrix, min, i, j + 1, m, n, cache) + 1;
        int max = Math.max(a, Math.max(b, Math.max(c, d)));
        cache[i][j] = max;
        return max;
    }
}
