package Tree树.Preorder先序遍历;
/**
 * Date: 10/6/20
 * Question Description
 */

import Tree树.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Description:
 Given an n-ary tree, return the preorder traversal of its nodes' values.

 Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 Follow up:

 Recursive solution is trivial, could you do it iteratively?
 Example 1:
 Input: root = [1,null,3,2,4,null,5,6]
 Output: [1,3,5,6,2,4]
 Example 2:
 Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]


 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _589_Nary_Tree_Preorder_Traversal {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, res);
        return res;

    }

    private void helper(Node root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        for (Node child : root.children) {
            helper(child, res);
        }
    }

    public List<Integer> preorderIterate(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
        Node cur = stack.pop();
        for (int i = cur.children.size() - 1; i >= 0; i--) {
                stack.push(cur.children.get(i));
            }
            res.add(cur.val);
        }
        return res;
    }

}
