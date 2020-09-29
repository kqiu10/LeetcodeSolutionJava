package leetcode.Graph图.拓扑排序;
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
        int[] res = new int[numCourses];
        int k = 0;

        int[] indegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            indegree[pair[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                res[k++] = i;
            }
        }

        while (!queue.isEmpty()) {
            int pre = queue.poll();
            for (int[] pair : prerequisites) {
                if (pair[1] == pre) {
                    indegree[pair[0]]--;
                    if (indegree[pair[0]] == 0) {
                        queue.offer(pair[0]);
                        res[k++] = pair[0];
                    }
                }
            }
        }
        return k == numCourses ? res : new int[0];
    }

}
