package Tree树.Preorder先序遍历;
/**
 * Date: 10/6/20
 * Question Description
 */

import Tree树.TreeNode;

import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 Given a binary tree, return all root-to-leaf paths.

 Note: A leaf is a node with no children.

 Example:

 Input:

   1
 /   \
 2   3
 \
  5

 Output: ["1->2->5", "1->3"]

 Explanation: All root-to-leaf paths are: 1->2->5, 1->3
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

    private void helper(List<String> res, TreeNode root, String path) {
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
            return;
        }
        if (root.left != null) {
            helper(res, root.left, path + root.val + "->");
        }
        if (root.right != null) {
            helper(res, root.right, path + root.val + "->");
        }
    }
}
