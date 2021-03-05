/**
 * Date: 3/4/21
 * Question Description:
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * Examples:
 * Example 1:
 *
 *
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * Example 2:
 *
 * Input: n = 1
 * Output: [[1]]
 */

/**
 * Time Complexity: O(n*n)
 * Space Complexity: O(1)
 */
public class _59_SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if (n == 1) return new int[][]{{1}};
        int[][] res = new int[n][n];
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        int count = 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                res[rowStart][i] = count++;
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) {
                res[i][colEnd] = count++;
            }
            colEnd--;
            if (rowStart  <= rowEnd && colStart <= colEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    res[rowEnd][i] = count++;
                }
                rowEnd--;
            }
            if (rowStart  <= rowEnd && colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    res[i][colStart] = count++;
                }
                colStart++;
            }

        }
        return res;

    }
}
