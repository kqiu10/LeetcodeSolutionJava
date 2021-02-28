/**
 * Date: 2/27/21
 * Question Description:
 * You are given an m x n grid where each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes
 * rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If
 * this is impossible, return -1.
 * <p>
 * Examples:
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class _994_RottingOranges {
    public static int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;
        int freshOrange = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOrange++;
                }
            }
        }
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int newRow = cur[0] + dir[0];
                    int newCol = cur[1] + dir[1];
                    if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length
                            || grid[newRow][newCol] == 2 || grid[newRow][newCol] == 0) continue;
                    grid[newRow][newCol] = 2;
                    queue.offer(new int[]{newRow, newCol});
                    freshOrange--;
                }
            }
            if (queue.size() > 0) {
                time++;
            }
        }
        return freshOrange == 0 ? time : -1;
    }

    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{{1,1,2},{2,1,1},{1,1,1}}));
    }
}
