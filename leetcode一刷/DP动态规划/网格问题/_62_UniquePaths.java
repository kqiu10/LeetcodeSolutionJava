package DP动态规划.网格问题;
/**
 * Date: 10/23/20
 * Question Description
 A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time.
 The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 How many possible unique paths are there?

 Example 1:
 Input: m = 3, n = 7
 Output: 28
 Example 2:

 Input: m = 3, n = 2
 Output: 3
 Explanation:
 From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 1. Right -> Down -> Down
 2. Down -> Down -> Right
 3. Down -> Right -> Down
 Example 3:

 Input: m = 7, n = 3
 Output: 28
 Example 4:

 Input: m = 3, n = 3
 Output: 6
 */

public class _62_UniquePaths {
    /**
     * Description: Brute Forth
     * Time complexity:O(m * n);
     * Space complexity: O(m * n);

     */
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            res[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            res[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }
        return res[m - 1][n - 1];

    }
    /**
     * Description: O(n) Time Complexity
     * Time complexity:O(m * n);
     * Space complexity: O(n);
     */
    public int uniquePathsII(int m, int n) {
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[j] = res[j] + res[j - 1];
            }
        }
        return res[n - 1];
    }

}
