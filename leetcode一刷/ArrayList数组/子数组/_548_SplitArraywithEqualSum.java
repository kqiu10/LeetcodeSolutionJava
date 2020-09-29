package ArrayList数组.子数组;
/**
 * Package Name : 数组.子数组;
 * File name : _548_SplitArraywithEqualSum;
 * Creator: Kane;
 * Date: 8/2/20
 */

import java.util.HashSet;

/**
 * Time complexity:O(n^2);
 * Space complexity: O(n);
 * Description:
 * 1 2 1 2 1 2 1
 *   i   j   k
 * i 属于 [1, j - 2];
 * j 属于 [3, nums.length - 4];
 * k 属于 [j + 2, nums.length - 2];
 */
public class _548_SplitArraywithEqualSum {
    public boolean splitArray(int[] nums) {
        if (nums.length < 7) return false;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        for (int j = 3; j <= nums.length - 4; j++) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 1; i <= j - 2; i++) {
                if (sum[i - 1] == sum[j - 1] - sum[i]) {
                    set.add(sum[i - 1]);
                }
            }
            for (int k = j + 2; k <= nums.length - 2; k++) {
                if (sum[sum.length - 1] - sum[k] ==  sum[k - 1] - sum[j] && set.contains(sum[sum.length - 1] - sum[k])) {
                    return true;
                }
            }
        }
        return false;

    }
}
