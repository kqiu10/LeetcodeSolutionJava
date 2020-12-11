import java.util.HashMap;

/**
 * Date: 12/11/20
 * Question Description
 Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

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

 Note that different sequences are counted as different combinations.

 Therefore the output is 7.
 */


public class _377_CombinationSumIV {
    /**
     * Description:
     * DP : res += res[i - num];
     * Time complexity:O(n * k);
     * Space complexity: O(n);

     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
    /**
     * Description:
     * DFS + Memoization : HashMap<Integer, Integer>
     * Time complexity:O(2^n);
     * Space complexity: O(n);
     */
    public int combinationSum4II(int[] nums, int target) {
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
            map.put(target, res);
        }
        return res;
    }
}
