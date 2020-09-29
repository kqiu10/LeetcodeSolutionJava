package ArrayList数组.二维数组;
/**
 * Package Name : 数组.二维数组;
 * File name : _59_SpiralMatrixII;
 * Creator: Kane;
 * Date: 8/12/20
 */

/**
 * Time complexity:O(n); n is the number of elements
 * Space complexity: O(n);
 * Description: TODO
 */
public class _59_SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n <= 0) return matrix;
        int rowStart = 0, rowEnd = n - 1;
        int colStart = 0, colEnd = n - 1;
        int ele = 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                matrix[rowStart][i] = ele++;
            }
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++) {
                matrix[i][colEnd] = ele++;
            }
            colEnd--;


            for (int i = colEnd; i >= colStart; i--) {
                matrix[rowEnd][i] = ele++;
            }
            rowEnd--;


            for (int i = rowEnd; i >= rowStart; i--) {
                matrix[i][colStart] = ele++;
            }
            colStart++;
        }
        return matrix;


    }
}
