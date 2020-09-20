package src.graph;
/**
 * Date: 9/19/20
 * Question Description
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class BFS {
    /**
     * bfs with class iteration
     */
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
    /**
     * bfs with matrix iteration
     */
    public static void bfsMatrixIteration(int[][] matrix) {
        int[] visited = new int[matrix.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                queue.offer(i);
                while (!queue.isEmpty()) {
                    Integer vertex = queue.poll();
                    for (int j = 0; j < matrix.length; j++) {
                        if (matrix[vertex][j] == 1) {
                            if (visited[j] == 0) {
                                queue.offer(j);
                                visited[j] = 1;
                            }
                        }
                    }
                }
            }
        }
    }
}
