package ArrayList数组.二维数组;
/**
 * Package Name : 数组.二维数组;
 * File name : _48_RotateImage;
 * Creator: Kane;
 * Date: 8/11/20
 */

/**
 * Time complexity:O(m * n);
 * Space complexity: O(1);
 * Description:
 * every rotate can be replaced by fold;
 * Ex
 * [
 * [1, 2, 3],
 * [4, 5, 6],
 * [7, 8, 9],
 * ]
 *
 * first time fold with diagonal to
 * [
 * [1, 4, 7],
 * [2, 5, 8],
 * [3, 6, 9],
 * ]
 *
 * second time fold with vertical line at the mid of the matrix
 * [
 * [7, 4, 1],
 * [8, 5, 2],
 * [9, 6, 3],
 * ]
 *
 */
public class _48_RotateImage {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length - 1 - j];
                matrix[i][matrix[0].length - 1 - j] = temp;
            }
        }

    }
}
