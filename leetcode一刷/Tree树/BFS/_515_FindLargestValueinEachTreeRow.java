package Tree树.BFS;
/**
 * Date: 10/8/20
 * Question Description
 */

import Tree树.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description:
 Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).

 Example 1:
 Input: root = [1,3,2,5,3,null,9]
 Output: [1,3,9]

 Example 2:
 Input: root = [1,2,3]
 Output: [1,3]

 Example 3:
 Input: root = [1]
 Output: [1]

 Example 4:
 Input: root = [1,null,2]
 Output: [1,2]

 Example 5:
 Input: root = []
 Output: []


 * Time complexity:O(n);
 * Space complexity: O(h);

 */
public class _515_FindLargestValueinEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                max = Math.max(max, cur.val);
            }
            res.add(max);
        }
        return res;
    }

    public List<Integer> largestValuesRecurse(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        helper(root, res, 0);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res, int depth) {
        if (root == null) return;
        if (depth == res.size()) {
            res.add(Integer.MIN_VALUE);
        }
        int val = Math.max(res.get(depth), root.val);
        res.set(depth, val);
        helper(root.left, res,depth + 1);
        helper(root.right, res, depth + 1);

    }



}
