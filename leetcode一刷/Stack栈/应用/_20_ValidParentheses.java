package Stack栈.应用;
/**
 * Package Name : Stack栈.应用;
 * File name : _20_ValidParentheses;
 * Creator: Kane;
 * Date: 8/23/20
 */

import java.util.Stack;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _20_ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.pop() != ch) {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }
}
