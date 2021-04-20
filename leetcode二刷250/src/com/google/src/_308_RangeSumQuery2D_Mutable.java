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
 * Time Complexity: O()
 * Space Complexity: O()
 */
public class _308_RangeSumQuery2D_Mutable {

    int[][] matrix;

    public _308_RangeSumQuery2D_Mutable(int[][] matrix) {
        this.matrix = matrix;
    }


    public void update(int row, int col, int val) {
        matrix[row][col] = val;

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                res += matrix[i][j];
            }
        }
        return res;
    }

}
