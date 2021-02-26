/**
 * Date: 2/25/21
 * Question Description:
 * <p>
 * Examples:
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Time Complexity: O(2^n)
 * Space Complexity: O(n)
 */
public class _39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        helper(res, candidates, new ArrayList<>(), target, 0, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, int[] candidates, List<Integer> list, int target, int pos, int sum) {
        if (sum > target) return;
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(res ,candidates, list, target, i, sum + candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}
