/**
 * Date: 11/27/20
 * Question Description
 */

import java.util.Arrays;

/**
 * Description: TODO
 * Time complexity:O(nlogm);
 * Space complexity: O(n);

 */
public class _253_MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int res = 0;
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int count = 0;
        for (int i = 0; i < start.length; i++) {
            if (start[i] < end[count]) {
                res++;
            } else {
                count++;
            }
        }
        return res;
    }
}
