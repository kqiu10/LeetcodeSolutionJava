package src;

/**
 * Date: 11/7/20
 * Question Description
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 Example 1:

 Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
 Output: true
 Example 2:


 Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
 Output: false
 Example 3:

 Input: matrix = [], target = 0
 Output: false
 */


public class _74_Searcha2DMatrix {
    /**
     * Description: TODO
     * Time complexity:O(m * logn);
     * Space complexity: O(1);
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int i = 0;
        int lastCol = matrix[0].length - 1;
        while (i < matrix.length) {
            if (matrix[i][lastCol] < target) {
                i++;
            } else {
                if (matrix[i][0] > target) {
                    return false;
                } else {
                    return binarySearch(matrix[i], target);
                }
            }
        }
        return false;
    }
    private boolean binarySearch(int[] row, int target) {
        int l = 0;
        int r = row.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
    /**
     * Description: TODO
     * Time complexity:O(logmn);
     * Space complexity: O(1);
     */
    public boolean searchMatrixII(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0, end = m * n - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (matrix[mid / n][mid % n] == target) {
                return true;
            } else if (matrix[mid / n][mid % n] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
