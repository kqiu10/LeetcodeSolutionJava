package Tree.binarySearchTree.Impl;
/**
 * Date: 10/5/20
 * Question Description
 */

import Tree.binarySearchTree.IBinarySearchTree;
import Tree.binarySearchTree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

 */
public class BinarySearchTreeImpl implements IBinarySearchTree {

    private TreeNode root;
    private int size;

    public BinarySearchTreeImpl() {
        root = null;
        size = 0;

    }

    @Override
    public void add(int val) {
        root = add(root, val);

    }
    private TreeNode add(TreeNode node, int val) {
        if (node == null) {
            size++;
            return new TreeNode(val);
        }
        if (node.val == val) {
            throw new IllegalArgumentException("node already exits");
        }
        if (node.val > val) {
            node.left = add(node.left, val);
        } else {
            node.right = add(node.right, val);
        }
        return node;
    }

    @Override
    public void remove(int val) {
        root = remove(root, val);
    }

    private TreeNode remove(TreeNode node, int val) {
        if (node == null) {return null;}

        if (node.val > val) {
            node.left = remove(node.left, val);
        } else if (node.val < val) {
            node.right = remove(node.right, val);
        } else {
            if (node.left == null) {
                size--;
                return node.right;
            } else if (node.right == null) {
                size--;
                return node.left;
            }
            TreeNode minNode = findMinNode(node.right);
            node.val = minNode.val;
            node.right = remove(node.right, node.val);

        }
        return node;
    }
    private TreeNode findMinNode(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


    //Time Complexity O(logn)
    @Override
    public boolean contains(int val) {
        return contains(root, val);
    }
    private boolean contains(TreeNode root, int val) {
        if (root == null) return false;
        if (root.val == val) return true;
        else if (root.val > val) {
            return contains(root.left, val);
        } else {
            return contains(root.right, val);
        }
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private void print() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println((level + 1) + " ");
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                System.out.println(cur.val);
                if (cur.left != null) {
                    System.out.println("left child" + cur.left.val);
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    System.out.println("right child" + cur.right.val);
                    queue.offer(cur.right);
                }
            }
            System.out.println();
            level++;
        }
    }

    public static void main(String[] args) {
        BinarySearchTreeImpl binarySearchTree = new BinarySearchTreeImpl();
        binarySearchTree.add(8);
        binarySearchTree.add(5);
        binarySearchTree.add(6);
        binarySearchTree.add(3);
        binarySearchTree.add(10);
        binarySearchTree.add(9);
        binarySearchTree.add(11);
        binarySearchTree.print();
        binarySearchTree.remove(8);
        binarySearchTree.print();

    }
}
