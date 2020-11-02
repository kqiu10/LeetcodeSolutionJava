package leetcode.Graph图.FloodFill;
/**
 * Date: 9/25/20
 * Question Description
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

 Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

 Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

 Note:

 The order of returned grid coordinates does not matter.
 Both m and n are less than 150.


 Example:

 Given the following 5x5 matrix:

 Pacific ~   ~   ~   ~   ~
 ~  1   2   2   3  (5) *
 ~  3   2   3  (4) (4) *
 ~  2   4  (5)  3   1  *
 ~ (6) (7)  1   4   5  *
 ~ (5)  1   1   2   4  *
 *   *   *   *   * Atlantic

 Return:

 [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 * Description: TODO
 * Time complexity:O(row * col);
 * Space complexity: O(row * col);

 */
public class _417_PacificAtlanticWaterFlow {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new LinkedList<>();
        int row = matrix.length;
        if (row == 0) return res;
        int col = matrix[0].length;

        boolean[][] pac = new boolean[row][col];
        boolean[][] atl = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            helper(matrix, pac, i, 0, row, col);
            helper(matrix, atl, i, col - 1, row, col);
        }

        for (int i = 0; i < col; i++) {
            helper(matrix, pac, 0, i, row, col);
            helper(matrix, atl, row - 1, i, row, col);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pac[i][j] && atl[i][j]) {
                    int[] cur = new int[]{i, j};
                    res.add(Arrays.stream(cur).boxed().collect(Collectors.toList()));
                }
            }
        }
        return res;
    }

    private void helper(int[][] matrix, boolean[][] isVisited, int i, int j, int row, int col) {
        isVisited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < row && y >= 0 && y < col && !isVisited[x][y]) {
                if (matrix[x][y] >= matrix[i][j]) {
                    helper(matrix, isVisited, x, y, row, col);
                }
            }
        }
    }
}
