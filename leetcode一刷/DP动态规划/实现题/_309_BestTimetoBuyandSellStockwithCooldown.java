package DP动态规划.实现题;
/**
 * Date: 10/24/20
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
 * Description:
 best explanation :
 https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75927/Share-my-thinking-process
 * Time complexity:O(n);
 * Space complexity: O(1);

 */
public class _309_BestTimetoBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }
}
