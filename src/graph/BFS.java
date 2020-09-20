package src.graph;
/**
 * Date: 9/19/20
 * Question Description
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class BFS {
    public static void bfs(GraphNode node) {
        HashSet<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();

        visited.add(node);
        queue.offer(node);

        while (!queue.isEmpty()) {
            GraphNode curNode = queue.poll();
            for (GraphNode neighbor : curNode.neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

}
