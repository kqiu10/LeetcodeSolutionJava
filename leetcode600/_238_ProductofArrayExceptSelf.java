package ArrayList数组.子数组;
/**
 * Package Name : 数组.子数组;
 * File name : _238_ProductofArrayExceptSelf;
 * Creator: Kane;
 * Date: 8/1/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _238_ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            /**
             * res[i - 1] : nums[0] ~ nums[i - 2] 乘积之和；
             * res[i] : nums[0] ~ nums[i-1] 乘积之和；
             */
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
