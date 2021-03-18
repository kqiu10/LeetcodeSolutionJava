package src; /**
 * Date: 11/6/20
 * Question Description
 */

/**
 * Description: TODO
 * Time complexity:O(n ^ 2);
 * Space complexity: O(n ^ 2);

 */
public class _59_SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if (n <= 0) return new int[][]{};
        int[][] res = new int[n][n];
        int startRow = 0;
        int endRow = n - 1;
        int startCol = 0;
        int endCol = n - 1;
        int start = 1;
        while (startRow <= endRow && startCol <= endCol) {
            for (int i = startCol; i <= endCol; i++) {
                res[startRow][i] = start++;
            }
            startRow++;
            for (int i = startRow; i <= endRow; i++) {
                res[i][endCol] = start++;
            }
            endCol--;
            if (startRow <= endRow && startCol <= endCol) {
                for (int i = endCol; i >= startCol; i--) {
                    res[endRow][i] = start++;
                }
                endRow--;
            }
            if (startRow <= endRow && startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    res[i][startCol] = start++;
                }
                startCol++;
            }
        }
        return res;
    }
}
