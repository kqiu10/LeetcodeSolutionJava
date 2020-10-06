package Tree树.难且重要;
import Tree树.难且重要.Node;
/**
 * Date: 10/6/20
 * Question Description
 */

/**
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

 */
public class _116_PopulatingNextRightPointersinEachNode {
    public Node connect(Node root) {
        if (root == null) return null;
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.next != null && root.right != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
