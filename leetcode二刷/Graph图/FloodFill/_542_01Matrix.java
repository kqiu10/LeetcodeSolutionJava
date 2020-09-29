package leetcode.Graph图.FloodFill;
/**
 * Date: 9/26/20
 * Question Description
 Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

 The distance between two adjacent cells is 1.



 Example 1:

 Input:
 [[0,0,0],
 [0,1,0],
 [0,0,0]]

 Output:
 [[0,0,0],
 [0,1,0],
 [0,0,0]]
 Example 2:

 Input:
 [[0,0,0],
 [0,1,0],
 [1,1,1]]

 Output:
 [[0,0,0],
 [0,1,0],
 [1,2,1]]
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: TODO
 * Time complexity:O(row * col);
 * Space complexity: O(1);

 */
public class _542_01Matrix {
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < 0 || x >= row || y < 0 || y >= col || matrix[x][y] <= (matrix[cur[0]][cur[1]] + 1)) continue;
                matrix[x][y] = matrix[cur[0]][cur[1]] + 1;
                queue.offer(new int[]{x, y});
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}});
    }
}
