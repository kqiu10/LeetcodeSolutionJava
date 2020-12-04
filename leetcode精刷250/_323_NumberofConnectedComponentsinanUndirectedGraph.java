/**
 * Date: 12/4/20
 * Question Description
 Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

 Example 1:

 Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]

 0          3
 |          |
 1 --- 2    4

 Output: 2
 Example 2:

 Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]

 0           4
 |           |
 1 --- 2 --- 3

 Output:  1
 */

/**
 * Description: TODO
 * Time complexity:O(edges * nodes);
 * Space complexity: O(n);

 */
public class _323_NumberofConnectedComponentsinanUndirectedGraph {
    public static int countComponents(int n, int[][] edges) {
        int res = n;
        int[] parents = new int[n];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        for (int[] edge : edges) {
            int xRoot = find(edge[0], parents);
            int yRoot = find(edge[1], parents);
            if (xRoot != yRoot) {
                parents[yRoot] = xRoot;
                res--;
            }
        }
        return res;
    }
    private static int find(int i, int[] parents) {
        while (parents[i] != i) {
            i = parents[i];
        }
        return i;
    }

    public static void main(String[] args) {
        countComponents(5, new int[][]{{0, 1}, {1, 2}, {0, 2}, {3, 4}});
    }
}
