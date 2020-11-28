/**
 * Date: 11/26/20
 * Question Description
 */

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;


public class _239_SlidingWindowMaximum {
    /**
     * Description: SlidingWindow
     * Time complexity:O(n * k);
     * Space complexity: O(n);
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k > nums.length) return new int[]{0};
        int[] res = new int[nums.length - k + 1];
        Arrays.fill(res, Integer.MIN_VALUE);
        for (int i = 0; i <= nums.length - k; i++) {
            for (int j = i; j < k; j++) {
                res[i] = Math.max(res[i], nums[j]);
            }
        }
        return res;
    }
    /**
     * Description: Deque
     * 存的是index, 从大到小排序
     * Time complexity:O(n);
     * Space complexity: O(n);
     */
    public static int[] maxSlidingWindowII(int[] nums, int k) {
        if (k > nums.length) return new int[]{0};
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.offerLast(i);
            if ((i + 1) >= k) {
                res[i - k + 1] = nums[deque.peek()];
            }
        }
        return res;

    }
    public static void main(String[] args) {
        maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);

    }
}
