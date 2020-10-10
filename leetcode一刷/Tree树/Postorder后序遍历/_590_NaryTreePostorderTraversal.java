package Tree树.Postorder后序遍历;
/**
 * Date: 10/10/20
 * Question Description
 Given an n-ary tree, return the postorder traversal of its nodes' values.

 Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 Follow up:

 Recursive solution is trivial, could you do it iteratively?

 Example 1:

 Input: root = [1,null,3,2,4,null,5,6]
 Output: [5,6,3,2,4,1]
 Example 2:
 Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
 */

import Tree树.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(h);

 */
public class _590_NaryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            List<Node> child = cur.children;
            res.addFirst(cur.val);
            for (Node node : child) {
                stack.push(node);
            }
        }
        return res;
    }

    public List<Integer> postorderRecurse(Node root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        helper(res, root);
        return res;
    }
    private void helper(List<Integer> res, Node root) {
        if (root == null) return;
        for (Node cur : root.children) {
            helper(res, root);
        }
        res.add(root.val);
    }
}
