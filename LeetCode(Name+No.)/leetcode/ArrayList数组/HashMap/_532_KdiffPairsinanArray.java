package ArrayList数组.HashMap;
/**
 * Package Name : 数组.HashMap;
 * File name : _532_KdiffPairsinanArray;
 * Creator: Kane;
 * Date: 8/7/20
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _532_KdiffPairsinanArray {
    public static int findPairs(int[] nums, int k) {
        if (nums.length == 0 || nums == null) return 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k ==0) {
                if (entry.getValue() >= 2) res++;
            } else {
                if (k > 0 && map.containsKey(entry.getKey() + k)) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = new int[]{3, 1, 4, 1, 5};
        findPairs(test, 2);
    }
}
