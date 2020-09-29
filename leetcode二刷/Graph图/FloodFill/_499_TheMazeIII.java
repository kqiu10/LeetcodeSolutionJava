package leetcode.Graph图.FloodFill;
/**
 * Date: 9/24/20
 * Question Description
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by
 * rolling up (u), down (d), left (l) or right (r), but it won't stop rolling until hitting a
 * wall. When the ball stops, it could choose the next direction. There is also a hole in this
 * maze. The ball will drop into the hole if it rolls on to the hole.
 *
 * Given the ball position, the hole position and the maze, find out how the ball could drop into
 * the hole by moving the shortest distance. The distance is defined by the number of empty
 * spaces traveled by the ball from the start position (excluded) to the hole (included). Output
 * the moving directions by using 'u', 'd', 'l' and 'r'. Since there could be several different
 * shortest ways, you should output the lexicographically smallest way. If the ball cannot reach
 * the hole, output "impossible".
 *
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space.
 * You may assume that the borders of the maze are all walls. The ball and the hole coordinates
 * are represented by row and column indexes.
 *
 *
 *
 * Example 1:
 *
 * Input 1: a maze represented by a 2D array
 *
 * 0 0 0 0 0
 * 1 1 0 0 1
 * 0 0 0 0 0
 * 0 1 0 0 1
 * 0 1 0 0 0
 *
 * Input 2: ball coordinate (rowBall, colBall) = (4, 3)
 * Input 3: hole coordinate (rowHole, colHole) = (0, 1)
 *
 * Output: "lul"
 *
 * Explanation: There are two shortest ways for the ball to drop into the hole.
 * The first way is left -> up -> left, represented by "lul".
 * The second way is up -> left, represented by 'ul'.
 * Both ways have shortest distance 6, but the first way is lexicographically smaller because 'l'
 * < 'u'. So the output is "lul".
 *
 */

import java.util.PriorityQueue;

/**
 * Description: TODO
 * Time complexity:O(m * m * logn);
 * Space complexity: O(m * n);

 */
public class _499_TheMazeIII {
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int[][] dirs = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        String[] ori = new String[]{"d", "u", "r", "l"};

        boolean[][] visited = new boolean[maze.length][maze[0].length];

        Point point = new Point(ball[0], ball[1], 0, "");
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(point);

        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            if (cur.x == hole[0] && cur.y == hole[1]) {
                return cur.ori;
            }
            visited[cur.x][cur.y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = cur.x;
                int newY = cur.y;
                int dist = cur.dist;
                String curOri = cur.ori;


                while (isValid(maze, newX + dirs[i][0], newY + dirs[i][1])) {
                    if (newX == hole[0] && newY == hole[1]) {
                            break;
                    }
                    newX += dirs[i][0];
                    newY += dirs[i][1];
                    dist++;
                }
                if (!visited[newX][newY]) {
                    pq.offer(new Point(newX, newY, dist, curOri + ori[i]));
                }
            }
        }
        return "impossible";

    }

    private boolean isValid(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0;
    }

    class Point implements Comparable<Point>{
        int x;
        int y;
        int dist;
        String ori;

        Point(int x, int y, int dist, String ori) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.ori = ori;
        }

        public int compareTo (Point other) {
            return this.dist == other.dist ? this.ori.compareTo(other.ori) : this.dist - other.dist;
        }
    }
}
