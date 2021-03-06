package leetcode.数组;
/**
 * Package Name : leetcode.数组;
 * File name : _451_SortCharactersByFrequency;
 * Creator: Kane;
 * Date: 7/31/20
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _451_SortCharactersByFrequency {
    public static String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character>[] bucket = new List[s.length() + 1];
        for (char c : map.keySet()) {
            int freq = map.get(c);
            if (bucket[freq] == null) {
                bucket[freq] = new LinkedList<>();
            }
                bucket[freq].add(c);

        }
        StringBuilder sb = new StringBuilder();
        for (int i = bucket.length - 1; i > 0; i--) {
            if (bucket[i] != null) {
                for (char c : bucket[i]) {
                    for (int j = 0; j < map.get(c); j++) {
                        sb.append(c);
                    }
                }
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        frequencySort("tree");
    }
}
