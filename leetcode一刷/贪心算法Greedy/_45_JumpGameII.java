package 贪心算法Greedy;
/**
 * Date: 10/11/20
 * Question Description
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 Example:

 Input: [2,3,1,1,4]
 Output: 2
 Explanation: The minimum number of jumps to reach the last index is 2.
 Jump 1 step from index 0 to 1, then 3 steps to the last index.

 */


public class _45_JumpGameII {
    /**
     * Description: Greedy Algorithm
     * Time complexity:O(n);
     * Space complexity: O(1);
     */
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int curMax = 0;
        int res = 0;
        int maxNext = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxNext = Math.max(maxNext, nums[i] + i);
            if (i == curMax) {
                res++;
                curMax = maxNext;
            }
        }
        return res;
    }
    /**
     * Description: BFS
     * Time complexity:O(n);
     * Space complexity: O(1);
     */
    public int jumpII(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int level = 0;
        int curMax = 0;
        int maxNext = 0;
        int i = 0;
        while (curMax - i + 1 > 0) {
            level++;
            for (i = 0;i <= curMax; i++) {
                maxNext = Math.max(maxNext, nums[i] + i);
                if (maxNext > nums.length - 1) {
                    return level;
                }
            }
            curMax = maxNext;
        }
        return 0;
    }

}
