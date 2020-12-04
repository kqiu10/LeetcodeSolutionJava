/**
 * Date: 12/4/20
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
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: TODO
 * Time complexity:O(m^2n^2);
 * Space complexity: O(m * n);

 */
public class _317_ShortestDistancefromAllBuildings {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int m = grid.length;
        int n = grid[0].length;
        int total = 0;

        int[][] dists = new int[m][n];
        int[][] nums = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    total++;
                    bfs(grid, i, j, m, n, dists, nums);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && nums[i][j] == total) {
                    res = Math.min(res, dists[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;

    }

    private void bfs(int[][] grid, int i, int j, int m, int n, int[][] dists, int[][] nums) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        visited[i][j] = true;
        int distance = 0;

        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for (int k = 0; k < size; k++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && grid[x][y] == 0) {
                        dists[x][y] += distance;
                        nums[x][y]++;
                        visited[x][y] = true;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
    }
}
