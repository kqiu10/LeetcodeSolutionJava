package DP动态规划.网格问题;
/**
 * Date: 10/23/20
 * Question Description
 A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 Now consider if some obstacles are added to the grids. How many unique paths would there be?
 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 Note: m and n will be at most 100.

 Example 1:

 Input:
 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 Output: 2
 Explanation:
 There is one obstacle in the middle of the 3x3 grid above.
 There are two ways to reach the bottom-right corner:
 1. Right -> Right -> Down -> Down
 2. Down -> Down -> Right -> Right
 */

/**
 * Description: TODO
 * Time complexity:O(n * m);
 * Space complexity: O(n);

 */
public class _63_UniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int len = obstacleGrid[0].length;
        int[] res = new int[len];
        res[0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    res[j] = 0;
                } else if (j > 0) {
                    res[j] = res[j] + res[j - 1];
                }


            }
        }
        return res[len - 1];
    }
}
