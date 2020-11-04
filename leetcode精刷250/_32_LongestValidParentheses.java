/**
 * Date: 11/4/20
 * Question Description
 Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 Example 1:

 Input: s = "(()"
 Output: 2
 Explanation: The longest valid parentheses substring is "()".
 Example 2:

 Input: s = ")()())"
 Output: 4
 Explanation: The longest valid parentheses substring is "()()".
 Example 3:

 Input: s = ""
 Output: 0
 */

import java.util.Stack;

/**
 * Description:
 Ex :   1. ( ( )
        2. ( ( ) )
        3. ) ( )
        4. ( )
 * Time complexity:O(n);
 * Space complexity: O(1);

 */
public class _32_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int start = -1;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        res = Math.max(res, i - start);
                    } else {
                        res = Math.max(res, i - stack.peek());
                    }

                }
            }
        }
        return res;

    }
}
