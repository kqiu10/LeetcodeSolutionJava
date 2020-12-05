/**
 * Date: 12/5/20
 * Question Description
 Given a non-empty array of integers, return the k most frequent elements.

 Example 1:

 Input: nums = [1,1,1,2,2,3], k = 2
 Output: [1,2]
 Example 2:

 Input: nums = [1], k = 1
 Output: [1]
 */

import java.util.*;


public class _347_TopKFrequentElements {
    /**
     * Description: PriorityQueue
     * Time complexity:O(nlogn);
     * Space complexity: O(n);
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return new int[]{0};
        int[] res = new int[k];
        int index = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }
        while (index < k) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            res[index++] = entry.getKey();
        }
        return res;
    }
    /**
     * Description: BuckedSort
     * Time complexity:O(n);
     * Space complexity: O(n);
     */
    public int[] topKFrequentII(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        int index = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for (int num : map.keySet()) {
            int freq = map.get(num);
            if (bucket[freq] == null) {
                bucket[freq] = new LinkedList<>();
            }
            bucket[freq].add(num);
        }
        for (int i = bucket.length - 1; i>= 0; i--) {
            int j = 0;
            while (bucket[i] != null && j < bucket[i].size() && k > 0) {
                res[index++] = bucket[i].get(j++);
                k--;
            }
        }
        return res;
    }
}
