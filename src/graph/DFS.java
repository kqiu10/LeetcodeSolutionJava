package src.graph;
/**
 * Date: 9/19/20
 * Question Description
 */

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class DFS {
    /**
     * dfs with created class
     */
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

    /**
     * recursion
     */
    private static void helper(GraphNode node, HashSet<GraphNode> visited) {
        System.out.println(node.label);
        visited.add(node);
        for (GraphNode neighbor : node.neighbors) {
            if (!visited.contains(neighbor)) {
                helper(neighbor, visited);
            }
        }
    }
    /**
     * iteration
     */
    public static void dfsIteration(GraphNode graphNode) {
        Stack<GraphNode> stack = new Stack<>();
        HashSet<GraphNode> visited = new HashSet<>();
        stack.push(graphNode);
        visited.add(graphNode);
        while (!stack.isEmpty()) {
            GraphNode node = stack.pop();
            System.out.println(node.label);
            for (GraphNode neighbor : node.neighbors) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    /**
     * dfs with matrix recursion
     */
    public static void dfsMatrix(int[][] matrix) {
        int[] visited = new int[matrix.length];
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                helper(matrix, visited, i);
            }
        }
    }

    private static void helper(int[][] matrix, int[] visited, int vertex) {
        visited[vertex] = 1;
        System.out.println(vertex);
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[vertex][i] == 1) {
                if (visited[i] == 0) {
                    helper(matrix, visited, i);
                }
            }
        }
    }
    /**
     * dfs with matrix iteration
     */
    public static void dfsMatrixIteration(int[][] matrix) {
        int[] visited = new int[matrix.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                stack.push(i);
                while (!stack.isEmpty()) {
                    Integer vertex = stack.pop();
                    for (int j = 0; j < matrix.length; j++) {
                        if (matrix[vertex][j] == 1) {
                            if (visited[j] == 0) {
                                stack.push(j);
                                visited[j] = 1;
                            }
                        }
                    }
                }
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
        dfsIteration(a);
    }
}
