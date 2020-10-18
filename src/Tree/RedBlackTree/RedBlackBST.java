package Tree.RedBlackTree;
/**
 * Date: 10/17/20
 * Question Description
 */

/**
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

 */
public class RedBlackBST<Key extends  Comparable<Key>, value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;
    private class Node {
        private Key key;
        private value value;
        private Node left, right;
        private boolean color;
        private int size;

        public Node(Key key, value value, boolean color, int size) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.size = size;
        }
    }

    public RedBlackBST() {

    }
    private boolean isRed(Node node) {
        if (node == null) return  false;
        return node.color == RED;
    }
    private int size(Node node) {
        if (node == null) return 0;
        return node.size;
    }
    public int size() {
        return size(root);
    }
    public boolean isEmpty() {
        return root == null;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h.left;
        x.color = x.left.color;
        x.left.color = RED;
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }

}
