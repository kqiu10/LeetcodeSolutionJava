/**
 * Date: 3/14/21
 * Question Description:
 * Given an integer array nums that may contain duplicates, return all possible subsets (the
 * power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * Examples:
 * Example 1:
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time Complexity: O(2^n)
 * Space Complexity: O(n)
 */
public class _90_SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(res, nums, new ArrayList<>(), 0);
        return res;
    }
    private void helper(List<List<Integer>> res, int[] nums, List<Integer> list, int pos) {
        res.add(new ArrayList<>(list));
        for (int i = pos; i < nums.length; i++) {
            if (i != pos && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            helper(res, nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
