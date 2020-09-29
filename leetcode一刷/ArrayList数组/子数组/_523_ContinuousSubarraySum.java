package ArrayList数组.子数组;
/**
 * Package Name : 数组.子数组;
 * File name : _523_ContinuousSubarraySum;
 * Creator: Kane;
 * Date: 8/2/20
 */

import java.util.HashMap;

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class _523_ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum = sum % k;
            }
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) {
                    return true;
                }

            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}
