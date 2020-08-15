package BinarySearch二分查找.二维数组;
/**
 * Package Name : BinarySearch二分查找.二维数组;
 * File name : Searcha2DMatrixII240;
 * Creator: Kane;
 * Date: 8/15/20
 */

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the
 * following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * Example:
 *
 * Consider the following matrix:
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 *
 * Given target = 20, return false.
 *
 * Time complexity:O(m + n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class Searcha2DMatrixII240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int row = 0;
        int col = matrix[0].length - 1;
        while (col >= 0 && row <= matrix.length - 1) {
            if (target == matrix[row][col]) return true;
            else if (target < matrix[row][col]) {
                col--;
            } else row++;
        }
        return false;

    }
}
