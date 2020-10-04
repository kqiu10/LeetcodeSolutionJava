package graph.shortestPath.dijkstra;
/**
 * Date: 10/4/20
 * Question Description
 */

import java.util.Arrays;

/**
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

 */
public class DijkstraMatrix {
    public void dijkstra(int[][] matrix) {
        int vertices = matrix.length;
        boolean[] visited = new boolean[vertices];
        int[] minDist = new int[vertices];

        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;
        for (int i = 0; i < vertices; i++) {
            int vertex = getMinVerterx(visited, minDist);
            visited[vertex] = true;
            for (int j = 0; j < vertices; j++) {
                if (!visited[j] && matrix[vertex][j] != 0) {
                    int curDist = matrix[vertex][j] + minDist[vertex];
                    if (curDist < minDist[j]) {
                        minDist[j] = curDist;
                    }
                }
            }
        }
    }

    private int getMinVerterx(boolean[] visited, int[] minDist) {
        int min = Integer.MAX_VALUE;
        int vertex = -1;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && minDist[i] < min) {
                min = minDist[i];
                vertex = i;
            }
        }
        return vertex;
    }

}
