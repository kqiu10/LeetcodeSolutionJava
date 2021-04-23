package com.google.src;
/**
 * Date: 4/21/21
 * Question Description:
 * Given a string s and an array of strings words, return the number of words[i] that is a
 * subsequence of s.
 *
 * A subsequence of a string is a new string generated from the original string with some
 * characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * <p>
 *
 * Examples:
 * Example 1:
 *
 * Input: s = "abcde", words = ["a","bb","acd","ace"]
 * Output: 3
 * Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
 * Example 2:
 *
 * Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * Output: 2
 */

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Time Complexity: O()
 * Space Complexity: O()
 */
public class _792_NumberofMatchingSubsequences {
    public int numMatchingSubseq(String s, String[] words) {
        TreeMap<Character, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }
            List<Integer> list = map.get(c);
            list.add(i);
            map.put(c, list);
        }
        return 0;
    }

    public static void main(String[] args) {

        _792_NumberofMatchingSubsequences test = new _792_NumberofMatchingSubsequences();
        test.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"});
    }



}
