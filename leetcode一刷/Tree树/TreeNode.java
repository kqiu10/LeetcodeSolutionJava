package Tree树;
/**
 * Date: 10/6/20
 * Question Description
 */

/**
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

 */
public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
