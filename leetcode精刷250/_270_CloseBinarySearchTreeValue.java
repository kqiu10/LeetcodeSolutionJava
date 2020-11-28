/**
 * Date: 11/28/20
 * Question Description
 Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

 Note:

 Given target value is a floating point.
 You are guaranteed to have only one unique value in the BST that is closest to the target.
 Example:

 Input: root = [4,2,5,1,3], target = 3.714286

     4
    / \
   2   5
  / \
 1   3
 */

import Tree.binarySearchTree.TreeNode;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(h);

 */
public class _270_CloseBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(res - target)) {
                res = root.val;
            }
            root = root.val > target ? root.left : root.right;
        }
        return res;
    }
}
