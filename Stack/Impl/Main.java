package Stack.Impl;
/**
 * Description: TODO
 * Package Name : Stack.Impl;
 * File name : Main;
 * Creator: Kane;
 * Date: 7/22/20
 */

/**
 * Time complexity:O();
 * Space complexity: O();
 */
public class Main {
    public static void main(String[] args) {
        IArrayStack<String> stack = new IArrayStack<>();
        stack.push("1");
        stack.push("2");
        stack.peek();
        stack.print();
        stack.pop();
        stack.print();
    }
}
