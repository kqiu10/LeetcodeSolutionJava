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
public class KnapSack {

    public int knapsack01(int[] weight, int[] value, int C, int N) {
        int[][] memo = new int[N][C + 1];

        for (int i = 0; i <= C; i++) {
            memo[0][i] = (i >= weight[0]) ? value[0] : 0;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= C; j++) {
                if (j < weight[i]) {
                    memo[i][j] = memo[i - 1][j];
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], value[i] + memo[i - 1][j - weight[i]]);
                }
            }
        }
        return memo[N - 1][C];
    }

    public int knapsack01II(int[] weight, int[] value, int C, int N) {
        int[][] memo = new int[2][C + 1];

        for (int i = 0; i <= C; i++) {
            memo[0][i] = (i >= weight[0]) ? value[0] : 0;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= C; j++) {
                if (j < weight[i]) {
                    memo[i % 2][j] = memo[(i - 1) % 2][j];
                } else {
                    memo[i % 2][j] = Math.max(memo[(i - 1) % 2][j], value[i] + memo[(i - 1) % 2][j - weight[i]]);
                }
            }
        }
        return memo[(N - 1) % 2][C];
    }

    public int knapsack01III(int[] weight, int[] value, int C, int N) {
        int[] memo = new int[C + 1];

        for (int i = 0; i <= C; i++) {
            memo[i] = (i >= weight[0]) ? value[0] : 0;
        }

        for (int i = 1; i < N; i++) {
            for (int j = C; j >= weight[i]; j--) {
                memo[j] = Math.max(memo[j], value[i] + memo[j - weight[i]]);
            }
        }
        return memo[C];
    }
}
