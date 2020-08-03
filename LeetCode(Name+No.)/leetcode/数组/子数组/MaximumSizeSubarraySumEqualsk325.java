package 数组.子数组;
/**
 * Package Name : 数组.子数组;
 * File name : MaximumSizeSubarraySumEqualsk;
 * Creator: Kane;
 * Date: 8/2/20
 */

import java.util.HashMap;

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class MaximumSizeSubarraySumEqualsk325 {
    public static int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 1; i< nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - k)) {
                res = Math.max(res, i - map.get(nums[i] - k));
            }
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, -1, 5, -2, 3};
        int k = 3;
        maxSubArrayLen(nums, k);
    }

}
