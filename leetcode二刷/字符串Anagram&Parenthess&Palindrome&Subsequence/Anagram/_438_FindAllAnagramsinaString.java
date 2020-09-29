package Anagram;
/**
 * Package Name : Anagram;
 * File name : _438_FindAllAnagramsinaString;
 * Creator: Kane;
 * Date: 9/4/20
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will
 * not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class _438_FindAllAnagramsinaString {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) return res;
        int[] cp = new int[26];
        for (char c : p.toCharArray()) {
            cp[c - 'a']++;
        }
        int start = 0, end = 0;
        int count = p.length();
        while (end < s.length()) {
            if (end - start == p.length() && cp[s.charAt(start++) - 'a']++ >= 0) {
                count++;
            }
            if (--cp[s.charAt(end++) - 'a'] >= 0) {
                count--;
            }
            if (count == 0) {
                res.add(start);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        findAnagrams("cbaebabacd", "abc");
    }
}
