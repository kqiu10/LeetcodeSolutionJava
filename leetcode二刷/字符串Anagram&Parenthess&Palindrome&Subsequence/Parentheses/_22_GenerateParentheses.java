package Parentheses;
/**
 * Package Name : Parentheses;
 * File name : _22_GenerateParentheses;
 * Creator: Kane;
 * Date: 9/5/20
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed
 * parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * Time complexity:O(4^n);
 * Space complexity: O(4^n);
 * Description: TODO
 */
public class _22_GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        helper(res, "", n, n);
        return res;

    }
    private static void helper(List<String> res, String s, int left, int right) {
        if (left > right) return;
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        if (left > 0) {
            helper(res, s + "(", left - 1, right);
        }
        if (right > 0) {
            helper(res, s + ")", left, right - 1);
        }

    }

    public static void main(String[] args) {
        generateParenthesis(3);

    }
}
