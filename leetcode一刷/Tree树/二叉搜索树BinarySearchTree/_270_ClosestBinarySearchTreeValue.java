package Tree树.二叉搜索树BinarySearchTree;
/**
 * Date: 10/10/20
 * Question Description
 */

import Tree树.TreeNode;

/**
 * Description: TODO
 * Time complexity:O(h);
 * Space complexity: O(1);

 */
public class _270_ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(res - target)) {
                res =  root.val;
            }
            root = root.val > target ? root.left : root.right;
        }
        return res;
    }
}
