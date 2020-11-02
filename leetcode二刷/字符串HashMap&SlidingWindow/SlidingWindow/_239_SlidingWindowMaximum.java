package SlidingWindow;
/**
 * Package Name : SlidingWindow;
 * File name : _239_SlidingWindowMaximum;
 * Creator: Kane;
 * Date: 9/4/20
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of
 * the array to the very right. You can only see the k numbers in the window. Each time the
 * sliding window moves right by one position. Return the max sliding window.
 *
 * Follow up:
 * Could you solve it in linear time?
 *
 * Example:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Deque:
 * 1.store index
 * 2.sort from big to small
 * 0  1  2  3   4  5  6  7
 * 1  3  -1 -3  5  3  6  7
 *       deque
 * i = 0 [0]
 * i = 1 [1]
 * i = 2 [1, 2]
 * i = 3 [1, 2, 3]
 * i = 4 [5]
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _239_SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k > nums.length) return new int[0];
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.offer(i);
            if ((i + 1) >= k) {
                res[(i + 1) - k] = nums[deque.peek()];
            }
        }
        return res;

    }

    public static void main(String[] args) {
        maxSlidingWindow(new int[]{7, 2, 4}, 2);
    }
}
