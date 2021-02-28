/**
 * Date: 2/27/21
 * Question Description:
 * <p>
 * Examples:
 */

import java.util.LinkedList;
import java.util.List;

/**
 * Time Complexity: O(m*n)
 * Space Complexity: O(m*n)
 */
public class _54_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd= matrix[0].length - 1;
        List<Integer> res = new LinkedList<>();
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                res.add(matrix[rowStart][i]);
            }
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;

            if (colStart <= colEnd && rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    res.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }

            if (colStart <= colEnd && rowStart <= rowEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    res.add(matrix[i][colStart]);
                }
                colStart++;
            }
        }
        return res;
    }
}
