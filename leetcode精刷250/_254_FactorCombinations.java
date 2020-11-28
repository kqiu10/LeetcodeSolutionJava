/**
 * Date: 11/27/20
 * Question Description
 Numbers can be regarded as product of its factors. For example,

 8 = 2 x 2 x 2;
 = 2 x 4.
 Write a function that takes an integer n and return all possible combinations of its factors.

 Note:

 You may assume that n is always positive.
 Factors should be greater than 1 and less than n.
 Example 1:

 Input: 1
 Output: []
 Example 2:

 Input: 37
 Output:[]
 Example 3:

 Input: 12
 Output:
 [
 [2, 6],
 [2, 2, 3],
 [3, 4]
 ]
 Example 4:

 Input: 32
 Output:
 [
 [2, 16],
 [2, 2, 8],
 [2, 2, 2, 4],
 [2, 2, 2, 2, 2],
 [2, 4, 4],
 [4, 8]
 ]
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Description: TODO
 * Time complexity:O(2^n);
 * Space complexity: O(n);

 */
public class _254_FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), n, 2);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> list, int n, int index) {
        if (n == 1) {
            if (list.size() > 1) {
                res.add(new ArrayList<>(list));
                return;
            }
        }
        for (int i = index; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                helper(res, list, n / i, i);
                list.remove(list.size() - 1);
            }
        }
    }
}
