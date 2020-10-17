package Tree.avl;
/**
 * Date: 10/15/20
 * Question Description
 */

/**
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

 */
public class AVLNode {
    public int val;
    public int height;
    public AVLNode left;
    public AVLNode right;

    public AVLNode(int val) {
        this.val = val;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
}
