/**
 * Date: 12/3/20
 * Question Description
 A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example:

 Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
 Output: [1,1,2,3]
 Explanation:

 Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

 0 0 0
 0 0 0
 0 0 0
 Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

 1 0 0
 0 0 0   Number of islands = 1
 0 0 0
 Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

 1 1 0
 0 0 0   Number of islands = 1
 0 0 0
 Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

 1 1 0
 0 0 1   Number of islands = 2
 0 0 0
 Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

 1 1 0
 0 0 1   Number of islands = 3
 0 1 0
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: TODO
 * Time complexity:O(len(m)^2);
 * Space complexity: O(m * n);

 */
public class _305_NumberofIslandsII {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (m <= 0 || n <= 0) return res;
        int count = 0;
        int[] unions = new int[m * n];

        Arrays.fill(unions, -1);

        for (int[] position : positions) {
            int cur = n * position[0] + position[1];
            if (unions[cur] != -1) {
                res.add(count);
                continue;
            }
            unions[cur] = cur;
            count++;

            for (int[] dir : dirs) {
                int x = position[0] + dir[0];
                int y = position[1] + dir[1];
                int next = n * x + y;
                if (x < 0 || x >= m || y < 0 || y >= n || unions[next] == -1) continue;

                int anotherIsland = find(unions, next);
                //发现岛屿的起点
                if (cur != anotherIsland) {
                    unions[cur] = anotherIsland;
                    cur = anotherIsland;
                    count--;
                }
            }
            res.add(count);
        }

        return res;
    }
    private int find(int[] unions, int i) {
        while (unions[i] != i) {
            i = unions[i];
        }
        return i;
    }
}
