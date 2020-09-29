package leetcode.Graph图.FloodFill;
/**
 * Date: 9/24/20
 * Question Description
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is
 * surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You
 * may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 */

/**
 * Description: TODO
 * Time complexity:O(m * n); m == row, n == col
 * Space complexity: O(n);

 */
public class _200_NumberofIslands {
    static int[][] dirs = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    public static int numIslands(char[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0) return res;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    helper(grid, i, j);
                }
            }
        }
        return res;
    }
    private static void helper(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || y >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') continue;
            grid[x][y] = '0';
            helper(grid,x, y);
        }
    }

    public static void main(String[] args) {
        numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}});
    }
}
