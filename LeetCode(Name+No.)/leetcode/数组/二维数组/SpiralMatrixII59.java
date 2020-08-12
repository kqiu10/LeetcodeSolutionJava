package 数组.二维数组;
/**
 * Package Name : 数组.二维数组;
 * File name : SpiralMatrixII59;
 * Creator: Kane;
 * Date: 8/12/20
 */

/**
 * Time complexity:O(m * n); m * n is the number of elements
 * Space complexity: O(m * n);
 * Description: TODO
 */
public class SpiralMatrixII59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n <= 0) return matrix;
        int rowStart = 0, rowEnd = n - 1;
        int colStart = 0, colEnd = n - 1;
        int ele = 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                matrix[rowStart][i] = ele;
                ele++;
            }
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++) {
                matrix[i][colEnd] = ele;
                ele++;
            }
            colEnd--;

            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    matrix[rowEnd][i] = ele;
                    ele++;
                }
                rowEnd--;
            }

            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    matrix[i][colStart] = ele;
                    ele++;
                }
                colStart++;
            }
        }
        return matrix;


    }
}
