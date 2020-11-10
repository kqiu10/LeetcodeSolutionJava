/**
 * Date: 11/10/20
 * Question Description
 Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 You may return the answer in any order.
 Example 1:

 Input: n = 4, k = 2
 Output:
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 Example 2:

 Input: n = 1, k = 1
 Output: [[1]]
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Description: TODO
 * Time complexity:O(n ^ min{k, n - k});
 * Space complexity: O(n);

 */
public class _77_Combinations {
    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        if (n == 0 || k == 0 || k > n) return res;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        helper(res, nums, new ArrayList<>(), k, 0);
        return res;
    }
    private static void helper(List<List<Integer>> res, int[] nums, List<Integer> list, int k, int pos) {
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

    public static void main(String[] args) {
        combine(4, 2);
    }
}
