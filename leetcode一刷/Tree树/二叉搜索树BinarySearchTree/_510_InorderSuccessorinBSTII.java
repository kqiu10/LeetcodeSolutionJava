package Tree树.二叉搜索树BinarySearchTree;
/**
 * Date: 10/10/20
 * Question Description
 */



/**
 * Description: TODO
 * Time complexity:O(h);
 * Space complexity: O(1);

 */
public class _510_InorderSuccessorinBSTII {
    public Node inorderSuccessor(Node node) {
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return node.parent;
    }
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };
}
