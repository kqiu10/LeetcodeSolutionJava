/**
 * Date: 11/23/20
 * Question Description
 Implement a basic calculator to evaluate a simple expression string.

 The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

 Example 1:

 Input: "3+2*2"
 Output: 7
 Example 2:

 Input: " 3/2 "
 Output: 1
 Example 3:

 Input: " 3+5 / 2 "
 Output: 5
 */

import java.util.Stack;


public class _227_BasicCalculatorII {
    /**
     * Description: TODO
     * Time complexity:O(n);
     * Space complexity: O(1);
     * Ex 3*2+4-5/2
     * pre = 0; res = 0; signal = '+';
     * res = 0; pre = 3 signal = '*';
     * pre = 6  cur = 0; signal = '+'
     * cur = 4 res  = 6, signal = '-'
     */
    public int calculate(String s) {
        Stack<Integer> num = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num.push(c - '0');
            } else {
                operator.push(c);
            }
        }
        while (!operator.isEmpty()) {
            char c = operator.pop();
            if (c == ' ') continue;
            if (c == '+') {
                int prev = num.pop();
                num.push(prev + num.pop());
            } else if (c == '*') {
                int prev = num.pop();
                num.push(prev * num.pop());
            } else if (c == '/') {
                int prev = num.pop();
                num.push(num.pop() / prev);
            } else {
                int prev = num.pop();
                num.push(num.pop() - prev);
            }
        }
        return num.peek();
    }
    /**
     * Description: Stack
     * Time complexity:O(n);
     * Space complexity: O(n);
     */
    public int calculateII(String s) {
        if (s == null || s.length() == 0) {return 0;}
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        char signal = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
                if (signal == '+') stack.push(num);
                if (signal == '-') stack.push(-num);
                if (signal == '*') stack.push(stack.pop() * num);
                if (signal == '/') stack.push(stack.pop() / num);
                signal = s.charAt(i);
                num = 0;
            }
        }
        for (int i : stack) {
            res += i;
        }
        return res;
    }
}
