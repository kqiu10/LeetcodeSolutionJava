package Tree树.二叉搜索树BinarySearchTree;
/**
 * Date: 10/10/20
 * Question Description
 Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

 Calling next() will return the next smallest number in the BST.
 Example:
 BSTIterator iterator = new BSTIterator(root);
 iterator.next();    // return 3
 iterator.next();    // return 7
 iterator.hasNext(); // return true
 iterator.next();    // return 9
 iterator.hasNext(); // return true
 iterator.next();    // return 15
 iterator.hasNext(); // return true
 iterator.next();    // return 20
 iterator.hasNext(); // return false
 */

import Tree树.TreeNode;

import java.util.Stack;

/**
 * Description:
 * Time complexity:O(n);
 * Space complexity: O(h);

 */
public class _173_BinarySearchTreeIterator {

    TreeNode cur;
    Stack<TreeNode> stack;

    public _173_BinarySearchTreeIterator(TreeNode root) {
        cur = root;
        stack = new Stack<>();
    }

    /** @return the next smallest number */
    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int val = cur.val;
        cur = cur.right;
        return val;

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (!stack.isEmpty() || cur != null) {
            return true;
        }
        return false;
    }
}
