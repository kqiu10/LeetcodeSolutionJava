package leetcode;
/**
 * Date: 9/23/20
 * Question Description
 * Given a string containing only three types of characters: '(', ')' and '*', write a function
 * to check whether this string is valid. We define the validity of a string by these rules:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an
 * empty string.
 * An empty string is also valid.
 *

import java.util.PriorityQueue;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(1);

 */
public class _678_ValidParenthesisString {
    public boolean checkValidString(String s) {
        int minOpen = 0, maxOpen = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else {
                minOpen--;
                maxOpen++;
            }
            if (maxOpen < 0) {
                return false;
            }
            minOpen = Math.max(minOpen, 0);
        }
        return minOpen == 0;
    }
}
