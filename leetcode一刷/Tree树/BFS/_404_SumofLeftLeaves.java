package Tree树.BFS;
/**
 * Date: 10/8/20
 * Question Description
 */

import Tree树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 Find the sum of all left leaves in a given binary tree.

 Example:

 3
 / \
 9  20
 /  \
 15   7

 There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 * Time complexity:O();
 * Space complexity: O();

 */
public class _404_SumofLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                res += root.left.val;
            } else {
                res += sumOfLeftLeaves(root.left);
            }
        }
        res += sumOfLeftLeaves(root.right);
        return res;

    }

    public int sumOfLeftLeavesIterate(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                if (cur.left.left == null && cur.left.right == null) {
                    res += cur.left.val;
                } else {
                    queue.offer(cur.left);
                }
            }
            if (cur.right != null) queue.offer(cur.right);
        }
        return res;

    }

}
