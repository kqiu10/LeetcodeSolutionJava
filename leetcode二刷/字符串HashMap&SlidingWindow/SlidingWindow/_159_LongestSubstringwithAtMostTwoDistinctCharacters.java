package SlidingWindow;
/**
 * Package Name : SlidingWindow;
 * File name : _159_LongestSubstringwithAtMostTwoDistinctCharacters;
 * Creator: Kane;
 * Date: 9/4/20
 */

import java.util.HashMap;

/**
 * Given a string s , find the length of the longest substring t  that contains at most 2
 * distinct characters.
 *
 * Example 1:
 *
 * Input: "eceba"
 * Output: 3
 * Explanation: t is "ece" which its length is 3.
 * Example 2:
 *
 * Input: "ccaabbb"
 * Output: 5
 * Explanation: t is "aabbb" which its length is 5.
 *
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: without extra space
 */
public class _159_LongestSubstringwithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() == 0 || s == null) return 0;
        int[] count = new int[128];
        int res = 0;
        int sum = 0, j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)]++ == 0) sum++;
            if (sum > 2) {
                while(--count[s.charAt(j++)] > 0);
                sum--;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

}
/**
 *
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: HashMap
 * eceba
 */
class LongestSubstringwithAtMostTwoDistinctCharactersII {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() == 0 || s == null) return 0;
        int[] count = new int[128];
        int res = 0;
        int start = 0, end = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (end < s.length()) {
            if (map.size() <= 2) {
                map.put(s.charAt(end), end);
                end++;
            }
            if (map.size() > 2) {
                int leftMost = s.length();
                for (int num : map.values()) {
                    leftMost = Math.min(leftMost, num);
                }
                map.remove(s.charAt(leftMost));
                start = leftMost + 1;
            }
            res = Math.max(res, end - start);
        }
        return res;
    }
}