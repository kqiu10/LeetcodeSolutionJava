package Stack.Impl;
/**
 * Description: TODO
 * Package Name : Stack.Impl;
 * File name : Main;
 * Creator: Kane;
 * Date: 7/22/20
 */

import Stack.ILinkedListStack;

/**
 * Time complexity:O();
 * Space complexity: O();
 */
public class Main {
    public static void main(String[] args) {
        IArrayStackImp<String> stack = new IArrayStackImp<>();
        stack.push("1");
        stack.push("2");
        stack.peek();
        stack.print();
        stack.pop();
        stack.print();
        ILinkedListStack<Integer> LinkedStack = new ILinkedListStackImp<>();
        LinkedStack.push(1);
        LinkedStack.push(4);
        System.out.println(LinkedStack.peek());
        LinkedStack.print();
    }
}
