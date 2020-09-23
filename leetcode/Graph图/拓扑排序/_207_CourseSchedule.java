package leetcode.Graph图.拓扑排序;
/**
 * Date: 9/22/20
 * Question Description
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take
 * course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to
 * finish all courses?
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 *
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Time complexity:O(V + E);
 * Space complexity: O(V);
 * Description:
 * 0 - 1 - 2
 *        /
 *   3 - 4 => [4,3]
 * Ex 入度
 *    0 : 0
 *    1 : 1
 *    2 : 2
 *    3 : 0
 *    4 : 0
 *    queue
 *    pre : 0
 *    res = 3
 */
public class _207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int res = numCourses;
        Queue<Integer> queue = new LinkedList<>();

        int[] degree = new int[numCourses];
        for (int[] pair : prerequisites) {
            degree[pair[0]]++;
        }
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()) {
            int pre = queue.poll();
            res--;
            for (int[] pair :prerequisites) {
                if (pair[1] == pre) {
                    degree[pair[0]]--;
                    if (degree[pair[0]] == 0) {
                        queue.offer(pair[0]);
                    }
                }
            }
        }
        return res == 0;

    }
}
