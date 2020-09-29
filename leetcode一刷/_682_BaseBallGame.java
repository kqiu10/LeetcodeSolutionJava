/**
 * Package Name : PACKAGE_NAME;
 * File name : _682_BaseBallGame;
 * Creator: Kane;
 * Date: 8/31/20
 */

import java.util.Stack;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _682_BaseBallGame {
    public int calPoints(String[] ops) {
        if (ops == null || ops.length == 0) return 0;
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (op.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b);
                stack.push(a);
                stack.push(a + b);
            } else {
                stack.push(Integer.valueOf(op));
            }
        }
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
