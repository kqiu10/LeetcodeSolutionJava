package src.graph.topological;
/**
 * Date: 9/20/20
 * Question Description
 * There are a total of n courses you have to take labelled from 0 to n - 1.
 *
 * Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means
 * you must take the course bi before the course ai.
 *
 * Given the total number of courses numCourses and a list of the prerequisite pairs, return the
 * ordering of courses you should take to finish all courses.
 *
 * If there are many valid answers, return any of them. If it is impossible to finish all
 * courses, return an empty array.
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 * course 0. So the correct course order is [0,1].
 * Example 2:
 *
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished
 * both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * Example 3:
 *
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 *
 */

import java.util.*;

/**
 * Time complexity:O(V + E);
 * Space complexity: O(V);
 * Description: TODO
 */
public class _210_CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        /**
         * 预处理
         */
        List<List<Integer>> graph = new LinkedList<>();
        for (int i = 0; i < graph.size(); i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int prev = pair[1];
            int next = pair[0];
            graph.get(prev).add(next);
        }

        /**
         * DFS
         * 0 :unvisited, 1: visiting, 2 :visited;
         */
        HashMap<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            visited.put(i, 0);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (visited.get(i) == 0) {
                if (!helper(graph, visited, res, i)) {
                    return new int[]{0};
                }
            }
        }
        /**
         * cuz we add leaf node first, so we need to reverse the array
         */
        int[] result = new int[numCourses];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(numCourses - i - 1);
        }
        return result;

    }
    private boolean helper(List<List<Integer>> graph, HashMap<Integer, Integer> visited, List<Integer> res, int index) {
        if (visited.get(index) == 2) {
            return true;
        }
        if (visited.get(index) == 1) {
            return false;
        }
        visited.put(index, 1);
        for (int pos : graph.get(index)) {
            if (!helper(graph, visited, res, pos)) {
                return false;
            }
        }
        visited.put(index, 2);
        res.add(index);
        return true;
    }
}
