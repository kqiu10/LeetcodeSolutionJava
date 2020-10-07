package Tree树.双pre;
/**
 * Date: 10/7/20
 * Question Description
 */

import Tree树.TreeNode;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(h);

 */
public class _101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
