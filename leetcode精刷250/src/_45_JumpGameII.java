package src; /**
 * Date: 11/5/20
 * Question Description
 Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 You can assume that you can always reach the last index.
 Example 1:

 Input: nums = [2,3,1,1,4]
 Output: 2
 Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 Example 2:

 Input: nums = [2,3,0,1,4]
 Output: 2
 */

/**
 * Description:
 * curMax : 当前能走到的最大距离
 * maxNext : 总共能走到的最大距离
 * Time complexity:O(n);
 * Space complexity: O(1);

 */
public class _45_JumpGameII {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int curMax = 0;
        int maxNext = 0;
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxNext = Math.max(maxNext, i + nums[i]);
            if (i == curMax) {
                res++;
                curMax = maxNext;
            }
        }
        return res;
    }
}
