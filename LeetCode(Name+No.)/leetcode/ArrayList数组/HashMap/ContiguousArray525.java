package ArrayList数组.HashMap;
/**
 * Package Name : 数组.HashMap;
 * File name : ContiguousArray525;
 * Creator: Kane;
 * Date: 8/7/20
 */

import java.util.HashMap;

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class ContiguousArray525 {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int res = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 0 ? -1 : 1);
            if (map.containsKey(count)) {
                res = Math.max(res, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return res;
    }
}
