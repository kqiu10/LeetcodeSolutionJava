package ArrayList数组.子数组;
/**
 * Package Name : 数组.子数组;
 * File name : _209_MinimumSizeSubarraySum;
 * Creator: Kane;
 * Date: 8/1/20
 */

/**
 * Time complexity:O(n);
 * Space complexinty: O(1);
 * Description: TODO
 */
public class _209_MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (left <= i && sum >= s) {
                res = Math.min(res, i - left + 1);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;

    }
}
