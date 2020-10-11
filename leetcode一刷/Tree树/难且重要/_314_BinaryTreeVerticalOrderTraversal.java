package Tree树.难且重要;
/**
 * Date: 10/11/20
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
 Examples 3:

 Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)
 3
 /\
 /  \
 9   8
 /\  /\
 /  \/  \
 4  01   7
 /\
 /  \
 5   2

 Output:

 [
 [4],
 [9,5],
 [3,0,1],
 [8,2],
 [7]
 ]
 */

import Tree树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _314_BinaryTreeVerticalOrderTraversal {
    private int min = 0;
    private int max = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
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
            int idx = index.poll();
            res.get(idx).add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
                index.offer(idx - 1);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                index.offer(idx + 1);
            }
        }
        return res;


    }
    private void helper(TreeNode root, int idx) {
        if (root == null) return;
        min = Math.min(min, idx);
        max = Math.max(max, idx);
        helper(root.left, idx - 1);
        helper(root.right, idx + 1);
    }
}
