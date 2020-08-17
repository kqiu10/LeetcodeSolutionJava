package ArrayList数组.实现题;
/**
 * Package Name : 数组.实现题;
 * File name : WiggleSubsequence376;
 * Creator: Kane;
 * Date: 8/10/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description:
 * To understand this approach, take two arrays for dp named upup and downdown.
 * Whenever we pick up any element of the array to be a part of the wiggle subsequence,
 * that element could be a part of a rising wiggle or a falling wiggle depending upon which element we have taken prior to it.
 * up[i] refers to the length of the longest wiggle subsequence obtained so far considering
 * i^{th}element as the last element of the wiggle subsequence and ending with a rising wiggle.
 * Similarly, down[i]down[i] refers to the length of the longest wiggle subsequence obtained so far considering i^{th}
 * element as the last element of the wiggle subsequence and ending with a falling wiggle.
 * up[i] will be updated every time we find a rising wiggle ending with the i^{th}
 * element. Now, to find up[i]up[i], we need to consider the maximum out of all the previous wiggle subsequences
 * ending with a falling wiggle i.e. down[j]down[j], for every j<i and nums[i]>nums[j]. Similarly, down[i]down[i]
 * will be updated.
 */
public class WiggleSubsequence376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }
        return Math.max(down[nums.length - 1], up[nums.length - 1]);

    }
}
/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 */
class WiggleSubsequenceII {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int up = 1;
        int down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}
