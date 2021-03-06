package Tree树.二叉搜索树BinarySearchTree;
/**
 * Date: 10/10/20
 * Question Description
 Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

 The successor of a node p is the node with the smallest key greater than p.val.
 Example 1:
 Input: root = [2,1,3], p = 1
 Output: 2
 Explanation: 1's in-order successor node is 2. Note that both p and the return value is of TreeNode type.
 Example 2:
 Input: root = [5,3,6,2,4,null,null,1], p = 6
 Output: null
 Explanation: There is no in-order successor of the current node, so the answer is null.
 */

import Tree树.TreeNode;

/**
 * Description: TODO
 * Time complexity:O(h);
 * Space complexity: O(1);

 */
public class _285_InorderSuccessorinBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            if (root.val <= p.val) {
                root = root.right;
            } else {
                res = root;
                root = root.left;
            }
        }
        return res;

    }
}
