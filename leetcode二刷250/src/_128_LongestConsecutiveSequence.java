/**
 * Date: 3/30/21
 * Question Description:
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * <p>
 * Examples:
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length
 * is 4.
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 */

import java.util.HashSet;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class _128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int item : nums) {
            int low = item - 1;
            while (set.contains(low)) {
                set.remove(low);
                low--;
            }
            int high = item + 1;
            while (set.contains(high)) {
                set.remove(high);
                high++;
            }
            res = Math.max(res, high - low - 1);
        }
        return res;
    }

}
