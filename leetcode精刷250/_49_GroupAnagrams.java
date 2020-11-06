/**
 * Date: 11/5/20
 * Question Description
 Given an array of strings strs, group the anagrams together. You can return the answer in any order.

 An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 Example 1:

 Input: strs = ["eat","tea","tan","ate","nat","bat"]
 Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 Example 2:

 Input: strs = [""]
 Output: [[""]]
 Example 3:

 Input: strs = ["a"]
 Output: [["a"]]
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String raw = getRaw(str);
            if (!map.containsKey(raw)) {
                map.put(raw, new ArrayList<>());
            }
            List<String> list = map.get(raw);
            list.add(str);
            map.put(raw, list);
        }
        for (List<String> val : map.values()) {
            res.add(val);
        }
        return res;
    }
    private String getRaw(String raw) {
        String res = "";
        int[] digits = new int[26];
        for (int i = 0; i < raw.length(); i++) {
            digits[raw.charAt(i) - 'a']++;
        }
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 0) {
                res += String.valueOf(digits[i]) + String.valueOf((char)(i + 'a'));
            }
        }
        return res;
    }
}
