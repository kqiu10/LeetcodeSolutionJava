package Stack栈.表达式计算;
/**
 * Package Name : Stack栈.表达式计算;
 * File name : _439_TernaryExpressionParser;
 * Creator: Kane;
 * Date: 8/24/20
 */

import java.util.Stack;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description:
 * 1. iterate from right to left;
 * 2. when meet ternary signal judge true or false;
 */
public class _439_TernaryExpressionParser {
    public String parseTernary(String expression) {
        if (expression.length() == 0 || expression == null) return "0";
        Stack<Character> stack = new Stack<>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '?') {
                stack.pop();
                char first = stack.pop();
                stack.pop();
                char second = stack.pop();
                if (c == 'T') {
                    stack.push(first);
                }
                if (c == 'F') stack.push(second);
            } else {
                stack.push(c);
            }
        }
        return String.valueOf(stack.pop());

    }
}
