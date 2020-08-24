package BinarySearch二分查找.二维数组;
/**
 * Package Name : BinarySearch二分查找.二维数组;
 * File name : _74_Searcha2DMatrix;
 * Creator: Kane;
 * Date: 8/15/20
 */

/**
 * Time complexity:O(log(m * n));
 * Space complexity: O(1);
 * Description: TODO
 */
public class _74_Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0, end = row * col - 1;
        while (start <= end) {
            int pivot = (end - start) / 2 + start;
            if (target == matrix[pivot / col][pivot % col]) return true;
            else if (target < matrix[pivot / col][pivot % col]) end = pivot - 1;
            else start = pivot + 1;
        }
        return false;
    }
}
