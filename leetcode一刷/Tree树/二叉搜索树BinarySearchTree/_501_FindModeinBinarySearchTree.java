package Tree树.二叉搜索树BinarySearchTree;
/**
 * Date: 10/10/20
 * Question Description
 Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 Both the left and right subtrees must also be binary search trees.
 For example:
 Given BST [1,null,2,2],

 1
 \
 2
 /
 2
 return [2].
 */

import Tree树.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(n);

 */

public class _501_FindModeinBinarySearchTree {
    HashMap<Integer, Integer> map;
    int max = 0;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[]{};
        map = new HashMap<>();
        helper(root);
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                list.add(key);
            }
        }
        int res[] = new int[list.size()];
        for(int i=0;i<list.size();i++)
            res[i] = list.get(i);
        return res;
    }
    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        int cur = map.get(root.val);
        max = Math.max(max, cur);
        helper(root.right);
    }
}
