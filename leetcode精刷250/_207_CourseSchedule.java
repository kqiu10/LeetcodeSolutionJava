/**
 * Date: 11/21/20
 * Question Description
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int res = numCourses;
        Queue<Integer> queue = new LinkedList<>();
        int[] degree = new int[numCourses];
        for (int[] course : prerequisites) {
            degree[course[0]]++;
        }
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            res--;
            for (int[] course : prerequisites) {
                if (course[1] == pre) {
                    degree[course[0]]--;
                    if (degree[course[0]] == 0) {
                        queue.offer(course[0]);
                    }
                }
            }
        }
        return res == 0;
    }
}
