package ArrayList数组.实现题;
/**
 * Package Name : 数组.实现题;
 * File name : _296_BestMeetingPoint;
 * Creator: Kane;
 * Date: 8/10/20
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Time complexity:O(m*n);
 * Space complexity: O(max(m,n));
 * Description: TODO
 */
public class _296_BestMeetingPoint {
    public static int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> row = new ArrayList<>();
        List<Integer> column = new ArrayList<>();
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    row.add(i);
                }
            }
        }
        for (int j = 0; j < n; j ++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    column.add(j);
                }
            }
        }
        return min(row) + min(column);
    }
    public static int min(List<Integer> list) {
        int res = 0;
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            res += (list.get(r--) - list.get(l++));
        }
        return res;

    }

    public static void main(String[] args) {
        minTotalDistance(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}});
    }
}
