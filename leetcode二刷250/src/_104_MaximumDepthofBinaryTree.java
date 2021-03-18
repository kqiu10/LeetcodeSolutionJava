/**
 * Date: 3/18/21
 * Question Description:
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node
 * down to the farthest leaf node.
 *
 *
 * <p>
 * Examples:
 */


/**
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class _104_MaximumDepthofBinaryTree {
    private class TreeNode {
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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int maxLeft = maxDepth(root.left) + 1;
        int maxRight = maxDepth(root.right) + 1;
        return Math.max(maxLeft, maxRight);

    }
}
