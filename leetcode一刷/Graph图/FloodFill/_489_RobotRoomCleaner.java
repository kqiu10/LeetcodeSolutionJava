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
 * Time complexity:O(unknown);
 * Space complexity: O(unknown);

 */
public class _489_RobotRoomCleaner {
    public void cleanRoom(Robot robot) {
        HashSet<String> cleaned = new HashSet(); // already cleaned cells
        //we will do DFS and mark accessible and uncleaned cells as cleaned by putting to cleaned set
        //use relative position from the initial position which can be assumed (0,0) and given north facing
        //BFS might make the robot move more
        dfs(0, 0, robot, cleaned, 0);    //dir 0=north, 1=east, 2=south, 3=west

    }

    private void dfs(int i, int j, Robot robot, HashSet<String> cleaned, int dir) {
        if (cleaned.contains(i + "," + j)) {
            return;
        }
        robot.clean();
        cleaned.add(i + "," + j);

        for (int d = 0; d < 4; d++) {     //tilt robot in all 4 dir
            robot.turnRight();
            dir++;
            dir %= 4;

            //create new coordinates, for new move in updated dir

            int x = i, y = j;   // preserve original i,j and create new x,y for current move
            if (dir == 0) x--;     //if new dir is north, then reduce row index
            else if (dir == 1) y++;//if new dir is east, then incr col index
            else if (dir == 2) x++;//if new dir is south, then incr row index
            else y--;           //if new dir is west, then reduce col index

            if (!cleaned.contains(x + "," + y) && robot.move()) {
                dfs(x, y, robot, cleaned, dir);

                //revert robot's position and direction using right -> right -> move -> right -> right (just like in standard backtrack we revert state)
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
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
