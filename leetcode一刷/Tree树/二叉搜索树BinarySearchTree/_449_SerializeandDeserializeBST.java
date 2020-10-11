package Tree树.二叉搜索树BinarySearchTree;
/**
 * Date: 10/11/20
 * Question Description
 */

import Tree树.TreeNode;
import com.sun.source.tree.Tree;
import org.ietf.jgss.GSSManager;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _449_SerializeandDeserializeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            sb.append(cur.val + " ");
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        String[] str = data.split(" ");
        Queue<Integer> queue = new LinkedList<>();
        for (String s : str) {
            queue.offer(Integer.parseInt(s));
        }
        return getNode(queue);
    }
    private TreeNode getNode(Queue<Integer> queue) {
        if (queue.isEmpty()) return null;
        TreeNode root = new TreeNode(queue.poll());
        Queue<Integer> smallerQ = new LinkedList<>();
        while (!queue.isEmpty() && queue.peek() < root.val) {
            smallerQ.offer(queue.poll());
        }
        root.left = getNode(smallerQ);
        root.right = getNode(queue);
        return root;
    }
}
