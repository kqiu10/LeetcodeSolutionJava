package com.antra;
/**
 * Date: 4/25/21
 * Question Description:
 * <p>
 * Examples:
 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Time Complexity: O(nlogk)
 * Space Complexity: O(k)
 */
public class _347_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> (a.getValue() - b.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int j = 0;
        while (!pq.isEmpty()) {
            res[j++] = pq.poll().getKey();
        }
        return res;
    }
}
