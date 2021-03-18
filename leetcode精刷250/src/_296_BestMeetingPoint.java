package src; /**
 * Date: 12/1/20
 * Question Description
 A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

 Example:

 Input:

 1 - 0 - 0 - 0 - 1
 |   |   |   |   |
 0 - 0 - 0 - 0 - 0
 |   |   |   |   |
 0 - 0 - 1 - 0 - 0

 Output: 6

 Explanation: Given three people living at (0,0), (0,4), and (2,2):
 The point (0,2) is an ideal meeting point, as the total travel distance
 of 2+2+2=6 is minimal. So return 6.
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class _296_BestMeetingPoint {
    /**
     * Description: TODO
     * Time complexity:O(m^2n^2);
     * Space complexity: O(mn);
     */
    class Node{
        int i;
        int j;
        int dist;
        public Node(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }
    public int minTotalDistance(int[][] grid) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int distance = bfs(grid, i, j, 0);
                res = Math.min(res, distance);
            }
        }
        return res;
    }

    private int bfs(int[][] grid, int i, int j, int dist) {
        Queue<Node> queue = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        queue.offer(new Node(i, j, dist));
        int totalDistance = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int r = cur.i;
            int c = cur.j;
            int d = cur.dist;

            if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c]) continue;
            if (grid[r][c] == 1) {
                totalDistance += d;
            }
            visited[i][j] = true;
            bfs(grid, i + 1, j, dist + 1);
            bfs(grid, i - 1, j, dist + 1);
            bfs(grid, i, j - 1, dist + 1);
            bfs(grid, i, j + 1, dist + 1);
        }
        return totalDistance;
    }

    /**
     * Description:
     * 1.降维
     * 2.找中位数
     * A     C   E  D       B
     * ______________________
     * Time complexity:O(m * n);
     * Space complexity: O(max(m, n));
     */
    public int minTotalDistanceII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> rows = new LinkedList<>();
        List<Integer> cols = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                }
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    cols.add(j);
                }
            }
        }
        return min(rows) + min(cols);
    }
    private int min(List<Integer> list) {
        int a = 0, b = list.size() - 1;
        int min = 0;
        while (a < b) {
            min += list.get(b--) - list.get(a++);
        }
        return min;
    }
}
