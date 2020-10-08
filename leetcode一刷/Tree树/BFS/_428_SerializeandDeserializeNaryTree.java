package Tree树.BFS;
/**
 * Date: 10/8/20
 * Question Description
 */

import Tree树.Node;

import java.util.*;

/**
 * Description:
 Serialization is the process of converting a data structure or object into a sequence of bits
 so that it can be stored in a file or memory buffer, or transmitted across a network connection
 link to be reconstructed later in the same or another computer environment.

 Design an algorithm to serialize and deserialize an N-ary tree. An N-ary tree is a rooted tree
 in which each node has no more than N children. There is no restriction on how your
 serialization/deserialization algorithm should work. You just need to ensure that an
 N-ary tree can be serialized to a string and this string can be deserialized to the original tree structure.

 For example, you may serialize the following 3-ary tree

 as [1 [3[5 6] 2 4]]. Note that this is just an example, you do not necessarily need to follow this format.

 Or you can follow LeetCode's level order traversal serialization format, where each group of children
 is separated by the null value.

 For example, the above tree may be serialized
 as [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14].

 
 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _428_SerializeandDeserializeNaryTree {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        List<String> list = new ArrayList<>();
        serializeHelper(root, list);
        return String.join(",", list);

    }
    private void serializeHelper(Node root, List<String> list) {
        if (root == null) return;
        list.add(String.valueOf(root.val));
        list.add(String.valueOf(root.children.size()));
        for (Node child : root.children) {
            serializeHelper(child, list);
        }

    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] s = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(s));
        return deserializeHelper(queue);
    }
    private Node deserializeHelper(Queue<String> queue) {
        Node root = new Node();
        root.val = Integer.parseInt(queue.poll());
        int size = Integer.parseInt(queue.poll());
        root.children = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            root.children.add(deserializeHelper(queue));
        }
        return root;
    }
}
