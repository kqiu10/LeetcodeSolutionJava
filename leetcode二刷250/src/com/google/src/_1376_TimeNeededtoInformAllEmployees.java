package com.google.src;
/**
 * Date: 4/18/21
 * Question Description:
 * A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the
 * company is the one with headID.
 *
 * Each employee has one direct manager given in the manager array where manager[i] is the direct
 * manager of the i-th employee, manager[headID] = -1. Also, it is guaranteed that the
 * subordination relationships have a tree structure.
 *
 * The head of the company wants to inform all the company employees of an urgent piece of news.
 * He will inform his direct subordinates, and they will inform their subordinates, and so on
 * until all employees know about the urgent news.
 *
 * The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e.,
 * After informTime[i] minutes, all his direct subordinates can start spreading the news).
 *
 * Return the number of minutes needed to inform all the employees about the urgent news.
 *
 *
 * <p>
 * Examples:
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class _1376_TimeNeededtoInformAllEmployees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] == -1) continue;
            if (!map.containsKey(manager[i])) {
                map.put(manager[i], new ArrayList<>());
            }
            map.get(manager[i]).add(i);
        }
        return dfs(map, informTime, headID);

    }
    private int dfs(HashMap<Integer, List<Integer>> map, int[] informTime, int curID) {
        int max = 0;
        if (!map.containsKey(curID)) {
            return max;
        }
        for (int i = 0; i < map.get(curID).size(); i++) {
            max = Math.max(max, dfs(map, informTime, map.get(curID).get(i)));
        }
        return max + informTime[curID];
    }
}
