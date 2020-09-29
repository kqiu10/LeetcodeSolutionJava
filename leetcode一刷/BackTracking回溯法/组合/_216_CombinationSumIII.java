package leetcode.BackTracking回溯法.组合;
/**
 * Package Name : leetcode.BackTracking回溯法.组合;
 * File name : _216_CombinationSumIII;
 * Creator: Kane;
 * Date: 9/15/20
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers
 * from 1 to 9 can be used and each combination should be a unique set of numbers.
 *
 * Note:
 *
 * The solution set must not contain duplicate combinations.
 *
 *
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6],[1,3,5],[2,3,4]]
 * Example 3:
 *
 * Input: k = 4, n = 1
 * Output: []
 * Example 4:
 *
 * Input: k = 3, n = 2
 * Output: []
 * Example 5:
 *
 * Input: k = 9, n = 45
 * Output: [[1,2,3,4,5,6,7,8,9]]
 *
 * Time complexity:O(2^n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _216_CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k > n) return res;
        helper(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int k, int n, int start) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            helper(res, list, k - 1, n - i, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
