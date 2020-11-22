/**
 * Date: 11/20/20
 * Question Description
 You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

 Design an algorithm to find the maximum profit. You may complete at most k transactions.

 Notice that you may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 Example 1:

 Input: k = 2, prices = [2,4,1]
 Output: 2
 Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 Example 2:

 Input: k = 2, prices = [3,2,6,5,0,3]
 Output: 7
 Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 */

/**
 * Description:
 dp[i, j] 当前到达第j天可以最多进行i次交易， 最大的利润是多少
 tmpMax means the maximum profit of just doing at most i - 1 transactions,
 using at most fisrt j - 1 prices, and
 buying the stock at price[j] - this is used for the next loop
 * Time complexity:O(k * n);
 * Space complexity: O(k * n);
 */
public class _188_BestTimeToBuyandSellStockIv {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return helper(prices);

        int[][] dp = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax = -prices[0];
            for (int j = 1; j < len; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + tmpMax);
                tmpMax = Math.max(tmpMax, dp[i - 1][j - 1] - prices[j]);
            }
        }
        return dp[k][len - 1];

    }
    private int helper(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += (prices[i] - prices[i - 1]);
            }
        }
        return res;
    }
}