package DynamicProgramming;
/**
 * Date: 10/25/20
 * Question Description
 */

/**
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

 */
public class MultipleKnapsack {
    public int knapsackMultiple(int[] weight, int[] value, int[] nums, int C, int N) {
        int[] memo = new int[C + 1];

        for (int i = 0; i < N; i++) {
            for (int j = C; j >= weight[i]; j--) {
                for (int k = 0; k <= nums[i]; k++) {
                    if (j - k * weight[i] >= 0) {
                        memo[j] = Math.max(memo[j], k * value[i] + memo[j - k * weight[i]]);
                    }
                }
            }
        }
        return memo[C];
    }
}
