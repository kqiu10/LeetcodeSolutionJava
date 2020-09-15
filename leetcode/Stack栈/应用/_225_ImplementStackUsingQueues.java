package Stack栈.应用;
/**
 * Description: TODO
 * Package Name : leetcode;
 * File name : ImplementStackUsingQueues225;
 * Creator: Kane;
 * Date: 7/24/20
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Time complexity:O();
 * Space complexity: O();
 */
public class _225_ImplementStackUsingQueues {
    /** Initialize your data structure here. */
    Queue<Integer> queue;
    public _225_ImplementStackUsingQueues() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());

        }


    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();

    }

    /** Get the top element. */
    public int top() {
        return queue.peek();

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();

    }
    public void print() {
        System.out.println(queue);
    }

    public static void main(String[] args) {
        _225_ImplementStackUsingQueues queue = new _225_ImplementStackUsingQueues();
        queue.push(1);
        queue.push(2);
        queue.print();
        System.out.println(queue.top());
        System.out.println(queue.top());
        queue.empty();
    }
}
