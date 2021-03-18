package src; /**
 * Date: 11/18/20
 * Question Description
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 Example 1:
 Input
 ["MinStack","push","push","push","getMin","pop","top","getMin"]
 [[],[-2],[0],[-3],[],[],[],[]]

 Output
 [null,null,null,null,-3,null,0,-2]

 Explanation
 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin(); // return -3
 minStack.pop();
 minStack.top();    // return 0
 minStack.getMin(); // return -2
 */

import java.util.Stack;

/**
 * Description: TODO
 * Time complexity:O(1);
 * Space complexity: O(n);

 */
public class _155_MinStack {
    Stack<Integer> stack;
    int min;
    /** initialize your data structure here. */
    public _155_MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);

    }

    public void pop() {
        int x = stack.pop();
        if (x == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return min;
    }
}
