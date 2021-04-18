package src; /**
 * Date: 12/3/20
 * Question Description
 Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

 If two nodes are in the same row and column, the order should be from left to right.

 Examples 1:

 Input: [3,9,20,null,null,15,7]

 3
 /\
 /  \
 9  20
 /\
 /  \
 15   7

 Output:

 [
 [9],
 [3,15],
 [20],
 [7]
 ]
 Examples 2:

 Input: [3,9,8,4,0,1,7]

 3
 /\
 /  \
 9   8
 /\  /\
 /  \/  \
 4  01   7

 Output:

 [
 [4],
 [9],
 [3,0,1],
 [8],
 [7]
 ]
 */

import Tree.binarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description:
 * 1. DFS -> min, max
 * 2. BFS
 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _314_BinaryTreeVerticalOrderTraversal {
    int min = 0;

    int max = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, 0);
        for (int i = min; i <= max; i++) {
            res.add(new ArrayList<>());
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        index.offer(-min);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int curIndex = index.poll();
            res.get(curIndex).add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
                index.offer(curIndex - 1);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                index.offer(curIndex + 1);
            }
        }
        return res;

    }
    private void helper(TreeNode node, int level) {
        if (node == null) return;
        min = Math.min(min, level);
        max = Math.max(max, level);
        helper(node.left, level - 1);
        helper(node.right, level + 1);
    }
}
