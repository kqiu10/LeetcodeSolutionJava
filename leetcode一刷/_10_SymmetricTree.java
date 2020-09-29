/**
 * Package Name : PACKAGE_NAME;
 * File name : _10_SymmetricTree;
 * Creator: Kane;
 * Date: 9/2/20
 */


/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _10_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    private boolean isMirror(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        return (n1.val == n2.val) && isMirror(n1.right, n2.left) && isMirror(n1.left, n2.right);
    }
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
}
