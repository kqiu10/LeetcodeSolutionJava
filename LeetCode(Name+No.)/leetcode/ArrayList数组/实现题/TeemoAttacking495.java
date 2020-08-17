package 数组.实现题;
/**
 * Package Name : 数组.实现题;
 * File name : TeemoAttacking495;
 * Creator: Kane;
 * Date: 8/10/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class TeemoAttacking495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < timeSeries.length - 1; i ++) {
            if (timeSeries[i + 1] - timeSeries[i] >= duration) {
                res += duration;
            } else {
                res += timeSeries[i + 1] - timeSeries[i];
            }
        }
        return res + duration;

    }
}
