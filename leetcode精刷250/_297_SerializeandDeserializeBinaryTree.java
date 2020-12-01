/**
 * Date: 12/1/20
 * Question Description
 Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

 Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

 Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 Example 1:
 Input: root = [1,2,3,null,null,4,5]
 Output: [1,2,3,null,null,4,5]
 Example 2:

 Input: root = []
 Output: []
 Example 3:

 Input: root = [1]
 Output: [1]
 Example 4:

 Input: root = [1,2]
 Output: [1,2]
 */

import Tree树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _297_SerializeandDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                sb.append("null ");
                continue;
            }
            sb.append(cur.val + " ");
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        String[] vals = data.split("\\s+");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < vals.length; i++) {
            TreeNode cur = queue.poll();
            if (!vals[i].equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.offer(cur.left);
            }
            if (!vals[++i].equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.offer(cur.right);
            }
        }
        return root;
    }
}
