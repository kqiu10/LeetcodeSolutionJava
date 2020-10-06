package Tree树; /**
 * Date: 10/5/20
 * Question Description
 */

/**
 * Description:
 * You are given a perfect binary tree where all leaves are on the same level, and every parent
 * has two children. The binary tree has the following definition:
 *
 * struct Tree树.Node {
 *   int val;
 *   Tree树.Node *left;
 *   Tree树.Node *right;
 *   Tree树.Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node,
 * the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Time complexity:O(n);
 * Space complexity: O(n); worst case : LinkedList

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
