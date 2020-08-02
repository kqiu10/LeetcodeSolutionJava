package 数组.区间问题;
/**
 * Package Name : 数组.区间问题;
 * File name : NonoverlappingIntervals435;
 * Creator: Kane;
 * Date: 8/1/20
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * Time complexity:O(nlogn);
 * Space complexity: O(1);
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

/**
 * Time complexity:O(nlogn);
 * Space complexity: O(1);
 */

class NonoverlappingIntervalsII {
    public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) return o1[1] - o2[1];
                //start倒序排列
                else return o2[0] - o1[0];
            }
        });
        int res = 0;
        int end = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (interval[0] > end) {
                end = interval[1];
            } else {
                res++;
            }
        }
        return res;
    }
}
