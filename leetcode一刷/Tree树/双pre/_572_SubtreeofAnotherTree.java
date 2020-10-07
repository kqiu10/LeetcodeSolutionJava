package Tree树.双pre;
/**
 * Date: 10/7/20
 * Question Description
 */

import Tree树.TreeNode;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(h);

 */
public class _572_SubtreeofAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSameTree(s, t)) return true;
        return (isSubtree(s.left, t) || isSubtree(s.right, t));
    }
    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
