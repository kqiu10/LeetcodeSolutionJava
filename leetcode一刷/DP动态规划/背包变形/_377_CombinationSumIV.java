package DP动态规划.背包变形;
/**
 * Date: 10/24/20
 * Question Description
 Given an integer array with all positive numbers and no duplicates,
 find the number of possible combinations that add up to a positive integer target.
 Example:

 nums = [1, 2, 3]
 target = 4

 The possible combination ways are:
 (1, 1, 1, 1)
 (1, 1, 2)
 (1, 2, 1)
 (1, 3)
 (2, 1, 1)
 (2, 2)
 (3, 1)
 */

/**
 * Description: TODO
 * Time complexity:O(n * target);
 * Space complexity: O(target);

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
