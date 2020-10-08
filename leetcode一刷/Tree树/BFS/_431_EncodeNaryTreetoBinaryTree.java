package Tree树.BFS;
/**
 * Date: 10/8/20
 * Question Description
 */

import Tree树.Node;
import Tree树.TreeNode;

import java.util.LinkedList;

/**
 * Description:
 // Encodes an n-ary tree to a binary tree.
 public TreeNode encode(Node root) {

 }

 // Decodes your binary tree to an n-ary tree.
 public Node decode(TreeNode root) {

 }
 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _431_EncodeNaryTreetoBinaryTree {
    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if (root == null) return null;
        TreeNode res = new TreeNode(root.val);
        if (root.children.size() > 0) {
            res.left = encode(root.children.get(0));
        }
        TreeNode cur = res.left;
        for (int i = 1; i < root.children.size(); i++) {
            cur.right = encode(root.children.get(i));
            cur = cur.right;
        }
        return res;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (root == null) return null;
        Node res = new Node(root.val, new LinkedList<>());
        TreeNode cur = root.left;
        while (cur != null) {
            res.children.add(decode(cur));
            cur = cur.right;
        }
        return res;

    }
}
