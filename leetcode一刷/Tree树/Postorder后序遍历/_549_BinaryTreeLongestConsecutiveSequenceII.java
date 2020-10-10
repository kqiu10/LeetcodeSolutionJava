package Tree树.Postorder后序遍历;
/**
 * Date: 10/10/20
 * Question Description
 */

import Tree树.TreeNode;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(h);

 */
public class _549_BinaryTreeLongestConsecutiveSequenceII {
    int res = 0;
    public int longestConsecutive(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }
    public int[] helper(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int decrease = 1;
        int increase = 1;
        if (root.left != null) {
            if (root.left.val == root.val + 1) {
                increase = left[0] + 1;
            }
            if (root.left.val == root.val - 1) {
                decrease = left[1] + 1;
            }
        }
        if (root.right != null) {
            if (root.right.val == root.val + 1) {
                increase = Math.max(increase, right[0] + 1);
            }
            if (root.right.val == root.val - 1) {
                decrease = Math.max(decrease, right[1] + 1);
            }
        }
        res = Math.max(res, decrease + increase - 1);
        return new int[]{increase, decrease};
    }
}
