/**
 * Date: 3/4/21
 * Question Description:
 * <p>
 * Examples:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(n! * n)
 * Space Complexity: O(n)
 */
public class _46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, nums, new ArrayList<>());
        return res;
    }
    private void helper(List<List<Integer>> res, int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            helper(res, nums, list);
            list.remove(list.size() - 1);
        }
    }
}
