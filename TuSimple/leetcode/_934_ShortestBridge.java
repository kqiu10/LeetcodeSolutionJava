/**
 * Date: 2/28/21
 * Question Description:
 * In a given 2D binary array A, there are two islands.  (An island is a 4-directionally
 * connected group of 1s not connected to any other 1s.)
 *
 * Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
 *
 * Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is
 * at least 1.)
 * <p>
 * Examples:
 * Example 1:
 *
 * Input: A = [[0,1],[1,0]]
 * Output: 1
 * Example 2:
 *
 * Input: A = [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 * Example 3:
 *
 * Input: A = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Use DFS + BFS to solve this WONDERFUL problem!
 * Step 1: use DFS to mark the first island to another number
 * Step 2: start from the first island, doing BFS level order traversal to find number of bridges (levels)
 * until reach the second island
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class _934_ShortestBridge {
    public int shortestBridge(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int distance = 0;
        //dfs
        for (int i = 0; i < row; i++) {
            if (found) {
                break;
            }
            for (int j = 0; j < col; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j, row, col, queue);
                    found = true;
                    break;
                }
            }
        }
        //bfs
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int newRow = cur[0] + dir[0];
                    int newCol = cur[1] + dir[1];
                    if (newRow < 0 || newRow >= row || newCol < 0 || newCol >= col || A[newRow][newCol] == 2) continue;
                    if (A[newRow][newCol] == 1) {
                        return distance;
                    } else {
                        A[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
            distance++;
        }
        return distance;
    }
    private void dfs(int[][] A, int i, int j, int row, int col, Queue<int[]> queue) {
        if (i < 0 || i >= row || j < 0 || j >= col || A[i][j] == 0 || A[i][j] == 2) return;
        A[i][j] = 2;
        queue.offer(new int[]{i, j});
        dfs(A, i + 1, j, row, col, queue);
        dfs(A, i - 1, j, row, col, queue);
        dfs(A, i, j - 1, row, col, queue);
        dfs(A, i, j + 1, row, col, queue);
    }
}
