/**
 * Date: 2/27/21
 * Question Description:
 * <p>
 * Examples:
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _256_PaintHouse {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        for (int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        int last = costs.length - 1;
        return Math.min(Math.min(costs[last][0], costs[last][1]), costs[last][2]);
    }
}
