package leetcode.BackTracking回溯法.组合;
/**
 * Package Name : leetcode.BackTracking回溯法.组合;
 * File name : _377_CombinationSumIV;
 * Creator: Kane;
 * Date: 9/15/20
 */

import java.util.HashMap;

/**
 * Given an integer array with all positive numbers and no duplicates, find the number of
 * possible combinations that add up to a positive integer target.
 *
 * Example:
 *
 * nums = [1, 2, 3]
 * target = 4
 *
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * Note that different sequences are counted as different combinations.
 *
 * Therefore the output is 7.
 *
 * Time complexity:O(n * k);
 * Space complexity: O(k);
 * Description: DP
 * res[i] 数组存储的是nums数组能构成i的组合个数
 */
public class _377_CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] res = new int[target + 1];
        res[0] = 1;
        for (int i = 1; i < res.length; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    res[i] += res[i - num];
                }
            }
        }
        return res[target];
    }


}

/**
 *
 * Time complexity:O(2^n);
 * Space complexity: O(n);
 * Description:BackTracking
 * Ex
 *      nums = [1, 2, 3]
 *          target = 4
 *      i = 0  res = helper(3)
 *          i = 0 res = helper(2)
 *              i = 0 res = helper(1)
 *                  i = 0 res = helper(0)
 *                  map.put(0, 1)
 */
class CombinationSumIVII {
    public int combinationSum4(int[] nums, int target) {
        if (nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        return helper(nums, target, map);
    }

    private int helper(int[] nums, int target, HashMap<Integer, Integer> map) {
        if (target == 0) return 1;
        if (target < 0) return 0;
        if (map.containsKey(target)) {
            return map.get(target);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += helper(nums, target - nums[i], map);
        }
        map.put(target, res);
        return res;
    }
}

