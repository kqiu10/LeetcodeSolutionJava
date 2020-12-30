/**
 * Date: 11/16/20
 * Question Description
 Given a reference of a node in a connected undirected graph.

 Return a deep copy (clone) of the graph.

 Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.

 class Node {
 public int val;
 public List<Node> neighbors;
 }
 Test case format:

 For simplicity sake, each node's value is the same as the node's index (1-indexed). For example, the first node with val = 1, the second node with val = 2, and so on. The graph is represented in the test1 case using an adjacency list.

 Adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.

 The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.



 Example 1:


 Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 Output: [[2,4],[1,3],[2,4],[1,3]]
 Explanation: There are 4 nodes in the graph.
 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 Example 2:
 Input: adjList = [[]]
 Output: [[]]
 Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.
 Example 3:

 Input: adjList = []
 Output: []
 Explanation: This an empty graph, it does not have any nodes.
 Example 4:


 Input: adjList = [[2],[1]]
 Output: [[2],[1]]
 */
import leetcode一刷.Graph图.Node;

import java.util.*;

public class _133_CloneGraph {
    /**
     * Description: DFS
     * Time complexity:O(edges + nodes);
     * Space complexity: O(nodes);
     */
    HashMap<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        return helper(node);
    }
    private Node helper(Node node) {
        if (node == null) return null;
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node copy = new Node(node.val);
        map.put(node, copy);
        for (Node neighbor : node.neighbors) {
            Node neighborCopy = helper(neighbor);
            copy.neighbors.add(neighborCopy);
        }
        return copy;

    }
    /**
     * Description: BFS
     * Time complexity:O(edges + nodes);
     * Space complexity: O(nodes);
     */
    public Node cloneGraphBFS(Node node) {
        if (node == null) return node;
        List<Node> nodes = getNodes(node);
        HashMap<Node, Node> map = new HashMap<>();
        for (Node n : nodes) {
            map.put(n, new Node(n.val));
        }
        for (Node n : nodes) {
            Node copyNode = map.get(n);
            for (Node neighbor : n.neighbors) {
                copyNode.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);

    }
    private List<Node> getNodes(Node node) {
        HashSet<Node> set = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node neighbor : cur.neighbors) {
                if (set.add(neighbor)) {
                    queue.offer(neighbor);
                }
            }
        }
        return new ArrayList<>(set);
    }
}

