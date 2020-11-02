package Subsequence;
/**
 * Package Name : Subsequence;
 * File name : _594_LongestHarmoniousSubsequence;
 * Creator: Kane;
 * Date: 9/6/20
 */

import java.util.HashMap;

/**
 * We define a harmounious array as an array where the difference between its maximum value and
 * its minimum value is exactly 1.
 *
 * Now, given an integer array, you need to find the length of its longest harmonious subsequence
 * among all its possible subsequences.
 *
 * Example 1:
 *
 * Input: [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 *
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _594_LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        int res = 0;
        if (nums.length == 0 || nums == null) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (key < Integer.MAX_VALUE && map.containsKey(key + 1)) {
                res = Math.max(res, map.get(key) + map.get(key + 1));
            }
        }
        return res;
    }
}
