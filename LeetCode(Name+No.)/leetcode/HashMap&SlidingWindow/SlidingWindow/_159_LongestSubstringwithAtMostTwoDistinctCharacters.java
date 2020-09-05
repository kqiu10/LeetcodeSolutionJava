package SlidingWindow;
/**
 * Package Name : SlidingWindow;
 * File name : _159_LongestSubstringwithAtMostTwoDistinctCharacters;
 * Creator: Kane;
 * Date: 9/4/20
 */

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
 * Description: TODO
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
