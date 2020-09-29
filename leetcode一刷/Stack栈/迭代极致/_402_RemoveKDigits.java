package Stack栈.迭代极致;
/**
 * Package Name : Stack栈.迭代极致;
 * File name : _402_RemoveKDigits;
 * Creator: Kane;
 * Date: 8/27/20
 */

import java.util.Stack;

/**
 * Given a non-negative integer num represented as a string, remove k digits from the number so
 * that the new number is the smallest possible.
 *
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the
 * smallest.
 * Example 2:
 *
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain
 * leading zeroes.
 * Example 3:
 *
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 *
 *
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description:
 * every time pop one character out from stack is to delete one element to initial array;
 * edge case "1111"
 *           "10010" k = 1
 */
public class _402_RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) return "0";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        int begin = 0;
        while (begin < sb.length() && sb.charAt(begin) == '0') {
            begin++;
        }
        return begin == sb.length() ? "0" : sb.substring(begin);


    }
}
