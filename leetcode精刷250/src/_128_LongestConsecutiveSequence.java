package src; /**
 * Date: 11/14/20
 * Question Description
 Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

 Follow up: Could you implement the O(n) solution?
 Example 1:

 Input: nums = [100,4,200,1,3,2]
 Output: 4
 Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 Example 2:

 Input: nums = [0,3,7,2,5,8,4,6,0,1]
 Output: 9

 */

import java.util.HashSet;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            int low = num - 1;
            while (set.contains(low)) {
                set.remove(low);
                low--;
            }
            int up = num + 1;
            while (set.contains(up)) {
                set.remove(up);
                up++;
            }
            res = Math.max(res, up - low - 1);
        }
        return res;

    }
}
