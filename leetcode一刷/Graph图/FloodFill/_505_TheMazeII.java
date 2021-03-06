package leetcode.Graph图.FloodFill;
/**
 * Date: 9/24/20
 * Question Description
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by
 * rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball
 * stops, it could choose the next direction.
 *
 * Given the ball's start position, the destination and the maze, find the shortest distance for
 * the ball to stop at the destination. The distance is defined by the number of empty spaces
 * traveled by the ball from the start position (excluded) to the destination (included). If the
 * ball cannot stop at the destination, return -1.
 *
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space.
 * You may assume that the borders of the maze are all walls. The start and destination
 * coordinates are represented by row and column indexes.
 *
 *
 *
 * Example 1:
 *
 * Input 1: a maze represented by a 2D array
 *
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 *
 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 * Input 3: destination coordinate (rowDest, colDest) = (4, 4)
 *
 * Output: 12
 *
 * Explanation: One shortest way is : left -> down -> left -> down -> right -> down -> right.
 *              The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.
 *
 * Example 2:
 *
 * Input 1: a maze represented by a 2D array
 *
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 *
 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 * Input 3: destination coordinate (rowDest, colDest) = (3, 2)
 *
 * Output: -1
 *
 * Explanation: There is no way for the ball to stop at the destination.
 *
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: TODO
 * Time complexity:O(m * n);
 * Space complexity: O(m * n);

 */
public class _505_TheMazeII {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) return -1;
        int[][] dirs = new int[][]{{-1, 0},{1, 0}, {0, 1}, {0, -1}};
        int[][] dp = new int[maze.length][maze[0].length];
        for (int[] list : dp) {
            Arrays.fill(list, -1);
        }
        dp[start[0]][start[1]] = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(start[0], start[1]));

        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int[] dir : dirs) {
                int newX = cur.x;
                int newY = cur.y;
                int dist = dp[newX][newY];
                while (isValid(maze, newX + dir[0], newY + dir[1])) {
                    newX += dir[0];
                    newY += dir[1];
                    dist++;

                }
                if (dp[newX][newY] == -1 || dist < dp[newX][newY]) {
                    dp[newX][newY] = dist;
                    queue.offer(new Point(newX, newY));
                }
            }
        }
        return dp[destination[0]][destination[1]];

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
