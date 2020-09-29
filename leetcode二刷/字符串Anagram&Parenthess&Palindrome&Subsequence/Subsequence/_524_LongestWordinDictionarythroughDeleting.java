package Subsequence;
/**
 * Package Name : Subsequence;
 * File name : _524_LongestWordinDictionarythroughDeleting;
 * Creator: Kane;
 * Date: 9/6/20
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string and a string dictionary, find the longest string in the dictionary that can be
 * formed by deleting some characters of the given string. If there are more than one possible
 * results, return the longest word with the smallest lexicographical order. If there is no
 * possible result, return the empty string.
 *
 * Example 1:
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 *
 * Output:
 * "apple"
 * Example 2:
 * Input:
 * s = "abpcplea", d = ["a","b","c"]
 *
 * Output:
 * "a"
 *
 * Time complexity:O(n^2);
 * Space complexity: O(1);
 * Description: TODO
 */
public class _524_LongestWordinDictionarythroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String str : d) {
            if (isSubsequence(str, s)) {
                if (str.length() > res.length() || (str.length() == res.length() && str.compareTo(res) < 0)) {
                    res = str;
                }
            }
        }
        return res;

    }
    private boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) i++;
            j++;
        }
        return i == s.length();
    }
}
