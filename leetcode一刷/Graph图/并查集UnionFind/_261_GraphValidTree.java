package leetcode.Graph图.并查集UnionFind;
/**
 * Date: 9/23/20
 * Question Description
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of
 * nodes), write a function to check whether these edges make up a valid tree.
 *
 * Example 1:
 *
 * Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
 * Output: true
 * Example 2:
 *
 * Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
 * Output: false
 * Note: you can assume that no duplicate edges will appear in edges. Since all edges are
 * undirected, [0,1] is the same as [1,0] and thus will not appear together in edges.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class _261_GraphValidTree {
    /**
     * Description: DFS
     * Time complexity:O(E * V);
     * Space complexity: O(n);
     */
    public static boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);

        boolean res = helper(graph, visited, 0, -1);
        if (res == false) return false;
        return visited.size() == n ? true : false;

    }

    private static boolean helper(List<List<Integer>> graph, HashSet<Integer> visited, int node, int parent) {
        List<Integer> sub = graph.get(node);
        for (int v : sub) {
            if (v == parent) continue;
            if (visited.contains(v)) {
                return false;
            } else {
                visited.add(v);
                return helper(graph, visited, v, node);
            }
        }
        return true;
    }

    /**
     * Description: UnionFind
     * Time complexity:O(E * V);
     * Space complexity: O(n);
     */
    public boolean validTreeII(int n, int[][] edges) {
        if (n == 1 && edges.length == 0) return true;
        if (n < 1 || edges == null || edges.length != n - 1) return false;

        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = -1;
        }
        for (int[] pair : edges) {
            int x = find(roots, pair[0]);
            int y = find(roots, pair[1]);
            if (x == y) return false;
            roots[x] = y;
        }
        return true;
    }
    private int find(int[] roots, int i) {
        while (roots[i] != -1) {
           i = roots[i];
        }
        return i;
    }

    public static void main(String[] args) {
        validTree(5, new int[][]{{0, 1},{0, 2},{0, 3}, {1, 4}});
    }
}
