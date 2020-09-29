package Parentheses;
/**
 * Package Name : Parentheses;
 * File name : _32_LongestValidParentheses;
 * Creator: Kane;
 * Date: 9/5/20
 */

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest
 * valid (well-formed) parentheses substring.
 *
 * Example 1:
 *
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 *
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 *
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description:
 * start = -1 : 考虑第0位元素
 * 0 1 2 3 4 5
 * ) ( ) ( ) )
 *
 * Ex  0 1 2 3 4 5  for
 *     ( ( ) )
 *
 *                     if (stack.isEmpty()) {
 *                         res = Math.max(res, i - start);
 *                     } else {
 *                         res = Math.max(res, i - stack.peek());
 *                     }

 */
public class _32_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int start = -1;
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
