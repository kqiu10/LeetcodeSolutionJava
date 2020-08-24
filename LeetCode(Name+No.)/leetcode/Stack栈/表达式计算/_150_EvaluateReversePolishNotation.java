package Stack栈.表达式计算;
/**
 * Package Name : Stack栈.表达式计算;
 * File name : EvaluateReversePolishNotation150;
 * Creator: Kane;
 * Date: 8/24/20
 */

import java.util.Stack;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());

            } else if (s.equals("-")) {
                int last = stack.pop();
                stack.push(stack.pop() - last);

            } else if (s.equals("*")) {

                stack.push(stack.pop() * stack.pop());

            } else if (s.equals("/")) {
                int last = stack.pop();
                stack.push(stack.pop() / last);
            } else {
                stack.push(Integer.parseInt(s));
            }

        }
        return stack.pop();
    }

}
