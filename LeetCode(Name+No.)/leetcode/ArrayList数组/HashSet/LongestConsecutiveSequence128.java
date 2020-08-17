package ArrayList数组.HashSet;
/**
 * Package Name : 数组.实现题;
 * File name : LongestConsecutiveSequence128;
 * Creator: Kane;
 * Date: 8/10/20
 */

import java.util.HashSet;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class LongestConsecutiveSequence128 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            int down = nums[i] - 1;
            while (set.contains(down)) {
                set.remove(down);
                down--;
            }
            int up = nums[i] + 1;
            while (set.contains(up)) {
                set.remove(up);
                up++;
            }
            res = Math.max(res, up - down - 1);
        }
        return res;
    }
}
