package ArrayList数组.子数组;
/**
 * Package Name : 数组.子数组;
 * File name : _560_SubarraySumEqualsK;
 * Creator: Kane;
 * Date: 8/2/20
 */

import java.util.HashMap;

/**
 * Time complexity:O(n^2);
 * Space complexity: O(1);
 * Description: Brute Force
 */
public class _560_SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) res++;
            }
        }
        return res;

    }
}
/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: Two Sum
 */
class SubarraySumEqualsKII{
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i< nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
