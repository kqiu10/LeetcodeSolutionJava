/**
 * Date: 12/4/20
 * Question Description
 You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

 You may assume that you have an infinite number of each kind of coin.
 Example 1:

 Input: coins = [1,2,5], amount = 11
 Output: 3
 Explanation: 11 = 5 + 5 + 1
 Example 2:

 Input: coins = [2], amount = 3
 Output: -1
 Example 3:

 Input: coins = [1], amount = 0
 Output: 0
 Example 4:

 Input: coins = [1], amount = 1
 Output: 1
 Example 5:

 Input: coins = [1], amount = 2
 Output: 2
 */

/**
 * Description:
 dp[] amount 需要多少 coins
 dp[5] = 3;
 coins[j] = 2;
 dp[7] = dp[7 - 2] + 1 = 4
 min = Math.min(min, dp[i - coins[j]] + 1)
 * Time complexity:O(amount * len(coins));
 * Space complexity: O(amount);

 */
public class _322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (coins == null || coins.length == 0) return -1;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != -1) {
                    min = Math.min(min, dp[i - coins[j]] + 1);
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return dp[amount];
    }

}
