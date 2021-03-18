package src; /**
 * Date: 11/27/20
 * Question Description
 Given a binary tree, return all root-to-leaf paths.

 Note: A leaf is a node with no children.

 Example:

 Input:

 1
 /   \
 2     3
 \
 5

 Output: ["1->2->5", "1->3"]

 Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */

import Tree树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(h);

 */
public class _257_BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root, "");
        return res;
    }
    private void helper(List<String> res, TreeNode root, String cur) {
        if (root.left == null && root.right == null) {
            res.add(cur + root.val);
            return;
        }
        if (root.left != null) {
            helper(res, root.left, cur + root.val + "->");
        }
        if (root.right != null) {
            helper(res, root.right, cur + root.val + "->");
        }
    }
}
