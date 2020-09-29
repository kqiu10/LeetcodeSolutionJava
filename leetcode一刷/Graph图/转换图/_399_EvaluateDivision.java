package leetcode.Graph图.转换图;
/**
 * Date: 9/22/20
 * Question Description
 * You are given equations in the format A / B = k, where A and B are variables represented as
 * strings, and k is a real number (floating-point number). Given some queries, return the
 * answers. If the answer does not exist, return -1.0.
 *
 * The input is always valid. You may assume that evaluating the queries will result in no
 * division by zero and there is no contradiction.
 *
 *
 *
 * Example 1:
 *
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],
 * ["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * Example 2:
 *
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a",
 * "c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 * Example 3:
 *
 * Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x",
 * "y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Time complexity:O(V + E);
 * Space complexity: O(V);
 * Description:
 * map : "a" 'b', 2.0
 *       "b" 'a', 1/2.0
 *           'c', 3.0
 *       "c" 'b', 1/3.0
 */
public class _399_EvaluateDivision {
    HashMap<String, List<GraphNode>> map = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            if (!map.containsKey(equation.get(0))) {
                map.put(equation.get(0), new ArrayList<>());
            }
            map.get(equation.get(0)).add(new GraphNode(equation.get(1), values[i]));
            if (!map.containsKey(equation.get(1))) {
                map.put(equation.get(1), new ArrayList<>());
            }
            map.get(equation.get(1)).add(new GraphNode(equation.get(0), 1 / values[i]));
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = find(queries.get(i).get(0), queries.get(i).get(1), 1, new HashSet<>());
        }
        return res;
    }

    private double find(String start, String end, double val, HashSet<String> visited) {
        if (!map.containsKey(start)) return -1;
        if (start.equals(end)) return val;
        if (visited.contains(start)) return -1;
        visited.add(start);
        for (GraphNode next : map.get(start)) {
            double sub = find(next.den, end, val * next.val, visited);
            if (sub != -1.0) return sub;
        }
        visited.remove(start);
        return -1;
    }

    class GraphNode {
        String den;
        double val;
        GraphNode(String den, double val) {
            this.den = den;
            this.val = val;
        }
    }
}
