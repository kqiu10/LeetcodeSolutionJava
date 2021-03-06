package leetcode.Graph图.FloodFill;
/**
 * Date: 9/25/20
 * Question Description
 You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

 Each 0 marks an empty land which you can pass by freely.
 Each 1 marks a building which you cannot pass through.
 Each 2 marks an obstacle which you cannot pass through.
 Example:

 Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]

 1 - 0 - 2 - 0 - 1
 |   |   |   |   |
 0 - 0 - 0 - 0 - 0
 |   |   |   |   |
 0 - 0 - 1 - 0 - 0

 Output: 7

 Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
 the point (1,2) is an ideal empty land to build a house, as the total
 travel distance of 3+3+1=7 is minimal. So return 7.
 *
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: TODO
 * Time complexity:O( (row * col) * (row * col));
 * Space complexity: O(row * col);

 */
public class _317_ShortestDistancefromAllBuildings {

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        int[][] nums = new int[m][n];

        int buildingNums = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    buildingNums++;
                    bfs(grid, i, j, m, n, dist, nums);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && nums[i][j] == buildingNums && dist[i][j] != 0) {
                    res = Math.min(res, dist[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void bfs(int[][] grid, int row, int col, int m, int n, int[][] dist, int[][] nums) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});

        boolean[][] visited = new boolean[m][n];
        visited[row][col] = true;
        int distance = 0;

        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int newX = cur[0] + dir[0];
                    int newY = cur[1] + dir[1];

                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY] && grid[newX][newY] == 0) {
                        nums[newX][newY]++;
                        dist[newX][newY] += distance;
                        visited[newX][newY] = true;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }

    }
}
