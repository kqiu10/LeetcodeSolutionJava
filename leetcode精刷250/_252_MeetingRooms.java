/**
 * Date: 11/26/20
 * Question Description
 Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.
 Example 1:

 Input: intervals = [[0,30],[5,10],[15,20]]
 Output: false
 Example 2:

 Input: intervals = [[7,10],[2,4]]
 Output: true
 */

import java.util.Arrays;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(1);

 */
public class _252_MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                return false;
            }
            end = intervals[i][1];
        }
        return true;
    }
}
