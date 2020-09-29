package leetcode.BackTracking回溯法.实现题;
/**
 * Date: 9/18/20
 * Question Description
 * A group of friends went on holiday and sometimes lent each other money. For example, Alice
 * paid for Bill's lunch for $10. Then later Chris gave Alice $5 for a taxi ride. We can model
 * each transaction as a tuple (x, y, z) which means person x gave person y $z. Assuming Alice,
 * Bill, and Chris are person 0, 1, and 2 respectively (0, 1, 2 are the person's ID), the
 * transactions can be represented as [[0, 1, 10], [2, 0, 5]].
 *
 * Given a list of transactions between a group of people, return the minimum number of
 * transactions required to settle the debt.
 *
 * Note:
 *
 * A transaction will be given as a tuple (x, y, z). Note that x ≠ y and z > 0.
 * Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2 or we could also have
 * the persons 0, 2, 6.
 * Example 1:
 *
 * Input:
 * [[0,1,10], [2,0,5]]
 *
 * Output:
 * 2
 *
 * Explanation:
 * Person #0 gave person #1 $10.
 * Person #2 gave person #0 $5.
 *
 * Two transactions are needed. One way to settle the debt is person #1 pays person #0 and #2 $5
 * each.
 * Example 2:
 *
 * Input:
 * [[0,1,10], [1,0,1], [1,2,5], [2,0,5]]
 *
 * Output:
 * 1
 *
 * Explanation:
 * Person #0 gave person #1 $10.
 * Person #1 gave person #0 $1.
 * Person #1 gave person #2 $5.
 * Person #2 gave person #0 $5.
 *
 * Therefore, person #1 only need to give person #0 $4, and all debt is settled.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Time complexity:O(n!);
 * Space complexity: O(n);
 * Description: HashMap and BackTracking
 */
public class _465_OptimalAccountBalancing {
    int res;
    public int minTransfers(int[][] transactions) {
        res = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] transaction : transactions) {
            map.put(transaction[0], map.getOrDefault(transaction[0], 0) - transaction[1]);
            map.put(transaction[0], map.getOrDefault(transaction[0], 0) + transaction[1]);
        }
        List<Integer> debt = new ArrayList<>();
        for (int val : map.values()) {
            if (val != 0) {
                debt.add(val);
            }
        }
        helper(debt, 0, 0);
        return res;

    }
    private void helper(List<Integer> debt, int start, int count) {
        while (start < debt.size() && debt.get(start) == 0) {
            start++;
        }
        if (start == debt.size()) {
            res = Math.min(res, count);
        }
        for (int i = start + 1; i < debt.size(); i++) {
            if ((debt.get(start) < 0 && debt.get(i) > 0) || (debt.get(start) > 0 && debt.get(i) < 0)) {
                debt.set(i, debt.get(i) + debt.get(start));
                helper(debt, start + 1, count + 1);
                debt.set(i, debt.get(i) - debt.get(start));
            }
        }
    }
}
