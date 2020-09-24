package leetcode.Graph图.DFS;
/**
 * Date: 9/23/20
 * Question Description
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Given a nested list of integers, return the sum of all integers in the list weighted by their
 * depth.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other
 * lists.
 *
 * Different from the previous question where weight is increasing from root to leaf, now the
 * weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root
 * level integers have the largest weight.
 *
 * Example 1:
 *
 * Input: [[1,1],2,[1,1]]
 * Output: 8
 * Explanation: Four 1's at depth 1, one 2 at depth 2.
 * Example 2:
 *
 * Input: [1,[4,[6]]]
 * Output: 17
 * Explanation: One 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17.
 *
 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _364_NestedListWeightSumII {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;

        return helper(nestedList, 0);
    }

    private int helper(List<NestedInteger> nestedList, int res) {
        List<NestedInteger> nextList = new ArrayList<>();
        for (NestedInteger list : nestedList) {
            if (list.isInteger()) {
                res += list.getInteger();
            } else {
                nextList.addAll(list.getList());
            }
        }
        res += nextList.isEmpty() ? helper(nextList, res) : 0;
        return res;
    }
}
