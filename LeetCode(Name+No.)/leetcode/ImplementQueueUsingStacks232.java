package leetcode;
/**
 * Description: TODO
 * Package Name : leetcode;
 * File name : ImplementQueueUsingStacks;
 * Creator: Kane;
 * Date: 7/24/20
 */


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Time complexity:O();
 * Space complexity: O();
 */
public class ImplementQueueUsingStacks232 {
    Queue<Integer> queue;
    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks232() {
        queue = new LinkedList<>();

    }

    /** Push element x to the back of queue. */
    public void push(int x) {

        for (int i = 0; i < queue.size() - 1; i++) {
             queue.offer(queue.poll());

        }
        queue.offer(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return queue.poll();

    }

    /** Get the front element. */
    public int peek() {
        return queue.peek();

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue.isEmpty();

    }

    public void print() {
        System.out.println("size is " + queue.size());

            System.out.println(queue);
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks232 test = new ImplementQueueUsingStacks232();
        test.push(1);
        test.push(2);
        test.push(3);
        test.print();
        test.pop();
        test.print();
    }
}
