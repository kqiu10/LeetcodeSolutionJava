package com.google.src;
/**
 * Date: 4/21/21
 * Question Description:
 * You are given an array of transactions transactions where transactions[i] = [fromi, toi,
 * amounti] indicates that the person with ID = fromi gave amounti $ to the person with ID = toi.
 *
 * Return the minimum number of transactions required to settle the debt.
 * <p>
 * Examples:
 *
 * Example 1:
 * Input: transactions = [[0,1,10],[2,0,5]]
 * Output: 2
 * Explanation:
 * Person #0 gave person #1 $10.
 * Person #2 gave person #0 $5.
 * Two transactions are needed. One way to settle the debt is person #1 pays person #0 and #2 $5
 * each.
 *
 * Example 2:
 * Input: transactions = [[0,1,10],[1,0,1],[1,2,5],[2,0,5]]
 * Output: 1
 * Explanation:
 * Person #0 gave person #1 $10.
 * Person #1 gave person #0 $1.
 * Person #1 gave person #2 $5.
 * Person #2 gave person #0 $5.
 * Therefore, person #1 only need to give person #0 $4, and all debt is settled.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Time Complexity: O(n!)
 * Space Complexity: O(n)
 */
public class _465_OptimalAccountBalancing {
    int count;
    public int minTransfers(int[][] transactions) {
        count = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] transaction : transactions) {
            map.put(transaction[0], map.getOrDefault(transaction[0], 0) - transaction[2]);
            map.put(transaction[1], map.getOrDefault(transaction[1], 0) + transaction[2]);
        }

        List<Integer> list = new ArrayList<>();
        for (Integer value : map.values()) {
            if (value != 0) {
                list.add(value);
            }
        }
        helper(list, 0, 0);
        return count;
    }

    private void helper(List<Integer> list, int start, int transaction) {
        while (start < list.size() && list.get(start) == 0) {
            start++;
        }
        if (start == list.size()) {
            count = Math.min(count, transaction);
            return;
        }
        for (int i = start + 1; i < list.size(); i++) {
            if ((list.get(start) < 0 && list.get(i) > 0) || (list.get(start) > 0 && list.get(i) < 0)) {
                list.set(i, list.get(start) + list.get(i));
                helper(list, start + 1, transaction + 1);
                list.set(i, list.get(i) - list.get(start));
            }
        }
    }

}
