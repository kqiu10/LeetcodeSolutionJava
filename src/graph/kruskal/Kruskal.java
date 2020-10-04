package graph.kruskal;
/**
 * Date: 10/3/20
 * Question Description
 */


/**
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

 */
public class Kruskal {
    public void KruskalMST(Graph graph) {

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
        Kruskal kruskal = new Kruskal();
        kruskal.KruskalMST(graph);


    }
}
