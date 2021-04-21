package com.google.src;
/**
 * Date: 4/21/21
 * Question Description:
 * You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows
 * x columns, where heights[row][col] represents the height of cell (row, col). You are situated
 * in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1,
 * columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a
 * route that requires the minimum effort.
 *
 * A route's effort is the maximum absolute difference in heights between two consecutive cells
 * of the route.
 *
 * Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
 * <p>
 * Examples:
 */

import java.util.PriorityQueue;

/**
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n)
 */
public class _1631_PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = heights.length;
        int n = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        Integer[][] minDist = new Integer[m][n];
        minDist[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            if (x == m - 1 && y == n - 1) {
                return cur[2];
            }
            for (int[] dir : dirs) {
                int nx = dir[0] + x;
                int ny = dir[1] + y;
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                int effort = Math.max(cur[2], Math.abs(heights[cur[0]][cur[1]] - heights[nx][ny]));
                if (minDist[nx][ny] == null || minDist[nx][ny] > effort) {
                    minDist[nx][ny] = effort;
                    pq.offer(new int[]{nx, ny, minDist[nx][ny]});
                }

            }
        }
        return -1;
    }

}
