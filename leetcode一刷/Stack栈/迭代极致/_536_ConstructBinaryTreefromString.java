package Stack栈.迭代极致;
/**
 * Package Name : Stack栈.迭代极致;
 * File name : _536_ConstructBinaryTreefromString;
 * Creator: Kane;
 * Date: 8/27/20
 */

import java.util.Stack;

/**
 *
 * You need to construct a binary tree from a string consisting of parenthesis and integers.
 *
 * The whole input represents a binary tree. It contains an integer followed by zero, one or two
 * pairs of parenthesis. The integer represents the root's value and a pair of parenthesis
 * contains a child binary tree with the same structure.
 *
 * You always start to construct the left child node of the parent first if it exists.
 *
 * Example:
 * Input: "4(2(3)(1))(6(5))"
 * Output: return the tree root node representing the following tree:
 *
 *        4
 *      /   \
 *     2     6
 *    / \   /
 *   3   1 5
 * Note:
 * There will only be '(', ')', '-' and '0' ~ '9' in the input string.
 * An empty tree is represented by "" instead of "()".
 *
 *
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description:
 * stack only store branch node
 */
public class _536_ConstructBinaryTreefromString {
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            char c = s.charAt(i);
            if (c == ')') {
                stack.pop();
            } else if ((c >= '0' && c <= '9') || c == '-') {
                while (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') i++;
                TreeNode cur = new TreeNode(Integer.parseInt(s.substring(j, i + 1)));
                if (!stack.isEmpty()) {
                    TreeNode parent = stack.peek();
                    if (parent.left != null) {
                        parent.right = cur;
                    } else {
                        parent.left = cur;
                    }
                }
                stack.push(cur);
            }
        }
        return stack.peek();



    }
}
class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }

            TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
             }
}
