package 数组.子数组;
/**
 * Package Name : 数组.子数组;
 * File name : MaximumProductSubarray152;
 * Creator: Kane;
 * Date: 8/2/20
 */

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class MaximumProductSubarray152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(nums[i] * max, nums[i] * min), nums[i]);
            min = Math.min(Math.min(nums[i] * temp, nums[i] * min), nums[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}
