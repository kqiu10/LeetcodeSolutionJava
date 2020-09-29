package ArrayList数组.区间问题;
/**
 * Package Name : 数组.区间问题;
 * File name : _56_MergeIntervals;
 * Creator: Kane;
 * Date: 8/1/20
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class _56_MergeIntervals {
    public static  int[][] merge(int[][] intervals) {
        if (intervals.length <= 1 || intervals == null) return intervals;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        ArrayList<int[]> res = new ArrayList<>();
        for (int[] interval :intervals) {
            if (interval[0] <= end) {
                end = Math.max(end, interval[1]);
            } else {
                res.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {

    }
}
