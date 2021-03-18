package src; /**
 * Date: 11/23/20
 * Question Description
 */

import java.util.Stack;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _232_ImplementQueueusingStacks {
    Stack<Integer> first;
    Stack<Integer> second;
    /** Initialize your data structure here. */
    public _232_ImplementQueueusingStacks() {
        first = new Stack<>();
        second = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        first.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (second.isEmpty()) {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
        }
        return second.pop();

    }

    /** Get the front element. */
    public int peek() {
        if (second.isEmpty()) {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
        }
        return second.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (first.isEmpty() && second.isEmpty());
    }
}
