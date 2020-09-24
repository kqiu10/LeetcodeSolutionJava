package leetcode.Graph图.并查集;
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
 * Time complexity:O(edges * nodes);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _323_NumberofConnectedComponentsinanUndirectedGraph {

    public static int countComponents(int n, int[][] edges) {
        int res = n;
        int[] parents = new int[n];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        for (int[] pair : edges) {
            int xRoot = find(pair[0], parents);
            int yRoot = find(pair[1], parents);
            if (xRoot != yRoot) {
                parents[xRoot] = yRoot;
                res--;
            }
        }
        return res;
    }

    /**
     * 面试推荐
     * @param index
     * @param parents
     * @return
     */
    public static int find(int index, int[] parents) {
        while (index != parents[index]) {
            index = parents[index];
        }
        return index;
    }

    /**
     * 效率更高，路径压缩
     */
    public int find2(int index, int[] parents) {
        while (index != parents[index]) {
            parents[index] = parents[parents[index]];
            index = parents[index];
        }
        return index;
    }


    public static void main(String[] args) {
        countComponents(5, new int[][]{{0, 1}, {1, 2}, {3, 4}});
    }

}

