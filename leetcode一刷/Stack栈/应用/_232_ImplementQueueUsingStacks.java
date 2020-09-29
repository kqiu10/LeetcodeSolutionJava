package Stack栈.应用;
/**
 * Description: TODO
 * Package Name : leetcode;
 * File name : ImplementQueueUsingStacks;
 * Creator: Kane;
 * Date: 7/24/20
 */


import java.util.Stack;

/**
 * Time complexity:O();
 * Space complexity: O();
 */
public class _232_ImplementQueueUsingStacks {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public _232_ImplementQueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
            stack1.push(x);
    }
    //time : O(n);
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    //time : O(n);
    /** Get the front element. */
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();

    }



    public static void main(String[] args) {
        _232_ImplementQueueUsingStacks test = new _232_ImplementQueueUsingStacks();
        test.push(5);
        test.push(4);
        test.push(3);
        System.out.println(test.pop());
        test.push(2);
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
    }
}
class ImplementQueueUsingStacks232II {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks232II() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();

    }
    //time : O(n);
    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack2.push(x);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }
    //time : O(1);
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack1.pop();
    }
    //time : O(1);
    /** Get the front element. */
    public int peek() {
        return stack1.peek();

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();

    }



    public static void main(String[] args) {
        ImplementQueueUsingStacks232II test = new ImplementQueueUsingStacks232II();
        test.push(5);
        test.push(4);
        test.push(3);
        System.out.println(test.pop());
        test.push(2);
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
    }
}
