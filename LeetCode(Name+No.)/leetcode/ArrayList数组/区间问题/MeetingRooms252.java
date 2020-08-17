package ArrayList数组.区间问题;
/**
 * Package Name : 数组.区间问题;
 * File name : MeetingRooms252;
 * Creator: Kane;
 * Date: 8/1/20
 */

import java.util.Arrays;

/**
 * Time complexity:O(nlogn);
 * Space complexity: O(1);
 * Description: TODO
 */
public class MeetingRooms252 {
    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        int len = intervals.length;
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] < end) {return false;}
            end = intervals[i][1];
        }
        return true;

    }

    public static void main(String[] args) {
        canAttendMeetings(new int[][]{{7,10},{2,4}});
    }

}
