package Tree树.难且重要;
/**
 * Date: 10/11/20
 * Question Description
 */

/**
 * Description:
 Given a binary tree

 struct Node {
 int val;
 Node *left;
 Node *right;
 Node *next;
 }
 Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.
 * Time complexity:O(n);
 * Space complexity: O(1);

 */
public class _117_PopulatringNextRightPointersinEachNodeII {

    public Node connect(Node root) {
        Node cur = root;
        Node pre = null;
        Node head = null;

        while (cur != null) {
            while (cur != null) {
                if (cur.left != null) {
                    if (pre != null) {
                        pre.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    pre = cur.left;
                }
                if (cur.right != null) {
                    if (pre != null) {
                        pre.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    pre = cur.right;
                }
                cur = cur.next;
            }
            cur = head;
            pre = null;
            head = null;
        }
        return root;
    }
}
