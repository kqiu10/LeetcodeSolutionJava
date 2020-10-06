package Tree树.Preorder先序遍历;
/**
 * Date: 10/6/20
 * Question Description
 */

import Tree树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(h);

 */
public class _513_FindBottomLeftTreeValue {
    private int res = 0;
    private int height = 0;
    public int findBottomLeftValueDFS(TreeNode root) {

        if (root == null) return -1;
        helper(root, 1);
        return res;

    }
    private void helper (TreeNode root, int depth) {
        if (root == null) return;
        if (height < depth) {
            res = root.val;
            height = depth;
        }
        helper(root.left, depth + 1);
        helper(root.right, depth + 1);
    }
    public int findBottomLeftValueBFS(TreeNode root) {
        if (root == null) return -1;
        Queue<TreeNode> queue = new LinkedList<>();
        int res = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            res = cur.val;
            if (cur.right != null) {
                queue.offer(cur.right);
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
        }
        return res;
    }
}
