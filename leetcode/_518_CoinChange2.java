package leetcode;
/**
 * Date: 9/22/20
 * Question Description
 */

/**
 * Time complexity:O(N×amount);
 * Space complexity: O(amount);
 * Description: TODO
 */
public class _518_CoinChange2 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int x = coin; x < amount + 1; ++x) {
                dp[x] += dp[x - coin];
            }
        }
        return dp[amount];
    }
}
