package src; /**
 * Date: 11/23/20
 * Question Description
 */

import Tree.binarySearchTree.TreeNode;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(h);

 */
public class _230_KthSmallestElementinaBST {
    int count = 0;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return res;
    }
    private void helper(TreeNode node) {
        if (node == null) return;
        helper(node.left);
        count--;
        if (count == 0) {
            res = node.val;
        };
        helper(node.right);
    }
}
