package leetcode;
/**
 * Description: TODO
 * Package Name : leetcode;
 * File name : MinStack155;
 * Creator: Kane;
 * Date: 7/22/20
 */

import java.util.Stack;

/**
 * Time complexity:O();
 * Space complexity: O();
 */
public class MinStack155 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack155() {
        stack = new Stack<>();
        minStack = new Stack<>();

    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            int prev = minStack.peek();
            if (x < prev) {
                minStack.push(x);
            }
        }



    }

    public void pop() {
        int ele = stack.peek();
        if(!minStack.isEmpty()){
            int min = minStack.peek();
            if (ele == min) {
                minStack.pop();
            }
        }
        stack.pop();


    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack155 minstack = new MinStack155();
        minstack.push(3);
        System.out.println(minstack.getMin());
        minstack.push(-1);
        System.out.println(minstack.getMin());
        minstack.push(-2);
        System.out.println(minstack.getMin());
        minstack.pop();
        System.out.println(minstack.getMin());


    }
}

class MinStackII {
    Stack<Integer> stack;
    int min;
    public MinStackII(){
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
