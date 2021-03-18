package src; /**
 * Date: 12/10/20
 * Question Description
 Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
 The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
 Note: You can only put the bomb at an empty cell.

 Example:

 Input: [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
 Output: 3
 Explanation: For the given grid,

 0 E 0 0
 E 0 W E
 0 E 0 0

 Placing a bomb at (1,1) kills 3 enemies.
 */

/**
 * Description: TODO
 * Time complexity:O(m * n);
 * Space complexity: O(n);

 */
public class _361_BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int rowCount = 0;
        int[] colCount = new int[n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowCount = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; k++) {
                        rowCount += grid[i][k] == 'E' ? 1 : 0;
                    }
                }
                if (i == 0 || grid[i - 1][j] == 'W') {
                    colCount[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; k++) {
                        colCount[j] += grid[k][j] == 'E' ? 1 : 0;
                    }
                }
                if (grid[i][j] == '0') {
                    res = Math.max(res, rowCount + colCount[j]);
                }
            }
        }
        return res;
    }
}
