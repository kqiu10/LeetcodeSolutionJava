/**
 * Date: 11/14/20
 * Question Description
 */

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(1);

 */
public class _123_BestTimetoBuyandSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int profit1 = 0, profit2 = 0;
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        for (int price : prices) {
            profit2 = Math.max(profit2, buy2 + price);
            buy2 = Math.max(buy2, profit1 - price);
            buy1 = Math.max(buy1, -price);
            profit1 = Math.max(profit1, buy1 + price);
        }
        return profit2;
    }
}
