package leetcode;
/**
 * Date: 9/21/20
 * Question Description
 */

import java.util.Arrays;

/**
 * Time complexity:O(S * N );On each step the algorithm finds the next F(i) in n iterations,
 * where 1 <= i <= s
 * Space complexity: O(S); We use extra space for the memoization table.
 * Description: TODO
 */
public class _322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
