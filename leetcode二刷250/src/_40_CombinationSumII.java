/**
 * Date: 2/25/21
 * Question Description:
 * Given a collection of candidate numbers (candidates) and a target number (target), find all
 * unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 * <p>
 * Examples:
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Time Complexity: O(2^n)
 * Space Complexity: O(n)
 */
public class _40_CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<>();
        helper(res, candidates, new ArrayList<>(), target, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, int[] candidates, List<Integer> list, int target, int pos) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            if (i != pos && candidates[i] == candidates[i - 1]) continue;
            list.add(candidates[i]);
            helper(res, candidates, list, target - candidates[i], pos + 1);
            list.remove(list.size() - 1);
        }
    }

}
