package src; /**
 * Date: 11/11/20
 * Question Description
 Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

 Note: The solution set must not contain duplicate subsets.

 Example:

 Input: [1,2,2]
 Output:
 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: TODO
 * Time complexity:O(2^n);
 * Space complexity: O(n);

 */
public class _90_SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
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
