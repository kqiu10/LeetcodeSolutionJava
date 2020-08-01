package 数组.区间问题;
/**
 * Package Name : 数组.区间问题;
 * File name : NonoverlappingIntervals435;
 * Creator: Kane;
 * Date: 8/1/20
 */

import java.util.Arrays;

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class NonoverlappingIntervals435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int res = 0;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] >= end) {
                end = interval[1];
            } else {
                res++;
            }
        }
        return res;
    }
}
