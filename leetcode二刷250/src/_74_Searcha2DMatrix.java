/**
 * Date: 3/8/21
 * Question Description:
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the
 * following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * <p>
 * Examples:
 * Example 1:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * Example 2:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 *
 */

/**
 * Time Complexity: O(log(m * n))
 * Space Complexity: O(1)
 */
public class _74_Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m * n - 1;
        while (l + 1 < r) {
            int mid = (r - l) / 2 + l;
            if (matrix[mid / n][mid % n] == target) return true;
            else if (matrix[mid / n][mid % n] > target) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return matrix[r / n][r % n] == target || matrix[l / n][l % n] == target;
    }
}
