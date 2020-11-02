package leetcode.Graph图.FloodFill;
/**
 * Date: 9/25/20
 * Question Description
 * Given an m x n matrix of positive integers representing the height of each unit cell in a 2D
 * elevation map, compute the volume of water it is able to trap after raining.
 *
 * Example:
 *
 * Given the following 3x6 height map:
 * [
 *   [1,4,3,1,3,2],
 *   [3,2,1,3,2,4],
 *   [2,3,3,2,3,1]
 * ]
 *
 * Return 4.
 *
 * The above image represents the elevation map [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
 * before the rain.
 *
 * After the rain, water is trapped between the blocks. The total volume of water trapped is 4.
 */

import java.util.PriorityQueue;

/**
 * Description:
 * Ex
 * [
 *   [1,4,3,1,3,2],
 *   [3,2,1,3,2,4],
 *   [2,3,3,2,3,1]
 * ]
 *
 * Time complexity:O(row * col * log(2m + 2n - 4));
 * Space complexity: O(row * col);

 */
public class _407_TrappingPainWaterII {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length <= 1 || heightMap[0].length <= 1) return 0;

        int row = heightMap.length;
        int col = heightMap[0].length;
        int res = 0;
        boolean[][] visited = new boolean[row][col];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                    pq.offer(new int[]{i, j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }

        }
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x >= 0 && x < row && y >= 0 && y < col && !visited[x][y]) {
                    visited[x][y] = true;
                    res += Math.max(0, cur[2] - heightMap[x][y]);
                    pq.offer(new int[]{x, y, Math.max(cur[2],heightMap[x][y])});
                }
            }
        }
        return res;
    }

}
