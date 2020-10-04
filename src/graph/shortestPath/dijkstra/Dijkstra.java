package graph.shortestPath.dijkstra;
/**
 * Date: 10/4/20
 * Question Description
 */

import java.nio.channels.Pipe;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

 */
public class Dijkstra {
    public void dijkstra(Graph graph) {
        boolean[] visited = new boolean[graph.vertices];
        int[] minDist = new int[graph.vertices];

        Arrays.fill(minDist, Integer.MAX_VALUE);
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(graph.vertices, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                int key1 = o1.getKey();
                int key2 = o2.getKey();
                return key1 - key2;
            }
        });

        minDist[0] = 0;
        pq.offer(new Pair<>(minDist[0], 0));
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> pair = pq.poll();
            int vertex = pair.getValue();
            visited[vertex] = true;
            List<Edge> list = graph.list[vertex];
            for (int i = 0; i < list.size(); i++) {
                Edge edge = list.get(i);
                if (!visited[edge.end]) {
                    int destination = edge.end;
                    int curDist = minDist[vertex] + edge.weight;
                    if (curDist < minDist[destination]) {
                        pq.offer(new Pair<>(curDist, destination));
                        minDist[destination] = curDist;
                    }
                }
            }
        }
    }

}

class Pair<I extends Number, I1 extends Number> {
    Integer a;
    Integer b;
    public Pair(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    public Integer getKey() {
        return a;
    }

    public Integer getValue() {
        return b;
    }
}


