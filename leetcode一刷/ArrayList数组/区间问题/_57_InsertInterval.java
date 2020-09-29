package ArrayList数组.区间问题;
/**
 * Package Name : 数组.区间问题;
 * File name : _57_InsertInterval;
 * Creator: Kane;
 * Date: 8/1/20
 */

import java.util.ArrayList;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _57_InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null) return intervals;
        int len = intervals.length;
        ArrayList<int[]> res = new ArrayList<>();
        int i = 0;
        while (i < len && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i++]);
        }
        while (i < len && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);
        while (i < len && intervals[i][0] > newInterval[1]) {
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        int[][] ls = new int[][]{{1,2},{3,5},{6,7},{8,9},{10,16,17}};
        int[] insert = new int[]{4,8};
        System.out.println(insert(ls,insert));
    }
}
