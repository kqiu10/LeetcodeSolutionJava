package DP动态规划.一维;
/**
 * Date: 10/23/20
 * Question Description
 Given an integer array nums,
 find the contiguous subarray within an array (containing at least one number) which has the largest product.
 Example 1:
 Input: [2,3,-2,4]
 Output: 6
 Explanation: [2,3] has the largest product 6.
 Example 2:
 Input: [-2,0,-1]
 Output: 0
 Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */

/**
 * Description:
 * [2, 3, -2, 4]
 * max = 2, min = 2, res = 2
 * i = 1 max = 6, min = 3 res = 6
 * i = 2 max = -2 min = -12 res = 6
 * i = 3 max = 4 min = -48 res = 6
 * Time complexity:O(n);
 * Space complexity: O(1);

 */
public class _152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(min * nums[i], temp * nums[i]), nums[i]);
            res = Math.min(max, res);
        }
        return res;
    }
}
