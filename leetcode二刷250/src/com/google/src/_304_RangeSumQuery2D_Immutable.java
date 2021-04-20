package com.google.src;
/**
 * Date: 4/20/21
 * Question Description:
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its
 * upper left corner (row1, col1) and lower right corner (row2, col2).
 *
 * Implement the NumMatrix class:
 *
 * NumMatrix(int[][] matrix) initializes the object with the integer matrix matrix.
 * int sumRegion(int row1, int col1, int row2, int col2) returns the sum of the elements of the
 * matrix array inside the rectangle defined by its upper left corner (row1, col1) and lower
 * right corner (row2, col2).
 * <p>
 * Examples:
 *
 * Example 1:
 * Input
 * ["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
 * [[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2,
 * 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
 * Output
 * [null, 8, 11, 12]
 *
 * Explanation
 * NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1,
 * 0, 1, 7], [1, 0, 3, 0, 5]]);
 * numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangele).
 * numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangele).
 * numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangele).
 */

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class _304_RangeSumQuery2D_Immutable {
    int[][] sum;

    public _304_RangeSumQuery2D_Immutable(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row2  +1][col1] - sum[row1][col2 + 1] + sum[row1][col1];
    }
}
