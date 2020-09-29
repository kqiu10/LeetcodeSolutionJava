package Anagram;
/**
 * Package Name : Anagram;
 * File name : _49_GroupAnagram;
 * Creator: Kane;
 * Date: 9/4/20
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any
 * order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or
 * phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 * Time complexity:O(m * n); m : length of strs, n : max(str in strs)
 * Space complexity: O(n);
 * Description: TODO
 */
public class _49_GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        if (strs.length == 0) return res;
        for (String str : strs) {
            String count = CountSort(str);
            if (map.containsKey(count)) {
                List<String> list = map.get(count);
                list.add(str);
                map.put(count, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(count, list);
            }
        }
        for (List<String> val : map.values()) {
            res.add(val);
        }
        // 或者 return new ArrayList<>(map.values());
        return res;

    }
    private String CountSort(String s) {
        String res = "";
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                res += String.valueOf(count[i]) + String.valueOf((char)(i + 'a'));
            }
        }
        return res;
    }
}
