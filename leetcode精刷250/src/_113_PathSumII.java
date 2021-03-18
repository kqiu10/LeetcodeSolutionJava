package src; /**
 * Date: 11/12/20
 * Question Description
 Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 Note: A leaf is a node with no children.
 Example:
 Given the below binary tree and sum = 22,

       5
      / \
     4   8
    /   / \
   11  13  4
  /  \    / \
 7    2  5   1
 Return:

 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */

import Tree树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(h);

 */
public class _113_PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root, new ArrayList<>(), sum);
        return res;
    }
    private void helper(List<List<Integer>> res, TreeNode node, List<Integer> list, int sum) {
        if (node == null) return;
        list.add(node.val);
        if (node.left == null && node.right == null && node.val == sum) {
            res.add(new ArrayList<>(list));
        }
        helper(res, node.left, list, sum - node.val);
        helper(res, node.right, list, sum - node.val);
        list.remove(list.size() - 1);
    }
}
