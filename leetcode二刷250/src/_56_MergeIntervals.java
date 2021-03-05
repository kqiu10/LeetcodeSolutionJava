/**
 * Date: 3/4/21
 * Question Description:
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping
 * intervals, and return an array of the non-overlapping intervals that cover all the intervals
 * in the input.
 *
 *
 * <p>
 * Examples:
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n)
 */
public class _56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] <= end) {
                end = Math.max(end, interval[1]);
            } else {
                list.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        list.add(new int[]{start, end});
        return list.toArray(new int[list.size()][]);
    }
}
