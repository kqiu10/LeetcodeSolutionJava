package 数组.HashMap;
/**
 * Package Name : 数组;
 * File name : TwoSum1;
 * Creator: Kane;
 * Date: 8/2/20
 */

import java.util.HashMap;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length <= 1) return new int[]{-1, -1};
        int[] res = new int[]{-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;

    }
}
