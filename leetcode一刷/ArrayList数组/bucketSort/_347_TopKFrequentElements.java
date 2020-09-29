package leetcode.数组;
/**
 * Description: TODO
 * Package Name : leetcode;
 * File name : _347_TopKFrequentElements;
 * Creator: Kane;
 * Date: 7/19/20
 */

import java.util.*;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: bucketSort;
 */
public class _347_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int num : map.keySet()) {
            int freq = map.get(num);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        }
        List<Integer> res = new ArrayList<>();
        /**
         * 一次加多个元素
         */
        for (int i = bucket.length -1 ; i >= 0 && res.size() < k; i--) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
            }
            /**
             * 一次加一个元素
             * for (int i = bucket.length - 1; i >= 0) {
             *     while (bucket[i] != null && j < bucket[i].size() && k > 0) {
             *         res.add(bucket[i].get(j++));
             *         k--;
             *     }
             * }
             * */


        }
        /**
         * convert List[] to int[];
         */
        int size = res.size();
        int[] result = new int[size];
        Integer[] temp = res.toArray(new Integer[size]);
        for (int n = 0; n < size; n++) {
            result[n] = temp[n];
        }
        return result;
    }

}


/**
 * Time complexity:O(nlogn);
 * Space complexity: O(n);
 * Description: PriorityQueue;
 */
class topKFrequentII{
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) ->(b.getValue() - a.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap .add(entry);
        }
        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            Map.Entry<Integer,Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        int size = res.size();
        int[] result = new int[size];
        Integer[] temp = res.toArray(new Integer[size]);
        for (int n = 0; n < size; n++) {
            result[n] = temp[n];
        }
        return result;
    }


    /**
     * Time complexity:O(nlogn);
     * Space complexity: O(n);
     * Description: TreeMap;
     */
    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{1, 1, 1, 2, 2, 3},2));
    }
}



class topKFrequentIII{
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for (int num : map.keySet()) {
            int freq = map.get(num);
            if (!freqMap.containsKey(freq)) {
                freqMap.put(freq, new LinkedList<>());
            }
            freqMap.get(freq).add(num);
        }
        List<Integer> res = new LinkedList<>();
        while (res.size() < k) {
            Map.Entry<Integer,List<Integer>> entry = freqMap.pollLastEntry();
            res.addAll(entry.getValue());
        }
        int size = res.size();
        int[] result = new int[size];
        Integer[] temp = res.toArray(new Integer[size]);
        for (int n = 0; n < size; n++) {
            result[n] = temp[n];
        }
        return result;
    }
}
