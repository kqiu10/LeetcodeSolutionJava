package graph.shortestPath.bellmanFord;
/**
 * Date: 10/3/20
 * Question Description
 */

import java.util.ArrayList;

/**
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

 */
public class Graph {

    int vertices;
    ArrayList<Edge> allEdges;

    public Graph(int vertices) {
        this.vertices = vertices;
        allEdges = new ArrayList<>();
    }

    public void addEdge(int start, int end, int weight) {
        Edge edge = new Edge(start, end, weight);
        allEdges.add(edge);
    }
}
