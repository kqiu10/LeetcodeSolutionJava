/**
 * Date: 11/4/20
 * Question Description
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

 */
public class _38_CountandSay {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        helper(res, candidates, new ArrayList<>(), target);
        return res;
    }
    private void helper(List<List<Integer>> res, int[] candidates, List<Integer> list, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
        }
    }
}
