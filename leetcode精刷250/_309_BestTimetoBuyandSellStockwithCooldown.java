/**
 * Date: 12/3/20
 * Question Description
 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 Example:

 Input: [1,2,3,0,2]
 Output: 3
 Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */

/**
 * Description: DP


 
 * buy[i] 表示在第i天之前最后一个操作是买，此时的最大收益
 * sell[i] 表示在第i天之前最后一个操作是卖，此时的最大收益
 * rest[i] 表示在第i天之前最后一个操作是冷冻期，此时的最大收益

 buy[i] = max(res[i - 1] - price, buy[i - 1]);
 sell[i] = max(buy[i - 1] + price, sell[i - 1]);
 rest[i] = max(sell[i - 1], buy[i - 1], rest[i - 1]);

 在买之前表示在买之前有冷冻期，买之前要卖掉之前的股票，是如何保证[buy, rest, buy]的情况不出现
 这是由于buy[i] <= rest[i], 即 rest[i] = max(sell[i - 1], rest[i - 1], 这保证了[buy, rest, buy]不会出现
 另外由于冷冻期的存在，我们可以得出rest[i] = sell[i - 1],这样我们可以精简三个式子

 buy[i] = max(sell[i - 2] - price, buy[i - 1])
 sell[i] = max(buy[i - 1] + price, sell[i - 1])
 *  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75927/Share-my-thinking-process
 * Time complexity:O(n);
 * Space complexity: O(1);

 */
public class _309_BestTimetoBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        int sell = 0, preSell = 0;
        int buy = Integer.MIN_VALUE, preBuy = 0;
        for (int price : prices) {
            preBuy = buy;
            buy = Math.max(preSell - price, preBuy);
            preSell = sell;
            sell = Math.max(preBuy + price, preSell);
        }
        return sell;
    }
}
