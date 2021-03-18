package src; /**
 * Date: 11/12/20
 * Question Description
 Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

 1
 / \
 2   2
 / \ / \
 3  4 4  3
 But the following [1,2,2,null,3,null,3] is not:

 1
 / \
 2   2
 \   \
 3    3

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
        return helper(root, root);

    }
    private boolean helper (TreeNode left ,TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
