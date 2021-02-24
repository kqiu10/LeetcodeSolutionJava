/**
 * Date: 2/24/21
 * Question Description:
 * <p>
 * Examples:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O()
 * Space Complexity: O()
 */
public class _22_GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, "", n, n);
        return res;
    }
    private static void helper(List<String> res, String cur, int left, int right) {
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
            helper(res, cur + ")",  left, right - 1);
        }
    }

    public static void main(String[] args) {
        generateParenthesis(3);
    }
}
