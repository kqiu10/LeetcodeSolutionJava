package graph.prim;
/**
 * Date: 10/3/20
 * Question Description
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Description: TODO
 * Time complexity:O(VlogV + ElogV);
 * Space complexity: O();

 */
public class Prim {
    public void primMST(Graph graph) {
        boolean[] visited = new boolean[graph.vertices];
        int[] minDists = new int[graph.vertices];
        int[] parents = new int[graph.vertices];

        Arrays.fill(minDists, Integer.MAX_VALUE);
        Arrays.fill(parents, -1);

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(graph.vertices, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                int key1 = o1.getKey();
                int key2 = o2.getKey();
                return key1 - key2;
            }
        });

        minDists[0] = 0;
        pq.offer(new Pair<>(minDists[0], 0));
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> pair = pq.poll();
            int vertex = pair.getValue();
            visited[vertex] = true;
            List<Edge> list = graph.list[vertex];
            for (int i = 0; i < list.size(); i++) {
                Edge edge = list.get(i);
                if (!visited[edge.end]) {
                    int destination = edge.end;
                    int curDist = edge.weight;
                    if (curDist < minDists[destination]) {
                        pq.offer(new Pair<>(curDist, destination));
                        parents[destination] = vertex;
                        minDists[destination] = curDist;
                    }
                }
            }

        }

    }
    public static void main(String[] args) {

        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 6);

        graph.addEdge(0, 2, 1);

        graph.addEdge(0, 3, 5);

        graph.addEdge(1, 2, 5);

        graph.addEdge(1, 4, 3);

        graph.addEdge(2, 4, 6);

        graph.addEdge(2, 3, 5);

        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 5, 2);

        graph.addEdge(4, 5, 6);
        Prim prim = new Prim();
        prim.primMST(graph);


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
