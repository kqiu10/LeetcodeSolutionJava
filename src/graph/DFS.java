package src.graph;
/**
 * Date: 9/19/20
 * Question Description
 */

import java.util.HashSet;
import java.util.List;

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class DFS {

    public static void dfs(List<GraphNode> list) {
        HashSet<GraphNode> visited = new HashSet<>();
        for (GraphNode node : list) {
            if (!visited.contains(node)) {
                helper(node, visited);
            }
        }
    }

    public static void dfs2(GraphNode node) {
        helper(node, new HashSet<>());
    }

    private static void helper(GraphNode node, HashSet<GraphNode> visited) {
        System.out.println(node.label);
        visited.add(node);
        for (GraphNode neighbor : node.neighbors) {
            if (!visited.contains(neighbor)) {
                helper(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        GraphNode a = new GraphNode(0);
        GraphNode b = new GraphNode(1);
        GraphNode c = new GraphNode(2);

        a.neighbors.add(b);
        a.neighbors.add(c);

        dfs2(a);
    }
}
