package Stack栈.表达式计算;
/**
 * Package Name : Stack栈.表达式计算;
 * File name : _227_BasicCalculatorII;
 * Creator: Kane;
 * Date: 8/24/20
 */

import java.util.Stack;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: Stack
 */
public class _227_BasicCalculatorII {
    public static int calculate(String s) {
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

    public static void main(String[] args) {
        calculate("3+2*2");
    }
}

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: Without Stack
 * Ex 3*2+4-5/2
 * pre = 0; res = 0; signal = '+';
 * res = 0; pre = 3 signal = '*';
 * pre = 6  cur = 0; signal = '+'
 * cur = 4 res  = 6, signal = '-'
 */
class  BasicCalculatorII{
    public static  int calculate(String s) {
        if (s == null || s.length() == 0) {return 0;}
        s = s.trim().replaceAll(" +", "");
        int res = 0;
        int preVal = 0;
        int i = 0;
        char signal = '+';
        while ( i < s.length()) {
            int curVal = 0;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                curVal = curVal * 10 + s.charAt(i) - '0';
                i++;
            }
            if (signal == '+') {
                res += preVal;
                preVal = curVal;
            } else if (signal == '-') {
                res += preVal;
                preVal = -curVal;
            } else if (signal == '*') {
                preVal = preVal * curVal;
            } else if (signal == '/') {
                preVal = preVal / curVal;
            }
            if (i < s.length()) {
                signal = s.charAt(i);
                i++;
            }
        }
        res += preVal;
        return res;
    }
    public static void main(String[] args) {
        calculate(" 3+5 / 2 ");
    }
}
