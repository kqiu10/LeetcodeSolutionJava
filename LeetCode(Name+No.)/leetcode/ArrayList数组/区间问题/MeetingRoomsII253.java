package 数组.区间问题;
/**
 * Package Name : 数组.区间问题;
 * File name : MeetingRoomsII253;
 * Creator: Kane;
 * Date: 8/1/20
 */

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Time complexity:O(nlon);
 * Space complexity: O(n);
 * Description: TODO
 */
public class MeetingRoomsII253 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int res= 0;
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int end = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (starts[i] < ends[end]) {
                res++;
            } else {
                end++;
            }
        }
        return res;
    }
}

class MeetingRoomsIIII{
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> heap = new PriorityQueue<>(intervals.length, (a,b) -> a[1] - b[1]);
        heap.offer(intervals[0]);
        for (int i = 1; i< intervals.length; i++) {
            int[] interval = heap.poll();
            if (intervals[i][0] >= interval[1]) {
                interval[1] = intervals[i][1];
            } else {
                heap.offer(intervals[i]);
            }
            heap.offer(interval);

        }
        return heap.size();

    }
}
