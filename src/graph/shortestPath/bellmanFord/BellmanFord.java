package graph.shortestPath.bellmanFord;
/**
 * Date: 10/5/20
 * Question Description
 */

import java.util.Arrays;

/**
 * Description: TODO
 * Time complexity:O(E * V);
 * Space complexity: O();

 */
public class BellmanFord {

    public void bellmanFord(Graph graph) {
        int[] minDist = new int[graph.vertices];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;

        for (int i = 1; i < graph.vertices; i++) {
            for (int j = 0; j < graph.allEdges.size(); j++) {
                Edge edge = graph.allEdges.get(j);
                int start = edge.start;
                int end = edge.end;
                int weight = edge.weight;
                if (minDist[start] != Integer.MAX_VALUE && minDist[start] + weight < minDist[end]) {
                    minDist[end] = minDist[start] + weight;
                }
            }
        }
        for (int j = 0; j < graph.allEdges.size(); j++) {
            Edge edge = graph.allEdges.get(j);
            int start = edge.start;
            int end = edge.end;
            int weight = edge.weight;
            if (minDist[start] != Integer.MAX_VALUE && minDist[start] + weight < minDist[end]) {
                System.out.println("negative cycle exists");
            }

        }
    }


}
