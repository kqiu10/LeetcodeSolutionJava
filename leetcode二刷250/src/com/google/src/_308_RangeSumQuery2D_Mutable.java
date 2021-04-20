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
 * void update(int row, int col, int val) updates the value of matrix[row][col] to be val.
 * int sumRegion(int row1, int col1, int row2, int col2) returns the sum of the elements of the
 * matrix array inside the rectangle defined by its upper left corner (row1, col1) and lower
 * right corner (row2, col2).
 *
 * <p>
 * Examples:
 *
 * Example 1:
 * Input
 * ["NumMatrix", "sumRegion", "update", "sumRegion"]
 * [[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2,
 * 1, 4, 3], [3, 2, 2], [2, 1, 4, 3]]
 * Output
 * [null, 8, null, 10]
 *
 * Explanation
 * NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1,
 * 0, 1, 7], [1, 0, 3, 0, 5]]);
 * numMatrix.sumRegion(2, 1, 4, 3); // return 8
 * numMatrix.update(3, 2, 2);
 * numMatrix.sumRegion(2, 1, 4, 3); // return 10
 */

/**
 * Time Complexity: O(logn)
 * Space Complexity: O(n)
 */
public class _308_RangeSumQuery2D_Mutable {
    int[][] tree;
    int[][] nums;
    int m;
    int n;
    public _308_RangeSumQuery2D_Mutable(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        tree = new int[m + 1][n + 1];
        nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }


    public void update(int row, int col, int val) {
        if (m == 0 || n == 0) return;
        int diff = val - nums[row][col];
        nums[row][col] = val;
        for (int i = row + 1; i <= m; i += (i & (-i))) {
            for (int j = col + 1; j <= n; j += (j & (-j))) {
                tree[i][j] += diff;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum(row2 + 1, col2 + 1) + sum(row1, col1) - sum(row1, col2 + 1) - sum(row2 + 1, col1);
    }

    private int sum(int row, int col) {
        int res = 0;
        for (int k = row; k > 0; k -= ((k & -k))) {
            for (int l = col; l > 0; l -= ((l & -l))) {
                res += tree[k][l];
            }
        }
        return res;
    }

}
