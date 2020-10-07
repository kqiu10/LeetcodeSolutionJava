package Tree树.双pre;
/**
 * Date: 10/6/20
 * Question Description
 */

import Tree树.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 Given two binary trees, write a function to check if they are the same or not.

 Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

 Example 1:

 Input:      1         1
            / \       / \
            2   3     2   3

 [1,2,3],   [1,2,3]
 Output: true
 Example 2:
 Input:     1         1
           / \       / \
          2   1     1   2

 [1,2,1],   [1,1,2]

 Output: false
 * Time complexity:O();
 * Space complexity: O();

 */
public class _100_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> pl = new LinkedList<>();
        List<Integer> ql = new LinkedList<>();
        helper(p, pl);
        helper(q, ql);
        return pl.equals(ql);
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);

    }
}
