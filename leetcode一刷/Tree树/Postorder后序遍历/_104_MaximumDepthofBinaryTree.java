package Tree树.Postorder后序遍历;
/**
 * Date: 10/8/20
 * Question Description
 */

import Tree树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
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


 * Time complexity:O(n);
 * Space complexity: O(h);

 */
public class _104_MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepthII(TreeNode root) {
        if (root == null) return 0;
        int l = maxDepthII(root.left) + 1;
        int r = maxDepthII(root.right) + 1;
        return Math.max(l, r);
    }

}
