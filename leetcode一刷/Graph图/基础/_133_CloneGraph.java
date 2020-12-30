package leetcode.Graph图.基础;
/**
 * Date: 9/18/20
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
 *
 *
 * Example 1:
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 * Output: [[2,4],[1,3],[2,4],[1,3]]
 * Explanation: There are 4 nodes in the graph.
 * 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * Example 2:
 * Input: adjList = [[]]
 * Output: [[]]
 * Explanation: Note that the input contains one empty list. The graph consists of only one node
 * with val = 1 and it does not have any neighbors.
 * Example 3:
 *
 * Input: adjList = []
 * Output: []
 * Explanation: This an empty graph, it does not have any nodes.
 * Example 4:
 * Input: adjList = [[2],[1]]
 * Output: [[2],[1]]
 */


import leetcode一刷.Graph图.Node;

import java.util.*;

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class _133_CloneGraph {

    HashMap<Node, Node> map = new HashMap<>();

    /**
     * DFS
     * @param node
     * @return
     */
    public Node cloneGraphDFS(Node node) {
        return helperDFS(node);
    }
    public Node helperDFS(Node node) {
        if (node == null) return null;
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node dup = new Node(node.val);
        map.put(node, dup);
        for (Node neighbor : node.neighbors) {
            Node clone = helperDFS(neighbor);
            dup.neighbors.add(clone);
        }
        return dup;
    }
    /**
     * BFS
     */
    public Node cloneGraphBFS(Node node) {
        if (node == null) return null;
        List<Node> nodes = getNodes(node);
        HashMap<Node, Node> map = new HashMap<>();

        for (Node cur : nodes) {
            map.put(cur, new Node(cur.val));
        }
        for (Node cur : nodes) {
            Node newNode = map.get(cur);
            for (Node neighbor : newNode.neighbors) {
                newNode.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);

    }

    private List<Node> getNodes(Node node) {
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.offer(node);
        set.add(node);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node neighbor : cur.neighbors) {
                if (!set.contains(neighbor)) {
                    queue.offer(neighbor);
                }

            }
        }
        return new ArrayList<>(set);
    }
}
