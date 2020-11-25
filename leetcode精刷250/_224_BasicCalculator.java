/**
 * Date: 11/25/20
 * Question Description
 Implement a basic calculator to evaluate a simple expression string.

 The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

 Example 1:

 Input: "1 + 1"
 Output: 2
 Example 2:

 Input: " 2-1 + 2 "
 Output: 3
 Example 3:

 Input: "(1+(4+5+2)-3)+(6+8)"
 Output: 23
 */

import java.util.Stack;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _224_BasicCalculator {
    public int calculate(String s) {
        s = s.trim().replaceAll("\\s+", "");
        int res = 0;
        int signal = 1;
        Stack<Integer> stack = new Stack<>();
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
            }else if (s.charAt(i) == ')') {
                res = res * stack.pop() + stack.pop();
            }
        }
        return res;
    }
}
