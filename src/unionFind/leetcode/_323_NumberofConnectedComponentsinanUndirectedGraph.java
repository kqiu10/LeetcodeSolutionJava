package src.unionFind.leetcode;
/**
 * Date: 9/21/20
 * Question Description
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of
 * nodes), write a function to find the number of connected components in an undirected graph.
 *
 * Example 1:
 *
 * Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
 *
 *      0          3
 *      |          |
 *      1 --- 2    4
 *
 * Output: 2
 * Example 2:
 *
 * Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
 *
 *      0           4
 *      |           |
 *      1 --- 2 --- 3
 *
 * Output:  1
 *
 */

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class _323_NumberofConnectedComponentsinanUndirectedGraph {
    /**
     * 节点个数
     */
    static int count;
    static int res;

    /**
     * 节点
     */
    private static int[] id;




    //O(N)
    public static void union(int x, int y) {
        int A = find(x);
        int B = find(y);
        if (A == B) return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == A) {
                id[i] = B;
            }
        }
        res--;
    }

    //O(1)
    public static int find(int index) {
        if (index < 0 || index > id.length) {
            throw new IllegalArgumentException("越界");
        }
        return id[index];
    }

    public static int countComponents(int n, int[][] edges) {
        res = n;
        count = n;
        id = new int[count];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }

        for (int[] pair : edges) {
            int A = pair[0];
            int B = pair[1];
            union(A, B);
        }
        return res;

    }

    public static void main(String[] args) {
        countComponents(5, new int[][]{{0, 1}, {1, 2}, {3, 4}});
    }

}
