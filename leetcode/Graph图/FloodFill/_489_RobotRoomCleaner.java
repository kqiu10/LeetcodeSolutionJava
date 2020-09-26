package leetcode.Graph图.FloodFill;
/**
 * Date: 9/25/20
 * Question Description
 Given a robot cleaner in a room modeled as a grid.

 Each cell in the grid can be empty or blocked.

 The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made is 90 degrees.

 When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.

 Design an algorithm to clean the entire room using only the 4 given APIs shown below.

 interface Robot {
 // returns true if next cell is open and robot moves into the cell.
 // returns false if next cell is obstacle and robot stays on the current cell.
 boolean move();

 // Robot will stay on the same cell after calling turnLeft/turnRight.
 // Each turn will be 90 degrees.
 void turnLeft();
 void turnRight();

 // Clean the current cell.
 void clean();
 }
 Example:

 Input:
 room = [
 [1,1,1,1,1,0,1,1],
 [1,1,1,1,1,0,1,1],
 [1,0,1,1,1,1,1,1],
 [0,0,0,1,0,0,0,0],
 [1,1,1,1,1,1,1,1]
 ],
 row = 1,
 col = 3

 Explanation:
 All grids in the room are marked by either 0 or 1.
 0 means the cell is blocked, while 1 means the cell is accessible.
 The robot initially starts at the position of row=1, col=3.
 From the top left corner, its position is one row below and three columns right.
 */

import java.util.HashSet;

/**
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

 */
public class _489_RobotRoomCleaner {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public void cleanRoom(Robot robot) {
        backtracking(robot, 0, 0, 0, new HashSet<>());
    }

    private void backtracking(Robot robot, int x, int y, int curDir, HashSet<String> visited) {
        if (visited.contains(x + "-" + y)) {return;}

        visited.add(x + "-" + y);
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int nextDir = (curDir + i) % 4;
            int newX = x + dirs[nextDir][0];
            int newY = y + dirs[nextDir][1];
            if (!visited.contains(newX + "-" + newY) && robot.move()) {
                backtracking(robot, newX, newY, nextDir, visited);
                robot.turnRight();
            }
            robot.turnRight();
            robot.turnRight();
            robot.move();
            robot.turnRight();
            robot.turnRight();
        }
    }



    interface Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current cell.
        public boolean move();

        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        public void turnLeft();

        public void turnRight();

        // Clean the current cell.
        public void clean();
    }
}
