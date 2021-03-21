/**
 * Date: 3/20/21
 * Question Description:
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where
 * each path's sum equals targetSum.
 *
 * A leaf is a node with no children.
 *
 *
 * <p>
 * Examples:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class _113_PathSumII {
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), root, targetSum);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> list, TreeNode root, int target) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                res.add(new ArrayList<>(list));
            }
        }
        helper(res, list, root.left, target - root.val);
        helper(res, list, root.right, target - root.val);
        list.remove(list.size() - 1);

    }

}
