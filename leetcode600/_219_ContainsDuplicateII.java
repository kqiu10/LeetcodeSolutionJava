package ArrayList数组.HashMap;
/**
 * Package Name : 数组.HashSet;
 * File name : _219_ContainsDuplicateII;
 * Creator: Kane;
 * Date: 8/7/20
 */

import java.util.HashMap;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _219_ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if ((i - map.get(nums[i]) <= k)) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

}
