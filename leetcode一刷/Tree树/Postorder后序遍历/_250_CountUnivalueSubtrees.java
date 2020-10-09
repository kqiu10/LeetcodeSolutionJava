package Tree树.Postorder后序遍历;
/**
 * Date: 10/9/20
 * Question Description
 Given the root of a binary tree, return the number of uni-value subtrees.

 A uni-value subtree means all nodes of the subtree have the same value.
 Example 1:
 Input: root = [5,1,5,5,5,null,5]
 Output: 4
 */

import Tree树.TreeNode;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(h);

 */
public class _250_CountUnivalueSubtrees {
    private int res = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;

    }

    private boolean helper(TreeNode root) {
        if (root == null) return true;
        boolean left = helper(root.left);
        boolean right = helper(root.right);

        if (left && right) {
            if (root.left != null && root.val != root.left.val) {
                return false;
            }
            if (root.right != null && root.val != root.right.val) {
                return false;
            }
            res++;
            return true;
        }
        return false;
    }
}
