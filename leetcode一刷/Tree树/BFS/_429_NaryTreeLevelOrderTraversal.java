package Tree树.BFS;
/**
 * Date: 10/8/20
 * Question Description
 */

import Tree树.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description:
 Given an n-ary tree, return the level order traversal of its nodes' values.

 Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 Example 1:

 Input: root = [1,null,3,2,4,null,5,6]
 Output: [[1],[3,2,4],[5,6]]
 Example 2:



 Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]

 * Time complexity:O(n);
 * Space complexity: O(h);

 */
public class _429_NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                for (Node child : cur.children) {
                    if (child != null) queue.offer(child);
                }
                list.add(cur.val);

            }
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> levelOrderRecurse(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        helper (res, root, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, Node root, int depth) {
        if (root == null) return;
        if (res.size() <= depth) {
            res.add(new ArrayList<>());
        }
        res.get(depth).add(root.val);
        for (Node child : root.children) {
            helper(res, child, depth + 1);
        }

    }
}
