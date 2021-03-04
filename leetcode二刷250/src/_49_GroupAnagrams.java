/**
 * Date: 3/4/21
 * Question Description:
 * Given an array of strings strs, group the anagrams together. You can return the answer in any
 * order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or
 * phrase, typically using all the original letters exactly once.
 * <p>
 * Examples:
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
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Time Complexity: O(n * max(str.length())
 * Space Complexity: O(n)
 */
public class _49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String cur = translateStr(str);
            if (map.containsKey(cur)) {
                List<String> list = map.get(cur);
                list.add(str);
                map.put(cur, list);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(cur, newList);
            }
        }
        res.addAll(map.values());
        return res;

    }
    private String translateStr(String str) {
        String res = "";
        int[] digits = new int[26];
        for (int i = 0; i < str.length(); i++) {
            digits[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 0) {
                res += String.valueOf(digits[i]) + String.valueOf((char)i + 'a');
            }
        }
        return res;
    }
}
