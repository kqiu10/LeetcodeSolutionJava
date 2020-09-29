package leetcode.BackTracking回溯法.组合;
/**
 * Package Name : leetcode.BackTracking回溯法.子集;
 * File name : _77_Combinations;
 * Creator: Kane;
 * Date: 9/15/20
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * Example 2:
 *
 * Input: n = 1, k = 1
 * Output: [[1]]
 *
 * Time complexity:O(n ^ min{k, n - k});
 * Space complexity: O(n);
 * Description: TODO
 */
public class _77_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0 || k == 0) return res;
        helper(res, new ArrayList<>(), n, k, 1);
        return res;

    }

    private void helper(List<List<Integer>> res, List<Integer> list, int n, int k, int start) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            helper(res, list, n, k, i + 1);
            list.remove(list.size() - 1);
        }

    }
}
