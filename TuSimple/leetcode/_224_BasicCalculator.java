/**
 * Date: 2/28/21
 * Question Description:
 * Given a string s representing an expression, implement a basic calculator to evaluate it.
 * <p>
 * Examples
 * Example 1:
 *
 * Input: s = "1 + 1"
 * Output: 2
 * Example 2:
 *
 * Input: s = " 2-1 + 2 "
 * Output: 3
 * Example 3:
 *
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 */

import java.util.Stack;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class _224_BasicCalculator {
    public int calculate(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        s.trim().replaceAll("\\s+", "");
        int signal = 1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                res += num * signal;
            } else if (s.charAt(i) == '+') {
                signal = 1;
            } else if (s.charAt(i) == '-') {
                signal = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(res);
                stack.push(signal);
                res = 0;
                signal = 1;
            } else if (s.charAt(i) == ')') {
                res = res * stack.pop() + stack.pop();
            }
        }
        return res;
    }

}
