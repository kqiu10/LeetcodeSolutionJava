package Tree树.二叉搜索树BinarySearchTree;
/**
 * Date: 10/10/20
 * Question Description
 Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 */

import Tree树.TreeNode;

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

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        count--;
        if (count == 0) {
            res = root.val;
        }
        helper(root.right);
    }
}
