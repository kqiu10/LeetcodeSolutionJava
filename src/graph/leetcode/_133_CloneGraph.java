package src.graph.leetcode;
/**
 * Date: 9/19/20
 * Question Description
 * Given a reference of a node in a connected undirected graph.
 *
 * Return a deep copy (clone) of the graph.
 *
 * Each node in the graph contains a val (int) and a list (List[Tree树.Node]) of its neighbors.
 *
 * class Tree树.Node {
 *     public int val;
 *     public List<Tree树.Node> neighbors;
 * }
 *
 *
 * Test case format:
 *
 * For simplicity sake, each node's value is the same as the node's index (1-indexed). For
 * example, the first node with val = 1, the second node with val = 2, and so on. The graph is
 * represented in the test1 case using an adjacency list.
 *
 * Adjacency list is a collection of unordered lists used to represent a finite graph. Each list
 * describes the set of neighbors of a node in the graph.
 *
 * The given node will always be the first node with val = 1. You must return the copy of the
 * given node as a reference to the cloned graph.
 *
 */

import java.util.*;
import src.graph.leetcode.Node;

public class _133_CloneGraph {
    /**
     * Time complexity:O(V + E);
     * Space complexity: O(V);
     * Description: DFS
     */
    public Node cloneGraph(Node node) {
        return helper(node, new HashMap<>());
    }
    public Node helper(Node node, HashMap<Node, Node> map) {
        List<Node> neighbors = new ArrayList<>();
        Node copy = new Node(node.val, neighbors);
        map.put(node, copy);
        for (Node neighbor : node.neighbors) {
            if (!map.containsKey(neighbor)) {
             neighbors.add(helper(neighbor, map));
            } else {
                neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
    /**
     * Time complexity:O(V + E);
     * Space complexity: O(V);
     * Description: BFS
     */
    public Node cloneGraph2(Node node) {
        if (node == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);
        map.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            map.get(cur).neighbors = new ArrayList<>();
            for (Node neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }

}


