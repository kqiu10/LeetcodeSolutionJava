package leetcode.Graph图.FloodFill;
/**
 * Date: 9/24/20
 * Question Description
 * There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1).
 * The ball can go through the empty spaces by rolling up, down, left or right, but it won't stop
 * rolling until hitting a wall. When the ball stops, it could choose the next direction.
 *
 * Given the maze, the ball's start position and the destination, where start = [startrow,
 * startcol] and destination = [destinationrow, destinationcol], return true if the ball can stop
 * at the destination, otherwise return false.
 *
 * You may assume that the borders of the maze are all walls (see examples).
 *

 * Example 1:
 * Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4],
 * destination = [4,4]
 * Output: true
 * Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.
 *
 * Example 2:

 * Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4],
 * destination = [3,2]
 * Output: false
 * Explanation: There is no way for the ball to stop at the destination. Notice that you can pass
 * through the destination but you cannot stop there.
 * Example 3:
 *
 * Input: maze = [[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]], start = [4,3],
 * destination = [0,1]
 * Output: false
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: BFS
 * Time complexity:O(row * col);
 * Space complexity: O(row * col);

 */
public class _490_TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) return false;
        int[][] dirs = new int[][]{{-1, 0},{1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(start[0], start[1]));

        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            visited[cur.x][cur.y] = true;
            if (cur.x == destination[0] && cur.y == destination[1]) {
                return true;
            }
            for (int[] dir : dirs) {
                int newX = cur.x;
                int newY = cur.y;
                while (isValid(maze, newX + dir[0], newY + dir[1])) {
                    newX += dir[0];
                    newY += dir[1];
                }
                if (!visited[newX][newY]) {
                    queue.offer(new Point(newX, newY));
                }
            }
        }
        return false;

    }
    private boolean isValid(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0;
    }

    class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
