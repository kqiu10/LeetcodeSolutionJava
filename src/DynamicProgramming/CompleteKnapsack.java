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
public class CompleteKnapsack {
    public int knapsackComplete(int[] weight, int[] value, int C, int N) {
        int[][] memo = new int[N + 1][C + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= C; j++) {
                if (j < weight[i - 1]) {
                    memo[i][j] = memo[i - 1][j];
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], value[i - 1] + memo[i - 1][j - weight[i - 1]]);
                }
            }
        }
        return memo[N - 1][C];
    }
    public int knapsackCompleteII(int[] weight, int[] value, int C, int N) {
        int[] memo = new int[C + 1];

        for (int i = 1; i < N; i++) {
            for (int j = weight[i]; j <= C; j++) {
                memo[j] = Math.max(memo[j], value[i] + memo[j - weight[i]]);
            }
        }
        return memo[C];
    }
}
