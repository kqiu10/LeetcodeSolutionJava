/**
 * Date: 3/9/21
 * Question Description:
 * <p>
 * Examples:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(n ^ min{k, n - k})
 * Space Complexity: O(n)
 */
public class _77_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        helper(res, nums, new ArrayList<>(), k, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, int[] nums, List<Integer> list, int k, int pos) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            helper(res, nums, list, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
