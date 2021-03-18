package src; /**
 * Date: 11/6/20
 * Question Description
 Given a collection of intervals, merge all overlapping intervals.
 Example 1:

 Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 Output: [[1,6],[8,10],[15,18]]
 Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 Example 2:

 Input: intervals = [[1,4],[4,5]]
 Output: [[1,5]]
 Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.


 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;
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
