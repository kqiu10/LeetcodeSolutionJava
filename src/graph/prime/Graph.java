package graph.prime;
/**
 * Date: 10/3/20
 * Question Description
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

 */
public class Graph {
    int vertices;

    List<Edge>[] list;

    public Graph(int vertices) {
        this.vertices = vertices;
        list = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            list[i] = new ArrayList<>();
        }
    }

    public void addEdge(int start, int end, int weight) {
        Edge edgeS = new Edge(start, end ,weight);
        list[start].add(edgeS);

        Edge edgeE = new Edge(end, start, weight);
        list[end].add(edgeE);
    }
}
