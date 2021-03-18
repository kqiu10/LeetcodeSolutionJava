package src; /**
 * Date: 11/19/20
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

import Tree.binarySearchTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _173_BinarySearchTreeIterator {
    Queue<Integer> queue;
    public _173_BinarySearchTreeIterator(TreeNode root) {
        queue = new LinkedList<>();
        helper(root, queue);
    }
    private void helper(TreeNode node, Queue<Integer> queue) {
        if (node == null) return;
        helper(node.left, queue);
        queue.offer(node.val);
        helper(node.right, queue);
    }

    /** @return the next smallest number */
    public int next() {
        return queue.poll();

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
