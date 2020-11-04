/**
 * Date: 11/3/20
 * Question Description
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 Example 1:
 Input: n = 3
 Output: ["((()))","(()())","(())()","()(())","()()()"]
 Example 2:

 Input: n = 1
 Output: ["()"]
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Description: TODO
 * Time complexity:O(4^n / n^(1/2));
 * Space complexity: O(n);

 */
public class _22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        helper(res, "", n, n);
        return res;
    }
    private void helper(List<String> res, String cur, int left, int right) {
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(cur);
            return;
        }
        if (left > 0) {
            helper(res, cur + "(", left - 1, right);
        }
        if (right > 0) {
            helper(res, cur + ")", left, right - 1);
        }
    }
}
