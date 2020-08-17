package 数组.二维数组;
/**
 * Package Name : 数组.二维数组;
 * File name : SpiralMatrix54;
 * Creator: Kane;
 * Date: 8/12/20
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Time complexity:O(m * n); m * n is the number of elements
 * Space complexity: O(m * n);
 * Description: TODO
 */
public class SpiralMatrix54 {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix == null || matrix[0].length == 0) return res;
        int rowStart = 0, rowEnd = matrix.length - 1;
        int colStart = 0, colEnd = matrix[0].length - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                res.add(matrix[rowStart][i]);
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    res.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    res.add(matrix[i][colStart]);
                }
                colStart++;
            }
        }
        return res;

    }
}
