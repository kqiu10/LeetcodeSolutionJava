package src;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 11/29/20
 * Question Description
 You are given a m x n 2D grid initialized with these three possible values.

 -1 - A wall or an obstacle.
 0 - A gate.
 INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

 Example:
 Given the 2D grid:
 INF  -1  0  INF
 INF INF INF  -1
 INF  -1 INF  -1
 0  -1 INF INF

 After running your function, the 2D grid should be:
 3  -1   0   1
 2   2   1  -1
 1  -1   2  -1
 0  -1   3   4
 */


public class _286_WallsandGates {
    /**
     * Description: DFS
     * Time complexity:O(m * n);
     * Space complexity: O(m);
     */
    public static void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
        return;
    }
    private static void dfs(int[][] rooms, int i, int j, int dis) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < dis) return;
        rooms[i][j] = dis;
        dfs(rooms, i + 1, j, dis + 1);
        dfs(rooms, i - 1, j, dis + 1);
        dfs(rooms, i, j + 1, dis + 1);
        dfs(rooms, i, j - 1, dis + 1);
    }

    /**
     * Description: Queue(BFS)
     * Time complexity:O(m * n);
     * Space complexity: O(m);
     */
    public void wallsAndGatesII(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;
        int m = rooms.length, n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int row = cur[0], col = cur[1];
            int num = rooms[row][col];
            if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
                rooms[row - 1][col] = num + 1;
                queue.offer(new int[]{row - 1, col});
            }
            if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
                rooms[row][col - 1] = num + 1;
                queue.offer(new int[]{row, col - 1});
            }
            if (row < m - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
                rooms[row + 1][col] = num + 1;
                queue.offer(new int[]{row + 1, col});
            }
            if (col < n - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
                rooms[row][col + 1] = num + 1;
                queue.offer(new int[]{row, col + 1});
            }
        }
    }

    public static void main(String[] args) {
        wallsAndGates(new int[][] {});
    }
}
