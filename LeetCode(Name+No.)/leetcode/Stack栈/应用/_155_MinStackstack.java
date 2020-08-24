package Stack栈.应用;
/**
 * Package Name : Stack栈;
 * File name : MinStackstack155;
 * Creator: Kane;
 * Date: 8/23/20
 */

import java.util.Stack;

/**
 * Time complexity:O(1);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _155_MinStackstack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    /** initialize your data structure here. */
    public _155_MinStackstack() {
        stack = new Stack<>();
        minStack = new Stack<>();

    }

    public void push(int x) {
        stack.push(x);
        if (!minStack.isEmpty()) {
            int top = minStack.peek();
            if (x <= top) {
                minStack.push(x);
            }
        } else {
            minStack.push(x);
        }

    }

    public void pop() {
        int top = stack.pop();
        if(top == minStack.peek()) minStack.pop();

    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return minStack.peek();

    }
}

class MinStackstackII{
    Stack<Integer> stack;
    int min;

    /** initialize your data structure here. */
    public MinStackstackII() {
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
        if (min == stack.pop()) {
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
