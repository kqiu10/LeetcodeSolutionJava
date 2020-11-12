/**
 * Date: 11/12/20
 * Question Description
 Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 Note: A leaf is a node with no children.

 Example:

 Given binary tree [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 return its depth = 3.
 */

import Tree树.TreeNode;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(h);

 */
public class _104_MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int maxLeft = maxDepth(root.left) + 1;
        int maxRight = maxDepth(root.right) + 1;
        return Math.max(maxLeft, maxRight);

    }
}
