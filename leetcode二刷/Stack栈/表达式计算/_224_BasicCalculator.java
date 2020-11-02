package Stack栈.表达式计算;
/**
 * Package Name : Stack栈.表达式计算;
 * File name : _224_BasicCalculator;
 * Creator: Kane;
 * Date: 8/24/20
 */

import java.util.Stack;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _224_BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int signal = 1;
        int res = 0;
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
