/**
 * Date: 11/14/20
 * Question Description
 */

import Tree树.TreeNode;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(h);

 */
public class _124_BinaryTreeMaximumPathSum {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }
    private int helper(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, helper(node.left));
        int right = Math.max(0, helper(node.right));
        res = Math.max(res, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
