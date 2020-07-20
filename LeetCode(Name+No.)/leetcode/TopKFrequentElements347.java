package leetcode;
/**
 * Description: TODO
 * Package Name : leetcode;
 * File name : TopKFrequentElements347;
 * Creator: Kane;
 * Date: 7/19/20
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Best Time complexity: O();
 * Worst Time complexity: O();
 * Average Time complexity:O();
 * Space complexity: O();
 */
public class TopKFrequentElements347 {
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
        for (int i = bucket.length -1 ; i >= 0 && res.size() < k; i--) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
            }

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
