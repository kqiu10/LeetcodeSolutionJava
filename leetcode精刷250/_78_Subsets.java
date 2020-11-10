/**
 * Date: 11/10/20
 * Question Description
 Given a set of distinct integers, nums, return all possible subsets (the power set).

 Note: The solution set must not contain duplicate subsets.

 Example:
 Input: nums = [1,2,3]
 Output:
 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Description: TODO
 * Time complexity:O(n * 2^n);
 * Space complexity: O(n * 2^n);

 */
public class _78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        helper(res, nums, new ArrayList<>(), 0);
        return res;
    }
    private void helper(List<List<Integer>> res, int[] nums, List<Integer> list, int pos) {
        res.add(new ArrayList<>(list));
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            helper(res, nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
