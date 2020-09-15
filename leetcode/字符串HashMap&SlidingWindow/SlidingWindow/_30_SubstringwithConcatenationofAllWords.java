package SlidingWindow;
/**
 * Package Name : SlidingWindow;
 * File name : _30_SubstringwithConcatenationofAllWords;
 * Creator: Kane;
 * Date: 9/4/20
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * You are given a string s and an array of strings words of the same length. Return all starting
 * indices of substring(s) in s that is a concatenation of each word in words exactly once, in
 * any order, and without any intervening characters.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * Example 2:
 *
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * Output: []
 * Example 3:
 *
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * Output: [6,9,12]
 *
 * Time complexity:O(n ^ 2);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _30_SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.length() == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int n = words.length;
        int m = words[0].length();
        for (int i = 0; i <= s.length() - m *n; i++) {
            HashMap<String, Integer> copy = new HashMap<>(map);
            int k = n;
            int j = i;
            while (k > 0) {
                String str = s.substring(j, j + m);
                if (!copy.containsKey(str) || copy.get(str) < 1) {
                    break;
                }
                copy.put(str, copy.get(str) - 1);
                j += m;
                k--;

            }
            if (k == 0) res.add(i);
        }
        return res;
    }
}
