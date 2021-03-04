/**
 * Date: 3/4/21
 * Question Description:
 * <p>
 * Examples:
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time Complexity: O(n!)
 * Space Complexity: O(n)
 */
public class _47_PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(res, nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }
    private void helper(List<List<Integer>> res, int[] nums, List<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
            used[i] = true;
            list.add(nums[i]);
            helper(res, nums, list, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }

    }
}
