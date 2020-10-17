package Tree.avl.impl;
/**
 * Date: 10/15/20
 * Question Description
 */

import Tree.avl.AVLNode;
import Tree.avl.IAVLTree;
import Tree.binarySearchTree.TreeNode;

/**
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

 */
public class AVLTreeImpl implements IAVLTree {
    AVLNode root;
    int size;

    public AVLTreeImpl() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public AVLNode add(AVLNode node, int val) {
        if (node == null) {
            size++;
            return new AVLNode(val);
        }
        if (node.val == val) {
            throw new IllegalArgumentException("node already exits");
        }
        if (node.val > val) {
            node.left = add(node.left, val);
        } else {
            node.right = add(node.right, val);
        }
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balanceFactor < -1 && getBalanceFactor(node.right) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
    private AVLNode rightRotate(AVLNode x) {
        AVLNode y = x.left;
        AVLNode C = y.right;

        y.right = x;
        x.left = C;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;

    }

    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode C = y.left;

        y.left = x;
        x.right = C;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;

    }

    private int getBalanceFactor(AVLNode node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    private int getHeight(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    private boolean isBST(AVLNode node) {
        if (node == null) return true;
        return helper(node, null, null);
    }

    public boolean helper(AVLNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    private boolean isBalanced(AVLNode node) {
        if (root == null) return true;
        return helper(node) != -1;
    }
    private int helper(AVLNode node) {
        if (node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    @Override
    public void remove(int val) {
        root = remove(root, val);
    }

    private AVLNode remove(AVLNode node, int val) {
        AVLNode changeNode = null;
        if (node == null) {return null;}
        if (node.val > val) {
            node.left = remove(node.left, val);
            changeNode = node;
        } else if (node.val < val) {
            node.right = remove(node.right, val);
            changeNode = node;
        } else {
            if (node.left == null) {
                size--;
                changeNode = node;
            } else if (node.right == null) {
                size--;
                changeNode = node;
            } else {
                AVLNode minNode = findMinNode(node.right);
                node.val = minNode.val;
                node.right = remove(node.right, node.val);
            }
        }
        if (changeNode == null) {
            return null;
        }
        node.height = 1 + Math.max(getHeight(changeNode.left), getHeight(changeNode.right));
        int balanceFactor = getBalanceFactor(changeNode);
        if (balanceFactor > 1 && getBalanceFactor(changeNode.left) >= 0) {
            return rightRotate(changeNode);
        }
        if (balanceFactor < -1 && getBalanceFactor(changeNode.right) <= 0) {
            return leftRotate(changeNode);
        }
        if (balanceFactor > 1 && getBalanceFactor(changeNode.left) < 0) {
            node.left = leftRotate(changeNode.left);
            return rightRotate(changeNode);
        }
        if (balanceFactor < -1 && getBalanceFactor(changeNode.right) < 0) {
            node.right = rightRotate(changeNode.right);
            return leftRotate(changeNode);
        }
        return changeNode;
    }
    private AVLNode findMinNode(AVLNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}
